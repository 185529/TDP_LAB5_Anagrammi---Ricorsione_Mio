package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.database.AnagrammiDAO;

public class Model {

	public List<Word> getAnagrams(String word) {
		
		AnagrammiDAO dao = new AnagrammiDAO();
		List<Word> anagrams = new LinkedList<Word>();
		
		String part = "";
		
		recursive(part, word, 0, anagrams);
		
		for(Word w : anagrams){
			if(dao.isCorrect(w)){
				w.setCorrect(true);
			}else{
				w.setCorrect(false);
			}
		}
		
		return anagrams;
		
	}

	private void recursive(String parziale, String parola, int passo, List<Word> anagrammi) {
		
		if(passo == parola.length()){
			anagrammi.add(new Word(parziale));
			return;
		}
		
		for(int i = 0; i< parola.length(); i++){
			if(charCounter(parziale, parola.charAt(i))< charCounter(parola, parola.charAt(i))){
				parziale += parola.charAt(i);
				recursive(parziale, parola, passo + 1, anagrammi);
				parziale = parziale.substring(0, parziale.length()-1);
			}
		}
		
	}
	
	private static int charCounter(String string, char c){
		
		int count = 0;
	    
		for (int i=0; i < string.length(); i++){
	        if (string.charAt(i) == c){
	             count++;
	        }
	    }
		
	    return count;
	    
}
	

}
