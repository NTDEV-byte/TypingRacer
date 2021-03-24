package com.tps.modes;

import java.awt.Graphics;
import java.util.List;

import com.tps.Word;
import com.tps.generator.WordGenerator;

public abstract class PlayMode {
		
			protected WordGenerator wordGen;
			protected List<Word> words;
			
					public PlayMode(WordGenerator wordGen) { 
						this.wordGen = wordGen;
						this.words = wordGen.getWords();
					}
					
					
					
					protected void removeTypedWords() { 
						for(int i=0;i<words.size();i++) { 
							 if(words.get(i).revealed()) { 
								 words.remove(i);
							 }
						}
					}
					
				
					
			public abstract void update();
			
			
			public void render(Graphics g) {
				 for(Word w : words) {
					  w.render(g);
					 }
			}
			
			
			public String toString() { 
				return "WordLists: "+words.toString()+" Size: "+words.size();
			}
		

}
