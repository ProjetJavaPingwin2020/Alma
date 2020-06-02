/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Articles_especes;
import Entity.CommentaireEvenement;
import Entity.Commentaires;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import utils.ConnexionBase;


/**
 *
 * @author USER
 */
public class CommentaireService {
    private final Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public CommentaireService() {
        cnx = ConnexionBase.getInstance().getCnx();
    }
public ObservableList<Commentaires> afficher(Commentaires A) throws SQLException {

        ObservableList<Commentaires> arr = FXCollections.observableArrayList();
         
        st = cnx.createStatement();//sahytk hahaha
        ResultSet rs = st.executeQuery("select * from commentaire ");

        while (rs.next()) {
    
            arr.add(new Commentaires(rs.getInt("article"),rs.getString("message")));

        }
         
              
        return arr;

    }
  
    public void update(Commentaires t, int id) throws SQLException {
        try {
            String requete = " update `commentaire` set message=?    where id='" + id + "'";
              Statement pst = cnx.createStatement();
       PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(2, t.getMessage());
          
            st.executeUpdate();
    
            } catch (SQLException ex) {
             System.out.println(ex);        
        }
    }
   public ObservableList<Commentaires> CommentaireLoad()
   {
   ObservableList<Commentaires> myListC = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM Commentaire";
            Statement pst = cnx.createStatement();
            ResultSet rs = pst.executeQuery(req);
            while (rs.next()) {
                Commentaires C = new Commentaires();
                C.setMessage(rs.getString("message"));
                C.setArticle(rs.getInt("article"));
                C.setDate_pub(rs.getDate("date_pub"));
                myListC.add(C);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return myListC;
    }
   
 /*public  List<Commentaires> afficherCommentaire() {
        List<Commentaires> tsCommentaire = new ArrayList<Commentaires>();
        ResultSet resultSet = null;
        // ResultSet resultSet2 = null;
          String req = "SELECT c.message,f.username FROM Commentaire c,fos_user f where f.id=c.user";
       try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);


            while (res.next()) {
                Commentaires p = new Commentaires ();
                               // p.setId_commentaire(res.getInt(3));
                p.setUser(res.getString(2));
                p.setMessage(res.getString(1));
              
                tsCommentaire.add(p);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tsCommentaire;

    }*/

    public void ajouuterCommentaire(Commentaires C) throws IOException {
   
    
        try {

            String requete = "INSERT INTO `commentaire` (`article`,`message`) VALUES (?,?)";//h
          
           PreparedStatement st = cnx.prepareStatement(requete);
         
          st.setInt(1, C.getArticle());
            st.setString(2, C.getMessage());
           
            st.executeUpdate();
            System.out.println("Commentaire ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }//mch logique ema njarabha hhh bebe mo5i t3eeb
     
                //ena mafhemtch chniya el mochekla mte3ouhhhhh aamel ithrab 

    
}
     public void updateArticle (Commentaires A, int id) throws IOException {


         try {

                     
            String requete ="UPDATE `commentaire` SET message = ? WHERE id = ?";
             PreparedStatement st = cnx.prepareStatement(requete);
             st.setString(1,A.getMessage());
           
             st.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Articles_especes.class.getName()).log(Level.SEVERE, null, ex);
         }
              JOptionPane.showMessageDialog(null, "update avec succes");



    }
    

     public int searchBynom(String nom) {
         int x = 9999;
     
          String req = "select id from commentaire where nom='" + nom + "'";
          PreparedStatement preparedStatement;
        try {
            preparedStatement = cnx.prepareStatement(req);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                x = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return x;
    }
  public void modifier(Commentaires s, int id) throws SQLException {
      
       try {
            if ((s.getMessage() != "")) {
                String query = "update commentaire set message='" + s.getMessage()+"' where id=" + id;          
                st = cnx.createStatement();
                st.executeUpdate(query);
                System.out.println("bien modifiée");
            } else {
                System.out.println("tu dois inserer tous les elements");
            }
        } catch (SQLException ex) {

       
  }
  
  }

    public void supprimer(int id) throws SQLException {
        st = cnx.createStatement();
        String q = "delete from Commentaire where id= " + id;
        PreparedStatement pre = cnx.prepareStatement(q);
        st.executeUpdate(q);
        System.out.println("tu as bien supprimé");
    }
    

}
