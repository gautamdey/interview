package com.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.interview.data.Dictionary;
import com.interview.exception.ApplicationException;
import com.interview.processor.WordExtractorUtil;

public class BoggleWordFinder {

	public List<String> findWord(Character[][] charMatrix) throws ApplicationException{

		List<String> wordList = new ArrayList<String>();

		Dictionary dictionary = new Dictionary();

		WordExtractorUtil extracterUtil = new WordExtractorUtil();
		for(int i = 0 ; i <charMatrix.length;i++){
			for(int j = 0 ; j<charMatrix[i].length;j++){
				List<String> extractedWordList = extracterUtil.extractWordX2Y(charMatrix, i, j);
				extractedWordList.addAll(extracterUtil.extractWordY2X(charMatrix, i, j));
				Iterator<String> it =  extractedWordList.iterator();
				while( it.hasNext()){
					String s = it.next();
					if(dictionary.isValidWord(s))
						if(!wordList.contains(s))
							wordList.add(s);
				}
			}
		}
		return wordList;
	}

}
