package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;

import javax.inject.Inject;
import javax.inject.Named;

public class WordSearchServiceUseInject {

	/**
	 * @Inject annotation을 이용해서 Bean을 자동 주입해준다.
	 * @Autowired와 비슷하다.
	 *
	 * 스프링 컨테이너에서 같은 객체 타입을 찾아서 자동 주입해줌
	 *
	 * 만약에 스프링 컨테이너에 같은 타입의 객체가 여러개가 존재하면 @Autowired 에서는 @Qualifier annotation을 사용했지만
	 * @Inject는 @Named annotation을 사용해준다.
	 * @Named(value = "주입하고자 하는 Bean의 id")
	 * */

	@Inject
	@Named(value ="wordDao1")
	private WordDao wordDao;

	/**
	 * 필드나 메서드에 자동주입을 할 때는 기본생성자를 주입해줘야한다, */
	public WordSearchServiceUseInject(){

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