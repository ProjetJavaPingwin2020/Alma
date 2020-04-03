/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;


import Entity.Articles_especes;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTimePicker;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.sql.rowset.serial.SerialBlob;
import static jdk.nashorn.internal.runtime.Debug.id;
import utils.ConnexionBase;

  
   
public class WelcomeArticleController implements Initializable {
     @FXML
    private AnchorPane rootPane;


    @FXML
    private Label console;

    @FXML
    private JFXButton item;

    @FXML
    private AnchorPane Pane1;

    @FXML
    private ImageView user;

    @FXML
    private ImageView set;

    @FXML
    private ImageView stat;

    @FXML
    private JFXTextArea id_console;

    @FXML
    private JFXButton update1;

   


  
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
     @FXML
    void CommentsManagement(ActionEvent event) {

    }
   @FXML
 void ItemsManagement(ActionEvent event) throws IOException{
     
      Parent article = FXMLLoader.load(getClass().getResource("FXMLArticles_especes.fxml"));
      Scene article_scene=new Scene(article);
      
      Stage app_stage =(Stage)((Node)event.getSource()).getScene().getWindow();
      app_stage.hide();
      app_stage.setScene(article_scene);
      app_stage.show();
    } 
}