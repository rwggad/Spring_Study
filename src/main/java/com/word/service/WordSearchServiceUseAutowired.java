package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class WordSearchServiceUseAutowired {

	/**
	 * @Autowired annotation을 이용해서 Bean을 자동 주입해준다.
	 *
	 * 스프링 컨테이너에서 같은 객체 타입을 찾아서 자동 주입해줌
	 *
	 * 만약에 스프링 컨테이너에 WordDao 객체 타입과 같은 타입의 Bean이 여러개가 존재한다면
	 * Autowired만 사용했을 때는 자동주입할 객체를 명확히 찾지 못해서 예외처리가 발생한다.
	 * 그래서 Qualifier annotation을 사용해서 명확하게 구분시켜준다.
	 * */

	@Autowired
	@Qualifier("usedDAO") // 스프링 컨테이너에 usedDAO로 명시된 Bean을 사용하겠다.
	private WordDao wordDao;

	/**
	 * 필드나 메서드에 자동주입을 할 때는 기본생성자를 주입해줘야한다, */
	public WordSearchServiceUseAutowired(){

	}
	public WordSearchServiceUseAutowired(WordDao wordDao){
		this.wordDao = wordDao;
	}
	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}

		return null;
	}

	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}

	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}