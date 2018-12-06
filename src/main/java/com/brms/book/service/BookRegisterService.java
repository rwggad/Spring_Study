package com.brms.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;

public class BookRegisterService implements InitializingBean, DisposableBean {

	/**
	 * 책을 등록하는 서비스 */
	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}


	/**
	 * InitializingBean 에서 오버라이딩
	 * Bean이 생성되는 시점 */
	@Override
	public void afterPropertiesSet() throws Exception {

	}


	/**
	 * DisposableBean 에서 오버라이딩
	 * Bean이 삭제되는 시점 */
	@Override
	public void destroy() throws Exception {
		System.out.println("BookRegisterService Bean 소멸");
	}
}