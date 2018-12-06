package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchService {

	private WordDao wordDao;

    /**
     * appCtx에서 객체가 자동주입이 아닌 직접 constructor-arg로 주입해주고 있음 */
	public WordSearchService(WordDao wordDao) {
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