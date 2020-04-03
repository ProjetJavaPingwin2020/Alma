/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Articles_especes;
import Entity.Commentaires;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class CommentaireService {
    private final Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public CommentaireService() {
        cnx = ConnexionBase.getInstance().getCnx();
    }

  
   public ObservableList<Commentaires> CommentaireLoad()
   {
   ObservableList<Commentaires> myListC = FXCollections.observableArrayList();
        try {
            String req = "SELECT * FROM Commentaires";
            Statement pst = cnx.createStatement();
            ResultSet rs = pst.executeQuery(req);
            while (rs.next()) {
                Commentaires C = new Commentaires();
                C.setContenu(rs.getString("Contenu"));
                C.setDate_pub(rs.getDate("Date_pub"));
                myListC.add(C);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return myListC;
    }

     public void ajouuterCommentaire(Commentaires C) throws IOException {
   
    
        try {

            String requete = "INSERT INTO `Commentaires` (`Contenu`) VALUES (?)";
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(1, C.getContenu());
            st.executeUpdate();
            System.out.println("Commentaire ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

    }
}

