package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private DatePicker selData;

    @FXML
    private TextField txtCorso;

    @FXML
    private TextArea txtResult;
    
    @FXML
    void handleInserisci(ActionEvent event) {
	    String corso = txtCorso.getText(); // getText mi restituisce il testo
	    Integer punti= cmbPunti.getValue(); // getValue mi restituisce il current item
	    LocalDate data= selData.getValue();
	    	
	    Voto v= new Voto(corso, punti, data);
	    model.add(v);
	    	
	    txtResult.setText(model.toString());

	   }


    @FXML
    void initialize() {
    	assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'main.fxml'.";
        assert selData != null : "fx:id=\"selData\" was not injected: check your FXML file 'main.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'main.fxml'.";
	    
        for (Integer p=18;p<31;p++) 
        	cmbPunti.getItems().add(p);
    }
    
    public void setModel(Libretto model) {
		this.model = model;
		txtResult.setText(model.toString());
	}


}
