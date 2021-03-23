package com.tps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Word {
	
		public static Font GENERAL_FONT = new Font("Verdana",Font.BOLD,15);
		public static final int LETTER_SPACE = 20;
		private int x,y;
		private int length;
		private Color color;
		private String word="";
		private KeyHandler key;
		private List<Boolean> lettersState; // true if typed false if not typed 
				
				public Word(int x,int y,KeyHandler key) {
					this.x = x;
					this.y = y;
					this.length = 5;
					this.key = key;
					this.color = Color.yellow;
					lettersState = new ArrayList<Boolean>();
					initState();
					generateWord();
				}
				
				public Word(String word,int x,int y,KeyHandler key) { 
					this.x = x;
					this.y = y;
					this.length = word.length();
					this.color = Color.yellow;
					this.key = key;
					this.word = word;
					this.word = word.toUpperCase();
					lettersState = new ArrayList<Boolean>();
					initState();
				}

				
				public Word(int x,int y,int length,KeyHandler key) {
					this.x = x;
					this.y = y;
					this.length = length;
					this.color = Color.yellow;
					this.key = key;
					lettersState = new ArrayList<Boolean>();
					initState();
					generateWord();
				}
				
				
				public Word(int x,int y,int length,Color color,KeyHandler key) {
					this.x = x;
					this.y = y;
					this.length = length;
					this.color = color;
					this.key = key;
					lettersState = new ArrayList<Boolean>();
					initState();
					generateWord();
				}
				
				private void initState() {
					 for(int i=0;i<length;i++) { 
						 lettersState.add(false);
					 }
				}
				
				private void generateWord() {
					String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
					for(int i=0; i< length ;i++) {
						  int letterIndx = (int)(Math.random() * alphabets.length());
						  word = word+alphabets.charAt(letterIndx);
					}
				}
				
				public void update() { 
					y+=1;
					if(y >= Application.HEIGHT) y = 0;
					letterTyped();
				}
				
				private void letterTyped() {
					char input = (char)key.getPressedKey();
					for(int i=0;i<length;i++) {
						System.out.println("Typed:"+input);
						if(word.charAt(i) == input) { 
							System.out.println("Letter Typed: "+word.charAt(i));
							lettersState.set(i,true);
						}
					}
				}
				
				public void render(Graphics g) { 
					g.setFont(GENERAL_FONT);
					for(int i=0;i<length;i++) { 
						 if(lettersState.get(i)) { 
							 g.setColor(Color.red);
						 }
						 else{
							 g.setColor(color);
						 }
						 g.drawString(word.charAt(i)+"", x +(i * LETTER_SPACE), y);
					}
				}
				
				public boolean revealed() { 
					 for(int i=0;i<lettersState.size();i++) { 
						   if(!lettersState.get(i)) return false;
					 }
					 return true;
				}
				
				
				public void renderWord(Graphics g) { 
					g.setColor(color);
					g.setFont(GENERAL_FONT);
					g.drawString(word, x, y);
				}
}
