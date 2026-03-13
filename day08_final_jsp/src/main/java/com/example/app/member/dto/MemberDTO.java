package com.example.app.member.dto;

public class MemberDTO {
//	CREATE TABLE tbl_member(
//			member_number NUMBER,
//			member_id varchar2(100),
//			member_password varchar2(20),
//			member_name varchar2(100),
//			member_age number(3),
//			member_gender char(1),
//			member_phone_number varchar2(20),
//			member_postcode varchar2(5),
//			member_address varchar2(300),
//			member_detail_addr varchar2(300),
//			constraint PK_MEMBER PRIMARY KEY(member_number)
//		);
	private long memberNumber;
	private String memberId;
	private String memberPassword;
	private String memberName;
	private int memberAge;
	private String memberGender;
	private String memberPhoneNumber;
	private String memberPostcode;
	private String memberAddress;
	private String memberDetailAddr;
	public long getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(long memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}
	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}
	public String getMemberPostcode() {
		return memberPostcode;
	}
	public void setMemberPostcode(String memberPostcode) {
		this.memberPostcode = memberPostcode;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberDetailAddr() {
		return memberDetailAddr;
	}
	public void setMemberDetailAddr(String memberDetailAddr) {
		this.memberDetailAddr = memberDetailAddr;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
