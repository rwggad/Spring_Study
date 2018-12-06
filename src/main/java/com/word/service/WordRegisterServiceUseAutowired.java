package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;

public class WordRegisterServiceUseAutowired {
	private WordDao wordDao;

	/**
	 * @Autowired annotation을 이용해서 Bean을 자동 주입해준다.
	 *
	 * 스프링 컨테이너에서 같은 객체 타입을 찾아서 자동 주입해줌*/
	@Autowired
	public WordRegisterServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	/**
	 * 입력 받은 wordSet을 DB에 등록해준다.
	 * */
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}

	/**
	 * 이미 등록된 단어인지 확인*/
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}

	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}