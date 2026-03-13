package com.example.app.dao;

import org.apache.ibatis.session.SqlSession;

import com.example.app.dto.MemberDTO;
import com.mybatis.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 회원가입 메소드
	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join", memberDTO);
	}
	
	// 로그인 메소드
	public MemberDTO login(String memberId, String memberPassword) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberId(memberId);
		memberDTO.setMemberPassword(memberPassword);
		
		return sqlSession.selectOne("member.login", memberDTO);
	}
}
