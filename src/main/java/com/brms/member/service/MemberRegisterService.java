package com.brms.member.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.brms.member.Member;
import com.brms.member.dao.MemberDao;

public class MemberRegisterService implements InitializingBean, DisposableBean {

	/**
	 * 회원 등록 서비스*/
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() { }
	
	public void register(Member member) {
		memberDao.insert(member);
	}


	/**
	 * InitializingBean 에서 오버라이딩
	 * Bean이 생성되는 시점 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("MemberRegisterService Bean 생성");
	}


	/**
	 * DisposableBean 에서 오버라이딩
	 * Bean이 삭제되는 시점 */
	@Override
	public void destroy() throws Exception {
		System.out.println("MemberRegisterService Bean 소멸");
	}
}
