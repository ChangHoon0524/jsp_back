package com.example.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.example.app.member.dto.MemberDTO;
import com.example.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);				
	}
	
	// 회원가입 메소드 (MemberMapper.xml의 쿼리문 실행하는 메소드)
	public void join(MemberDTO memberDTO) {
		// insert의 반환타입은 int타입
		// 정상 처리시 1반환, 쿼리에 영향받은 행의 수 반환
		sqlSession.insert("member.join", memberDTO);
	}
	
	// 아이디 중복체크 메소드
	public boolean checkId(String memberId) {
		return (Integer)sqlSession.selectOne("member.checkId", memberId) < 1;
	}
	
	// 로그인 메소드
	public int login(MemberDTO memberDTO) {
		Integer memberNumber = sqlSession.selectOne("member.login", memberDTO);
		return memberNumber == null ? -1 : memberNumber;
	}
	
	// 회원 번호 반환 메소드
	public String getMemberId(int memberNumber) {
		return sqlSession.selectOne("member.getMemberId", memberNumber);
	}
}
