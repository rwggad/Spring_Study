package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;

public class WordSearchServiceUseAutowired {

	private WordDao wordDao;

	/**
	 * @Autowired annotation을 이용해서 Bean을 자동 주입해준다.
	 *
	 * 스프링 컨테이너에서 같은 객체 타입을 찾아서 자동 주입해줌*/
	@Autowired
	public WordSearchServiceUseAutowired(WordDao wordDao) {
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