package com.tps;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	private int keypressed;
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keypressed = e.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keypressed = KeyEvent.KEY_RELEASED;
	}
	
	public int getPressedKey() {
		return keypressed;
	}

}
