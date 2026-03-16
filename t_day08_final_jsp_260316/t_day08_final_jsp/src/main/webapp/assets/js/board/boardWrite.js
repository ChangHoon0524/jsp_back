// DOM 요소 가져오기
const fileInput = document.getElementById('file');
const fileList = document.querySelector('.file-list');
const cntElement = document.querySelector('.cnt');
const cancelButton = document.querySelector('.cancle-btn');
const writeForm = document.getElementById('write-form');

// 파일 첨부 미리보기 및 관리 핸들러
fileInput.addEventListener('change', (event) => {
    const files = event.target.files;
	//files는 FileList의 객체
	//파일 하나를 선택하면 files[0] 
	// => file.name(파일명), file.size(크기), file.type(MIME 타입), file.lastModified(수정시간)

    // 기존 미리보기 초기화
    fileList.innerHTML = ''; //사용자가 파일을 재선택하면 이전 미리보기가 남아있으면 안되므로 전부 비우기

    // 파일이 1개 초과인 경우 초기화하고 경고창 띄우기(파일 개수 제한 검사)
    if (files.length > 1) {
        const dataTransfer = new DataTransfer();
		//DataTransfer : 비어있는 FileList를 새로 만들어서 넣는 방식을 사용
		//input type="file"은 배열처럼 수정할 수 없으므로 위 방식을 사용한다
        fileInput.files = dataTransfer.files;
        alert("파일은 최대 1개까지만 첨부 가능합니다.");
        cntElement.textContent = 0;
        return;
    }

    // 선택된 파일들을 순회하며 미리보기 생성
    for (let i = 0; i < files.length; i++) {
        const file = files[i];
        const src = URL.createObjectURL(file);
		//URL.createObjectURL(file) : 브라우저는 사용자가 선택한 파일을 웹 주소처럼 사용할 수 있도록 임시 url을 만든다
		//src에 브라우저 내부에서만 유효한 임시 주소가 생긴다
		//그 주소를 <img src=".."이 부분에 넣으면 업로드 전에도 미리보기 이미지가 뜬다

        const listItem = document.createElement('li');
        listItem.innerHTML = `
            <div class="show-img-box">
                <img src="${src}" alt="${file.name}">
            </div>
            <div class="btn-box">
                <button type='button' class='img-cancel-btn' data-name='${file.name}'>삭제</button>
            </div>
        `;
        fileList.appendChild(listItem);
    }
	//data-name => js에서 사용 : e.target.dataset.name

    // 파일 개수 업데이트
    cntElement.textContent = files.length;
    
    // 새로 생성된 삭제 버튼에 클릭 이벤트 리스너 추가
    const cancelButtons = document.querySelectorAll('.img-cancel-btn');
    cancelButtons.forEach(button => {
        button.addEventListener('click', (e) => {
            const fileName = e.target.dataset.name;
            const currentFiles = fileInput.files;
            const dataTransfer = new DataTransfer();

            // 삭제할 파일을 제외하고 새로운 FileList 생성
            for (let i = 0; i < currentFiles.length; i++) {
                if (currentFiles[i].name !== fileName) {
                    dataTransfer.items.add(currentFiles[i]);
                }
            }

            // 파일 입력(input)의 files 속성을 업데이트
            fileInput.files = dataTransfer.files;

            // DOM에서 미리보기 요소 제거
            e.target.closest('li').remove();

            // 파일 개수 업데이트
            cntElement.textContent = fileInput.files.length;
        });
    });
});

// 취소 버튼 클릭 핸들러
cancelButton.addEventListener('click', () => {
    // 게시글 목록 페이지로 이동
    window.location.href = '/board/boardListOk.bo';
});