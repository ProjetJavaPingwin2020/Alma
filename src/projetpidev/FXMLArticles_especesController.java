/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;


import Entity.Articles_especes;
import Services.ArticleService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTimePicker;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeJava.type;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.controlsfx.control.Notifications;
import utils.ConnexionBase;

//hou hetha
   
public class FXMLArticles_especesController implements Initializable {
    
    @FXML
    private TableView<Articles_especes> cc_article;
  @FXML
    private TableColumn<Articles_especes,String> cc_id;
  @FXML
    private TableColumn<Articles_especes,String> cc_titre;
  @FXML
    private TableColumn<Articles_especes,String> cc_contenu;
  @FXML
    private TableColumn<Articles_especes,String> cc_like;
    @FXML
    private TableColumn<Articles_especes,String> cc_accept;
      @FXML
    private TableColumn<Articles_especes,String> cc_image;
        @FXML
    private TextField titre_text;
             @FXML
    private TextField contenu_text;
      @FXML
    private JFXTextArea id_console;
        @FXML
    private TextField filter;
    @FXML
    private ImageView set;
      @FXML
    private JFXButton load;
      
private PreparedStatement prt=null;
private FileInputStream A;
    ObservableList<Articles_especes> oo,oblist=FXCollections.observableArrayList();
     FilteredList<Articles_especes> filteredList = new FilteredList<>(oblist);
    @FXML
    private ImageView user;
    private TextField image_text;
    @FXML
    private AnchorPane listview;
    @FXML
    private TableColumn<?, ?> cc_like1;
    @FXML
    private JFXButton delete1;
    @FXML
    private Label console;
        @FXML
    private TableColumn<?, ?> cc_commentaires;
    @FXML
    private JFXButton Eimage;
    @FXML
    private JFXButton AddArticle;
    @FXML
    private JFXButton deletee;
    @FXML
    private JFXButton update;
    @FXML
    private ImageView stat;
    @FXML
    private JFXCheckBox type1;
    @FXML
    private JFXCheckBox type2;
    @FXML
    private ImageView imageview;
     String img="";
    List<String> type;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         type =new ArrayList();
        type.add("*.jpg");
         type.add("*.png");
    }
      @FXML
    void LoaddetailsAction(ActionEvent event) {//hethi l affich
ArticleService sp = new ArticleService();
      List articles=sp.ArticleLoad();
       ObservableList et=FXCollections.observableArrayList(articles);
       cc_article.setItems(et);
       cc_article.setEditable(true);
      cc_commentaires.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
      cc_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cc_titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
          cc_contenu.setCellValueFactory(new PropertyValueFactory<>("Contenu"));
            cc_like.setCellValueFactory(new PropertyValueFactory<>("numlike"));
            cc_accept.setCellValueFactory(new PropertyValueFactory<>("accept"));
          
             cc_image.setCellValueFactory(new PropertyValueFactory<>("photo"));

 
 
       
    }    
    /*public void edittable(){
     
    cc_titre.setCellFactory(TextFieldTableCell.forTableColumn());   
 cc_titre.setOnEditCommit((TableColumn.CellEditEvent<Articles_especes, String> e)->{
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setTitre(e.getNewValue());
     });
    cc_contenu.setCellFactory(TextFieldTableCell.forTableColumn());   
 cc_contenu.setOnEditCommit((TableColumn.CellEditEvent<Articles_especes, String> e)->{
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setContenu(e.getNewValue());
     });
  
    
cc_article.setEditable(true);
}*/
     @FXML
  void AddArticle(ActionEvent event) throws FileNotFoundException, IOException{
          
        String TitreE=titre_text.getText();
        String Contenu=contenu_text.getText();
        String id=cc_id.getText();
       

       // Date date_debutE = java.sql.Date.valueOf(dd);
        //Date date_finE = java.sql.Date.valueOf(df);


        ArticleService sp = new ArticleService();// hedha el service pas l entite hou ena meni aamla chay f service ahna wn kona bekri ne5dmouu f upload wfn ihelki !
         Articles_especes e = new Articles_especes(TitreE,Contenu,img);
        sp.ajouuterArticle(e);
         JOptionPane.showMessageDialog(null, "ajout avec succes");
     /*
        try {
            
            prt =cnx.prepareStatement(sql);
                prt.setString(1,Titre);
                 prt.setString(2,Contenu);
        
          //   prt.setBlob(3, new SerialBlob((Blob) cc_image));
                 
               int i=prt.executeUpdate();
               if (i==1)
             id_console.setText("article inserted suceffuly..");
        } catch (SQLException ex) {
              System.out.println("error"+ex);
        } 
        
        Notifications ntf= Notifications.create()
                .title("Article added succeffuly !!!")
                .text("inserted in data-base 'pidev'")
                .graphic(new ImageView(easy)).hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT).onAction(new EventHandler <ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
           
               
               System.out.println("Clicked on notifications");
           }
                      
   });
        ntf.showConfirm();*/
  }
   @FXML
    
    void DeleteRowfromtable(ActionEvent event) {
 cc_article.getItems().removeAll(cc_article.getSelectionModel().getSelectedItem());
    }
     @FXML
      void UpdateArticle(ActionEvent event) throws SQLException {
        
        try { 
Articles_especes.updateArticle(titre_text.getText(),contenu_text.getText());
 id_console.setText("article updated suceffuly..");
 }catch(SQLException e){
     System.out.println("error occured while updating article"+e);
     e.printStackTrace();
     throw e;
 }} 

     @FXML
void searchArticle(ActionEvent event) {

	   FilteredList<Articles_especes> filteredData = new FilteredList<>(oblist, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filter.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Articles_especes-> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Articles_especes.getTitre().toLowerCase().contains(lowerCaseFilter) ) {
					return true; // Filter matches first name.
				} else if (Articles_especes.getContenu().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Articles_especes> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind( cc_article.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		 cc_article.setItems(sortedData);
               
        
    }    
    @FXML
 void DeleteArticle(ActionEvent Event) throws SQLException{
      try { 
Articles_especes.DeleteArticleBytitre(String.valueOf(titre_text.getText()));
  id_console.setText("Article deleted suceffuly..");
 }catch(SQLException e){
     System.out.println("error occured while deleting article"+e);
     e.printStackTrace();
     throw e;
 }}
  @FXML
     void Uploadimage(ActionEvent event) throws IOException {
     
     
        FileChooser f=new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg,png",type));
        File fc=f.showOpenDialog(null);
        if(f!= null)
        {
            System.out.println(fc.getName());
            img=fc.getAbsoluteFile().toURI().toString();
            Image i = new Image(img);
           imageview.setImage(i);
        }
     }

//f base chesmhaa el image ! image issemha h
}