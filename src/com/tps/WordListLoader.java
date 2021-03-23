package com.tps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordListLoader {
			
			public static final String PATH_WORD_LIST = "./words/BankWordsEN.txt";
			
			private List<String> wordsList;
			
			public WordListLoader() { 
				loadFile(PATH_WORD_LIST);
			}
			
			public WordListLoader(String path) { 
				loadFile(path);
			}
			
			
			private void loadFile(String path) { 
				try {
					BufferedReader br = new BufferedReader(new FileReader(path));
				    wordsList = new ArrayList<String>();
					String line = "";
					
					while((line=br.readLine()) != null) { 
							String tokens[] = line.split("\n");
							wordsList.add(tokens[0]);
					}
					
					br.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			public List<String> getWordsList() {
				return wordsList;
			}

			


}
