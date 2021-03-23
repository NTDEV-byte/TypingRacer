package com.tps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application extends JPanel{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public static final int WIDTH = 800;
		public static final int HEIGHT = 600;
		public static final int RATE_FALL = 5;
		private JFrame window;
		private KeyHandler key;
		private WordGenerator wg;
		
				public Application() {
					 key = new KeyHandler();
					 wg = new WordGenerator("./words/BankWordsFR.txt",8,key);//new WordGenerator(3,key);
					 setView();
					}
				
			private void setView() { 
				 window = new JFrame("Typing");
				 window.setVisible(true);
				 window.setResizable(false);
				 window.setLocationRelativeTo(null);
				 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 setPreferredSize(new Dimension(WIDTH,HEIGHT));
				 window.addKeyListener(key);
				 window.add(this);
				 window.pack();
			}
			
			public void paint(Graphics g) { 
				g.setColor(Color.black);
				g.fillRect(0, 0, WIDTH, HEIGHT);
				wg.update();
				wg.render(g);
				
			/*	g.setColor(Color.red);
				char c = (char)(key.getPressedKey());
				System.out.println(c);
				g.setFont(Word.GENERAL_FONT);
				g.drawString(c+"", 20, 30);*/
				
				try {
					Thread.sleep(RATE_FALL);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
			
			public static void main(String[] args) { 
					new Application();
			}
}
