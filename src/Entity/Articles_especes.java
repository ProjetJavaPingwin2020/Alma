/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.ConnexionBase;

/**
 *
 * @author USER
 */
public class Articles_especes {
    

    private int id;
    private String Titre;
    private String Contenu;
     private String Type;
   

    private Date datepub;
    private int numlike;
    private int accept;
    private String image;
     private ImageView photo;


    public Articles_especes() {
    }

  
        
    //enty ki taaml ajout eda5el id ?wela autoincrement ! le auto 
    public Articles_especes( String Titre, String Contenu,String image) {//
       
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.image = image;
      
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
       
        
    

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }
        
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

   

  

  

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public Date getDatepub() {
        return datepub;
    }

    public void setDatepub(Date datepub) {
        this.datepub = datepub;
    }

    public int getNumlike() {
        return numlike;
    }

    public void setNumlike(int numlike) {
        this.numlike = numlike;
    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }


  
    
   public static void DeleteArticleBytitre(String titre) throws SQLException{
          
       Connection cnx = ConnexionBase.getInstance().getCnx();
        String sql="DELETE FROM `articles_especes` WHERE Titre ='"+titre+"'";
          PreparedStatement prt =cnx.prepareStatement(sql);
       try{
prt.executeUpdate();          
       /*oblist=cc_article.getItems();
        oo=cc_article.getSelectionModel().getSelectedItems();
        oo.forEach(oblist::remove);*/
 }
       catch (SQLException e){
     System.out.println("errror occured");
     e.printStackTrace();
     throw e;
     
 }}
   
   public static void updateArticle(String titre,String contenu)throws SQLException{
           
       Connection cnx = ConnexionBase.getInstance().getCnx();
        String sql="Update articles_especes set Contenu= '"+contenu+"' WHERE titre ='"+titre+"' " ;
          PreparedStatement prt =cnx.prepareStatement(sql);
       try{
prt.executeUpdate();          
       /*oblist=cc_article.getItems();
        oo=cc_article.getSelectionModel().getSelectedItems();
        oo.forEach(oblist::remove);*/ // bekrii fema whda bedeltt fihaa kima hekaa fct ema mehomchh hedhomm ..
 }
       catch (SQLException e){
     System.out.println("errror occured when updating");
     e.printStackTrace();
     throw e;
     
 }

   }

//ye hou heka nestha9lou l code fam ye almaa lezmk tbadalou blastouuuu mayjich lenna thotou kolll f service w juste baed tbedel f imhpeort matefsdch 5edmtk behy mela bara chouf trah
 /* public static ObservableList<Articles_especes> getAllRecords() throws SQLException {
      Connection cnx = ConnexionBase.getInstance().getCnx();
      try{
         ResultSet rs= cnx.createStatement().executeQuery("select * from articles_especes");
     ObservableList<Articles_especes> artlist=getArticleObject(rs);
     return artlist;
      }catch(SQLException e){
           System.out.println("error occured when you insert data"+e);
      }
        return null;
      }

       private static ObservableList<Articles_especes> getArticleObject(ResultSet rs) throws SQLException {
           try {
ObservableList<Articles_especes> artlist = FXCollections.observableArrayList();
         
while(rs.next()){
           
        Articles_especes art=new Articles_especes();
        art.setId(rs.getInt("id"));
        art.setTitre(rs.getString("Titre"));
         art.setContenu(rs.getString("Contenu"));
         art.setAccept(rs.getInt("Accept"));
          art.setNumlike(rs.getInt("like"));  
            art.setImage(rs.getString("image"));  
            artlist.add(art);

       }return artlist;
       }catch(SQLException e){
           System.out.println("error occured when you insert data"+e);
      }
        return null;
      }*/
   
   
}
