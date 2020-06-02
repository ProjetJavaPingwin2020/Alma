/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Articles_especes;
import Entity.CommentaireEvenement;
import Entity.Commentaires;
import Entity.FosUser;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import utils.ConnexionBase;


/**
 *
 * @author USER
 */


/**
 *
 * @author solta
 */
public class ServiceCommentaireEvenement {
 private final Connection cnx;
    private Statement st;
    private PreparedStatement pre;

   

    public ServiceCommentaireEvenement() {
              cnx = ConnexionBase.getInstance().getCnx();
    }

  public ObservableList<Commentaires> afficher(Commentaires A) throws SQLException {

        ObservableList<Commentaires> arr = FXCollections.observableArrayList();
         
        st = cnx.createStatement();//sahytk hahaha
        ResultSet rs = st.executeQuery("select * from Commentaire ");

        while (rs.next()) {
    
            arr.add(new Commentaires(rs.getInt("article"),rs.getString("message")));

        }
         
              
        return arr;

    }
  public ObservableList<CommentaireEvenement> CommentaireLoad()
   {
   ObservableList<CommentaireEvenement> myListC = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM Commentaire";
            Statement pst = cnx.createStatement();
            ResultSet rs = pst.executeQuery(req);
            while (rs.next()) {
               CommentaireEvenement C = new CommentaireEvenement();
                C.setMeessage(rs.getString("message"));
                C.setArticle(rs.getInt("article"));
                myListC.add(C);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return myListC;
    }

    /* public void ajouuterCommentaire(CommentaireEvenement C) throws IOException {
   
    
        try {

            String requete = "INSERT INTO `Commentaire` (`article`,`message`) VALUES (?,?)";//
           PreparedStatement st = cnx.prepareStatement(requete);
          st.setInt(1, C.getArticle());
            st.setString(2, C.getMessage());
           
            st.executeUpdate();
            System.out.println("Commentaire ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }}*/

 /*   public void  ajouterCommentaireEvenement(String commentaireEvenement,int id) throws SQLException {
        
        String sql = "INSERT INTO Commentaire(message) VALUES('" + commentaireEvenement + "')";
       try {
          PreparedStatement  pst = cnx.prepareStatement(sql);
            pst.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }*/

   
    public  List<Commentaires> afficherCommentaire() {
        List<Commentaires> tsCommentaire = new ArrayList<Commentaires>();
        ResultSet resultSet = null;
        // ResultSet resultSet2 = null;
          String req = "SELECT c.message,c.date_pub,f.username FROM Commentaire c,fos_user f where f.id=c.user";
       try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);


            while (res.next()) {
                Commentaires p = new Commentaires();
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

    }

  public void modifier(Commentaires s, int id) throws SQLException {
        try {
            if ((s.getMessage() != "")) {
                String query = "update Commentaire set message='" + s.getMessage() + "' where Commentaire.id=" + id;
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
    

