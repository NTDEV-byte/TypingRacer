package com.tps.generator;

import com.tps.Application;
import com.tps.KeyHandler;
import com.tps.Word;

public class RandomWordGen extends WordGenerator{

		public RandomWordGen(int amount,KeyHandler key) { 
			super(amount,key);
			generate();
		}
	

	@Override
	public void generate() {
		int x;
		int y;
		int length;
		for(int i=0; i<amount;i++) { 
			x = randomValue(Application.WIDTH);
			y = randomValue(Application.HEIGHT);
			length = (int)((Math.random() * MAX_LENGTH)+ 1);
			words.add(new Word(x,y,length,key));
		}
	}
	
	
	
}
