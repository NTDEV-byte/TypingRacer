package com.tps.modes;

import com.tps.Word;
import com.tps.generator.WordGenerator;

public class SimpleMode extends PlayMode{

	public SimpleMode(WordGenerator wordGen) {
		super(wordGen);
	}

	@Override
	public void update() {
		if(words.size() > 0) { 
			Word w = words.get(0);
			w.setActive(true);
			w.update();
			removeTypedWords();
		}
		else {
			//System.out.println("wordS Terminated !");
		}
		
	//	System.out.println(toString());
	}

}
