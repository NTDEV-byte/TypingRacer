package com.tps.generator;

import java.util.ArrayList;
import java.util.List;

import com.tps.KeyHandler;
import com.tps.Word;

public abstract class WordGenerator implements Generator{
		
		
			public static final int MAX_LENGTH = 40;
	
			protected List<Word> words;
			protected KeyHandler key;
			protected int amount;
			
			
					public WordGenerator(int amount,KeyHandler key) { 
						words = new ArrayList<Word>();
						this.amount = amount;
						this.key = key;
					}

					protected int clampToScreen(String w ,int target,int max,int spaceBTWNLetters) { 
						int wordSize = w.length();
						int wordSizeInPixels = wordSize * spaceBTWNLetters;
						int fixAmount =  (target + wordSizeInPixels);
						if(fixAmount >= max) { 
							  target-= wordSizeInPixels;
						}
						if(target <= 0) { 
							 target+=wordSizeInPixels;
						}
						return target;
					}
					
					protected int randomValue(int max) { 
						return (int)(Math.random() * max);
					}
				
					
					public List<Word> getWords(){ 
						return words;
					}
					
}
