document.addEventListener("DOMContentLoaded", function() {
	//DOMContentLoaded : DOM이 완전히 로딩된 후 실행
	const form = document.getElementById("joinForm") || document.querySelector("form");
	//joinForm이 있으면 그걸 사용하고 없으면 첫번째 form 태그 사용
	const base = (form && form.dataset.contextPath) ? form.dataset.contextPath : "";
	// form 이 존재하는지 확인, <form data-context-path="">
	// fetch(`${base}/서블릿경로`)

	const idInput = document.getElementById("id");
	const passwordInput = document.getElementById("password");
	const passwordConfirmInput = document.getElementById("passwordConfirm");
	const sendSMSBtn = document.getElementById("sendSMSBtn");
	const phoneNumberInput = document.getElementById("phoneNumber");
	const verificationCodeInput = document.getElementById("verificationCode");
	const agreeCheckbox = document.getElementById("agree");

	const checkIdMsg = document.getElementById("check-id-msg");
	const checkPwMsg = document.getElementById("check-pw-msg");
	const checkPwConfirmMsg = document.getElementById("check-pw-confirm-msg");
	const verificationStatus = document.getElementById("verification-status");

	// ====== 카카오 우편번호 ======
	const searchBtn = document.getElementById("searchPostcodeBtn");
	if (searchBtn) {
		searchBtn.addEventListener("click", function() {
			new daum.Postcode({
				oncomplete: function(data) {
					document.getElementById("postcode").value = data.zonecode || "";

					var isRoad = data.userSelectedType === "R";
					var base = isRoad ? (data.roadAddress || "") : (data.jibunAddress || "");
					var extra = "";

					if (isRoad) {
						if (data.bname && /[동|로|가]$/.test(data.bname)) extra += data.bname;
						if (data.buildingName && data.apartment === "Y") {
							extra += (extra ? ", " : "") + data.buildingName;
						}
					}

					var main = base + (extra ? " (" + extra + ")" : "");
					document.getElementById("mainAddress").value = main;

					document.getElementById("detailAddress").focus();
				}
			}).open({ popupTitle: "우편번호 검색" });
		});
	}

	/*=====아이디 중복 검사=====*/
	idInput.addEventListener("change", () => {
		const memberId = idInput.value.trim();
		if (!memberId) {
			checkIdMsg.textContent = "아이디를 입력해주세요.";
			checkIdMsg.style.color = "red";
			return;
		}
		// 서블릿 경로 확인 후 작성
		/*fetch(`{base/member/~~서블릿경로}`)*/
		fetch(`${base}/member/checkIdOk.me?memberId=${encodeURIComponent(memberId)}`,{
				headers:{"Accept" : "application/json"}
		}).then(r => {if(!r.ok){
			throw new Error(r.status);
		}
		return r.json();
	}).then(data => {
			if(data.available){
				checkIdMsg.textContent = "사용 가능한 아이디입니다";
				checkIdMsg.style.color="green";		
			}else{
				checkIdMsg.textContent="이미 사용중인 아이디입니다";
				checkIdMsg.style.color="red";
			}
		}).catch(() => {
			checkIdMsg.textContent="아이디 중복 검사 중 오류가 발생했습니다";
			checkIdMsg.style.color="red";
		});
	});

	//===== 비밀번호 유효성 검사 =====
	const passwordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
	// 영문 + 숫자 + 특수문자 포함 최소 8자 이상
	// ^ 문자열 시작, 정규식이 처음부터 검사하도록 함
	//(?=.*[a-zA-Z]) 영문자 최소 1개 포함
	//(?= )포함여부검사		.^ 아무문자	[a-zA-Z]대소문자 구분 없이 최소 1개 이상 포함
	//[A-Za-z\d!@#$%^&*]{8,} 사용가능한 문자 + 길이제한
	// $ 문자열 끝

	passwordInput.addEventListener("blur", function() {
		const pw = passwordInput.value.trim();
		if (passwordRegex.test(pw)) {
			checkPwMsg.textContent = "사용가능한 비밀번호 입니다"
			checkPwMsg.style.color = "green";
		}
		else {
			checkPwMsg.textContent = "비밀번호는 영문/숫자/특수문자를 포함하여 8자 이상 입력해야합니다.";
			checkPwMsg.style.color = "red";
		}
	})
	
	// 비밀번호 재확인
	passwordConfirmInput.addEventListener("blur",function(){
		const pw = passwordInput.value.trim();
		const pw2 = passwordConfirmInput.value.trim();
		if(pw&&pw===pw2){
			checkPwConfirmMsg.textContent = "비밀번호가 일치합니다."
			checkPwConfirmMsg.style.color = "green"
		}
		else{
			checkPwConfirmMsg.textContent = "비밀번호가 일치하지 않습니다."
			checkPwConfirmMsg.style.color = "red"
		}

	})
	// ===== SMS 발송 (임시 인증번호 생성) =====
	let tempCode = "";   // 임시 발급 코드 저장할 변수

	sendSMSBtn.addEventListener("click", function () {
	  const phoneNumber = phoneNumberInput.value.trim();
	  if (!phoneNumber) {
	    alert("핸드폰 번호를 입력해주세요.");
	    return;
	  }

	  // 6자리 난수 생성
	  tempCode = String(Math.floor(100000 + Math.random() * 900000));
	  console.log("임시 인증번호:", tempCode); // 콘솔 확인용

	  verificationCodeInput.disabled = false;
	  verificationStatus.textContent = "임시 인증번호(6자리)가 발급되었습니다.";
	  verificationStatus.style.color = "green";

	  alert("임시 인증번호는 [" + tempCode + "] 입니다.");
	});

	// ===== 인증번호 확인 (서버 대신 로컬 비교) =====
	verificationCodeInput.addEventListener("blur", function () {
	  const code = verificationCodeInput.value.trim();
	  if (!code) {
	    verificationStatus.textContent = "인증번호를 입력해주세요.";
	    verificationStatus.style.color = "red";
	    return;
	  }

	  if (code === tempCode) {
	    verificationStatus.textContent = "인증에 성공했습니다.";
	    verificationStatus.style.color = "green";
	    verificationCodeInput.dataset.verified = "true";
	  } else {
	    verificationStatus.textContent = "인증번호가 일치하지 않습니다.";
	    verificationStatus.style.color = "red";
	    verificationCodeInput.dataset.verified = "false";
	  }
	});
});