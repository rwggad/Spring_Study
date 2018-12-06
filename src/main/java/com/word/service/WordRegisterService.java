package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {
	private WordDao wordDao;

	/**
	 * appCtx에서 객체가 자동주입이 아닌 직접 constructor-arg로 주입해주고 있음 */
	public WordRegisterService(WordDao wordDao) {
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