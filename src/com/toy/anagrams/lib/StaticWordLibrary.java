/*
 * Copyright (c) 2010, Oracle.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  * Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */

/* Anagram Game Application */

package com.toy.anagrams.lib;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementation of the logic for the Anagram Game application.
 */
public final class StaticWordLibrary extends WordLibrary {

    private static final String[] WORD_LIST = {
        "abstraction",
        "ambiguous",
        "arithmetic",
        "backslash",
        "bitmap",
        "circumstance",
        "combination",
        "consequently",
        "consortium",
        "decrementing",
        "dependency",
        "disambiguate",
        "dynamic",
        "encapsulation",
        "equivalent",
        "expression",
        "facilitate",
        "fragment",
        "hexadecimal",
        "implementation",
        "indistinguishable",
        "inheritance",
        "internet",
        "java",
        "localization",
        "microprocessor",
        "navigation",
        "optimization",
        "parameter",
        "patrick",
        "pickle",
        "polymorphic",
        "rigorously",
        "simultaneously",
        "specification",
        "structure",
        "lexical",
        "likewise",
        "management",
        "manipulate",
        "mathematics",
        "hotjava",
        "vertex",
        "unsigned",
        "traditional",
        "example"};

    private String[] SCRAMBLED_WORD_LIST  = new String[getSize()];
    
    final static WordLibrary DEFAULT = new StaticWordLibrary();

    /**
     * Singleton class.
     */
    public StaticWordLibrary() {
    	int idx=getSize();
  	  	for(int i=0;i<idx;i++){
  	  	SCRAMBLED_WORD_LIST  [i]=shuffleWord(i,"Level 1");
  	  }
    }

    /**
     * Gets the word at a given index.
     * @param idx index of required word
     * @return word at that index in its natural form
     */
    public String getWord(int idx) {
        return WORD_LIST[idx];
    }

    /**
     * Gets the word at a given index in its scrambled form.
     * @param idx index of required word
     * @return word at that index in its scrambled form
     */
    public String getScrambledWord(int idx) {
        return SCRAMBLED_WORD_LIST[idx];
    }

    /**
     * Gets the number of words in the library.
     * @return the total number of plain/scrambled word pairs in the library
     */
    public int getSize() {
        return WORD_LIST.length;
    }

    /**
     * Checks whether a user's guess for a word at the given index is correct.
     * @param idx index of the word guessed
     * @param userGuess the user's guess for the actual word
     * @return true if the guess was correct; false otherwise
     */
    public boolean isCorrect(int idx, String userGuess) {
        return userGuess.equals(getWord(idx));
    }
    
    public void level1(ArrayList list){
    	//System.out.println("-----1メソッド");
    	Collections.reverse(list);
    	//System.out.println(list);
    }
    public void level2(ArrayList list,int n){
    	//System.out.println("-----2メソッド");
    	//System.out.println(list+"前");
    	Collections.swap(list, 2, n-2);	
    	//System.out.println(list+"後");
    }
    public void level3(ArrayList list){	
    	//System.out.println("-----3メソッド");
    	Collections.shuffle(list);
    }

    public String shuffleWord(int idx,String level){
    	//System.out.println("--------shuffleword--------");
    	ArrayList list=new ArrayList<String>();
    	String s=getWord(idx);
    	int n=s.length();
    	for(int i=0;i<n;i++){
    	 list.add(s.charAt(i));	
    	}
    	if(level=="Level 1"){
    		//System.out.println(list);
			level1(list);
			//System.out.println("level1------");
		}else if(level=="Level 2"){
			//System.out.println(list);
			level2(list,n);			
			//System.out.println("level2------");
		}else if(level=="Level 3"){
			//System.out.println(list);
			level3(list);
		}
    	String word="";
    	for(int i=0;i<list.size();i++){
    		word+=list.get(i);
    	}
    	return word;
    }
}
