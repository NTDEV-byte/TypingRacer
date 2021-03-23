package com.tps;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class WordGenerator {
		
		
			public static final int MAX_LENGTH = 40;
	
			private List<Word> words;
			private KeyHandler key;
			private List<String> loadedWords;
			
			
					public WordGenerator(int amount,KeyHandler key) { 
						words = new ArrayList<Word>();
						this.key = key;
						generateWords(amount);
					}
					
					public WordGenerator(String pathListWord,int amount,KeyHandler key) { 
						words = new ArrayList<Word>();
						this.key = key;
						WordListLoader wll = new WordListLoader(pathListWord);
						loadedWords = wll.getWordsList();
						System.out.println(loadedWords.toString());
						generateWords(loadedWords,amount);
					}
					
					
					private void generateWords(int amount) { 
						int x;
						int y;
						int length;
						for(int i=0; i<amount;i++) { 
							x = (int)(Math.random() * Application.WIDTH + 5);
							y = (int)(Math.random() * Application.HEIGHT + 5);
							length = (int)((Math.random() * MAX_LENGTH)+ 1);
							words.add(new Word(x,y,length,key));
						}
					}
					

					
					
					private void generateWords(List<String> wordsList,int amount) { 
						int x;
						int y;
						int wordIndex;
						for(int i=0; i<amount;i++) { 
							x = (int)(Math.random() * Application.WIDTH + 5);
							y = (int)(Math.random() * Application.HEIGHT + 5);
							wordIndex = (int)((Math.random() * amount));
							words.add(new Word(wordsList.get(wordIndex),x,y,key));
						}
					}
					
					
					public void addWord(Word w) { 
						words.add(w);
					}
					
					public void removeWord(Word w) { 
						words.remove(w);
					}
					
					
					public void update() {
						 for(Word w : words) { 
							 w.update();
						 }
						 clearScreen();
						 if(words.size() == 0) {
							 generateWords(loadedWords,8);
						 }
					}
					
					
					private void clearScreen() { 
						for(int i=0;i<words.size();i++) { 
							 if(words.get(i).revealed()) { 
								 words.remove(i);
							 }
						}
					}
					
					
					public void render(Graphics g) {
						 for(Word w : words) {
						  w.render(g);
						 }
					}
			
		

}
