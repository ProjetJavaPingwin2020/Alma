/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;
import javafx.stage.StageStyle;


/**
 *
 * @author Yassiine
 */
public class ProjetPidev extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        stage.setScene(scene);
        
        stage.show();

        stage.setResizable(false);
        stage.centerOnScreen();
    /* EnvoyerEmail test = new EnvoyerEmail();
test.envoyer();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
        
   
    }

}
