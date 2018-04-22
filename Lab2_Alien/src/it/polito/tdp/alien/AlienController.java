package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	String parolaInserita;
	AlienDictionary dizionario= new AlienDictionary();
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
//    	txtResult.clear();
    	parolaInserita=txtWord.getText();
    	String alienWord="";
    	String traslation="";
    	if(parolaInserita.length()==0) {
    		txtResult.setText("Errore:parola vuota");
    		return;
    	}
    	parolaInserita=parolaInserita.toLowerCase();
    	//dovrei ancora controllare che ci siano solo caratteri

    	
//    	if(parolaInserita.contains(" ")) {
//    		alienWord=parolaInserita.spl;
//    		dizionario.addWord(alienWord, traslation);
//    	}
		String[] ar = parolaInserita.split(" ");
		if(ar.length==1) {
		 	if(!ar[0].matches("[a-z]+")) { //è fatto solo da lettere maiuscole anche ripetute?
	    		txtResult.setText("Errore: caratteri non ammessi");
	    		return;
	    	}
	    	
	 		txtResult.appendText(dizionario.traslateWord(ar[0])+"\n");
		} else if(ar.length==2) {
		 	if(!ar[0].matches("[a-z]+")||!ar[1].matches("[a-z]+")) { //è fatto solo da lettere maiuscole anche ripetute?
	    		txtResult.setText("Errore: caratteri non ammessi");
	    		return;
		 	}
			dizionario.addWord(ar[0], ar[1]);

		 	
		}else {
    		txtResult.setText("Errore: troppe parole");

		}
		txtWord.clear();
    	    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }
    
}
