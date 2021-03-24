package com.tps.generator;

import java.util.List;

import com.tps.Application;
import com.tps.KeyHandler;
import com.tps.Word;
import com.tps.utils.WordListLoader;

public class LoadedWordGen extends WordGenerator{
	
	private String pathListWords;
	private List<String> loadedWords;

		
			public LoadedWordGen(String pathListWords,int amount,KeyHandler key) { 
				super(amount,key);
				this.pathListWords = pathListWords;
				loadWords();
				generate();
			}
			
			public void addWord(Word w) { 
				words.add(w);
			}
			
			public void removeWord(Word w) { 
				words.remove(w);
			}
			
			public void generate() {
				int x;
				int y;
				int wordIndex;
				for(int i=0; i<amount;i++) { 
					x = randomValue(Application.WIDTH);
					y = randomValue(Application.HEIGHT);
					x = clampToScreen(loadedWords.get(i),x,Application.WIDTH,Word.LETTER_SPACE);
					y = clampToScreen(loadedWords.get(i),y,Application.HEIGHT,Word.LETTER_SPACE);
					wordIndex = randomValue(amount);
					words.add(new Word(loadedWords.get(wordIndex),x,y,key));
				}
				System.out.println("Called !");
			}
			
			private void loadWords() { 
				WordListLoader wll = new WordListLoader(pathListWords);
				loadedWords = wll.getWordsList();
			}

}
