package com.interview.data;

import static org.junit.Assert.*;

import org.junit.Test;

import com.interview.exception.ApplicationException;

public class TestDictionary {
	@Test
	   public void testPrintMessage() {	
		
	      Dictionary dic=null;
		try {
			dic = new Dictionary();
		} catch (ApplicationException e) {
			fail("got exception + "+ e.getMessage());
		}
	      assertTrue("wordcount :" ,dic.getTotalWords()>0L);
	      
	   }
	
	
	@Test
	   public void testWithWordPInDictionary() {	
		
	      Dictionary dic=null;
		try {
			dic = new Dictionary();
		} catch (ApplicationException e) {
			fail("got exception + "+ e.getMessage());
		}
		
	      assertTrue("wordcount :" ,dic.isValidWord("pest"));  
	   }
}
