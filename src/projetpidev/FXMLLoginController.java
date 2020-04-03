/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

import Entity.FosUser;
import Services.UserSevice;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yassiine
 */
public class FXMLLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField password;

    @FXML
    private Button login;
    
    @FXML
    private ImageView image ;
   
    @FXML
    private JFXTextField username;

    @FXML
    private Button register;

   
 

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
        
   
       Parent article = FXMLLoader.load(getClass().getResource("welcomeArticle.fxml"));
      Scene article_scene=new Scene(article);
      
      Stage app_stage =(Stage)((Node)event.getSource()).getScene().getWindow();
      app_stage.hide();
      app_stage.setScene(article_scene);
      app_stage.show();
    } 
     
    
    public void redirect(ActionEvent event)
    {
         try {
               
               
              
               Parent AnchorPane = FXMLLoader.load(getClass().getResource("FXMLRegister.fxml"));
               Stage stage = new Stage();
               Scene scene = new Scene(AnchorPane);
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
           }
                ((Node) event.getSource()).getScene().getWindow().hide();   
    
                         
    }
               
          

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}


