package it.polito.tdp.libretto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import it.polito.tdp.libretto.model.Libretto;

/**
 * JavaFX App
 */
public class App extends Application { // Classe mia

    @Override
    public void start(Stage stage) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(App.class.getResource("main.fxml")) ; // crea scena e controller e li collega 
    	Parent root = loader.load();
    	Scene scene = new Scene(root) ;
    	
    	Libretto model = new Libretto();
    	Controller controller = loader.getController();
    	controller.setModel(model); // collega  controller e model 

    	stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
