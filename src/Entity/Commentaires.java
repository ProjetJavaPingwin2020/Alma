/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import utils.ConnexionBase;

/**
 *
 * @author USER
 */


public class Commentaires {

    public static void DeleteArticleBytitre(String message) throws SQLException{
          
       Connection cnx = ConnexionBase.getInstance().getCnx();
        String sql="DELETE FROM `commentaire` WHERE message ='"+message+"'";
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

    
   
@Id
private int id;
private String user;
private Date date_pub;
private String message;
private int article;
   private String sto;
   Articles_especes s;
    public Articles_especes getS() {
        return s;
    }

    public void setS(Articles_especes s) {
        this.s = s;
    }

    public String getSto() {
        return sto;
    }

    public void setSto(String sto) {
        this.sto = sto;
    }
public  static void updatecom(String contenu,String Article) throws SQLException {
               
       Connection cnx = ConnexionBase.getInstance().getCnx();
        String sql="Update commentaire set message= '"+contenu+"' WHERE article ='"+Article+"' " ;
        
          PreparedStatement prt =cnx.prepareStatement(sql);
       try{
prt.executeUpdate();          
      /* oblist=cc_com.getItems();
        oo=cc_article.getSelectionModel().getSelectedItems();
        oo.forEach(oblist::remove);*/ // bekrii fema whda bedeltt fihaa kima hekaa fct ema mehomchh hedhomm ..
 }
       catch (SQLException e){
     System.out.println("errror occured when updating");
     e.printStackTrace();
     throw e;
     
 
    }}
  

    public Commentaires() {
    }


  

    public Commentaires(int id, String user,int article, Date date_pub, String Contenu) {
        this.id = id;
        this.user = user;
        this.date_pub = date_pub;
        this.message = message;
        this.article=article;
    }

    public Commentaires(int article,String message) {
       this.message= message;
        this.article=article;
       
    }
        public Commentaires(String message) {
       this.message= message;
       
       
    }
      public Commentaires(String Contenu, Articles_especes s) {
       this.message = message;
        this.s=s;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

 
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

  
  

    public Date getDate_pub() {
        return date_pub;
    }

    public void setDate_pub(Date date_pub) {
        this.date_pub = date_pub;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   

  
 

    
    
}
