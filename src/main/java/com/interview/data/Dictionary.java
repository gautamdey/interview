package com.interview.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import com.interview.exception.ApplicationException;

import sun.security.acl.WorldGroupImpl;

public class Dictionary  {

	private static HashMap<String,String> wordList =  new HashMap<String, String>();;


	public Dictionary() throws ApplicationException{
		if( wordList==null||wordList.size()==0){
			loadWordlist();
		}

	}

	private static void loadWordlist() throws ApplicationException{
		
		synchronized (wordList) {

			
			BufferedReader br = null;
			InputStream stream = Dictionary.class.getResourceAsStream("/Dictionary.txt");
			System.out.println(stream != null);
			try {
				br =  new BufferedReader(new InputStreamReader(stream, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				throw new ApplicationException("invalid format error reading file"); 
			}
			String sCurrentLine;

			try {
				while ((sCurrentLine = br.readLine()) != null) {
					wordList.put(sCurrentLine.trim(), sCurrentLine.trim());
				}
			} catch (IOException e) {
				throw new ApplicationException("Not able to read the file "); 
			}
		}

	}

	public  long getTotalWords(){
		if (wordList== null)
			return 0L;
		else
			return wordList.size();
		
	}
	
	public boolean isValidWord(String s ){
		return wordList.containsKey(s);
	}

}
