package com.tps.modes;

import java.awt.Graphics;

import com.tps.Word;
import com.tps.generator.WordGenerator;

public class BattleRoyalMode extends PlayMode{

	public BattleRoyalMode(WordGenerator wordGen) {
		super(wordGen);
	}

	@Override
	public void update() {
		 for(Word w : words) { 
			 w.update();
		 }
		 removeTypedWords();
	}	
	
	
	/*
	 * must be called when we want to use updateBattleRoyale;
	 */

	private void activateAllWords() { 
		for(Word w : words) { 
			w.setActive(true);
		}
	}

	@Override
	public void render(Graphics g) {
		
	}

}
