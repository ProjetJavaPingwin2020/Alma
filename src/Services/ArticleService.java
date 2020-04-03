/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Articles_especes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import utils.ConnexionBase;


/**
 *
 * @author USER
 */
public class ArticleService {
    private final Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public ArticleService() {
        cnx = ConnexionBase.getInstance().getCnx();
    }

  
   public ObservableList<Articles_especes> ArticleLoad()
   {
   ObservableList<Articles_especes> artList = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM articles_especes";
            Statement pst = cnx.createStatement();
            ResultSet rs = pst.executeQuery(req);
            while (rs.next()) {
                Articles_especes A = new Articles_especes();
                A.setTitre(rs.getString("titre"));
                A.setContenu(rs.getString("Contenu"));
               
                 A.setImage(rs.getString("image"));
                 ImageView v=new ImageView();
                   v.setImage(new Image(rs.getString("image")));
                   v.setFitHeight(50);
                   v.setFitWidth(50);
                A.setPhoto(v);
                artList.add(A);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return artList;
    }

     public void ajouuterArticle(Articles_especes A) throws IOException {
         
    
        try {

            String requete
                    = "INSERT INTO `articles_especes` (`Titre`, `Contenu`,`image`,`type`) VALUES (?,?,?,?)";
        PreparedStatement st = cnx.prepareStatement(requete);
        st.setString(1, A.getTitre());
        st.setString(2, A.getContenu());
        st.setString(3, A.getImage());
            st.executeUpdate();
            System.out.println("article ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }}
 public void deleteArticle(int id) throws SQLException {
        String req = "DELETE FROM`articles_especes` WHERE idArticle='" + id + "'";
        PreparedStatement ste = cnx.prepareStatement(req);
        ste.executeUpdate();
    }

public void updateArticle (Articles_especes A, int id) throws IOException {


         try {

                     
            String requete ="UPDATE `articles_especes` SET Titre = ? Comtenu =? ,image = ?  WHERE id = ?";
             PreparedStatement st = cnx.prepareStatement(requete);
             st.setString(1,A.getTitre());
             st.setString(2,A.getContenu());
             st.setString(3,A.getImage());
             st.setInt(3,id);
             st.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Articles_especes.class.getName()).log(Level.SEVERE, null, ex);
         }
            System.out.println("update valide");



    }

    }

