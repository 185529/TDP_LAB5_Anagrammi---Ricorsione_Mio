package it.polito.tdp.anagrammi.model;

public class Word {
	
	private String word;
	private boolean correct;
	
	/**
	 * @param word
	 */
	public Word(String word) {
		super();
		this.word = word;
		this.correct = false;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the correct
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * @param correct the correct to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	

}
