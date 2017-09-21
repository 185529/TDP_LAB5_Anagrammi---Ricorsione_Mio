/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private Model model;
	private List<Word> anagrams;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="input"
    private TextField input; // Value injected by FXMLLoader

    @FXML // fx:id="calculate"
    private Button calculate; // Value injected by FXMLLoader

    @FXML // fx:id="okOutput"
    private TextArea okOutput; // Value injected by FXMLLoader

    @FXML // fx:id="koOutput"
    private TextArea koOutput; // Value injected by FXMLLoader

    @FXML // fx:id="reset"
    private Button reset; // Value injected by FXMLLoader

    @FXML
    void doCalculate(ActionEvent event) {
    	
    	okOutput.clear();
    	koOutput.clear();
    	
    	String word = input.getText();
    	    	
    	if(word == null || word.isEmpty()){
    		System.out.println("OK - doCalculate() - If entered.");
    		okOutput.setText("ERROR: Insert a word.");
    		input.requestFocus();
    		return;
    	}
    	
    	anagrams = new LinkedList<Word>();
    	    	
    	anagrams = model.getAnagrams(word);
    	
    	for(Word w : anagrams){
    		if(w.isCorrect()){
    			okOutput.appendText(w.getWord()+"\n");
    		}else{
    			koOutput.appendText(w.getWord()+"\n");
    		}
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	input.clear();
    	okOutput.clear();
    	koOutput.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert input != null : "fx:id=\"input\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert calculate != null : "fx:id=\"calculate\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert okOutput != null : "fx:id=\"okOutput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert koOutput != null : "fx:id=\"koOutput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert reset != null : "fx:id=\"reset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model) {

		this.model = model;
		
	}
}
