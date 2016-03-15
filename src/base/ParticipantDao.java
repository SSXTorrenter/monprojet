package base;

import domaine.Activite;
import domaine.Participant;
import java.util.*;
import java.sql.Connection;     // connexion à la BD
import java.sql.Statement;      // interrogation de la base de données
import java.sql.ResultSet;      // le résultat de la requête
import java.sql.SQLException;   // gestion de l'exception "SQLException"

/**
 * 634.1 Programmation - TP P02
 * 
 * Gestion des accès à la base de données pour l'entité Participant.
 * 
 * @author Olivier CHEVALLIER
 * @version 1.0
*/
public class ParticipantDao {
    /**
     * Retourne tous les participants stockés dans la base de donneés sous forme d'une ArrayList
     * @return La liste des participants
     */
    public static ArrayList getListeParticipants(){
        ArrayList liste = new ArrayList();
        try{
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Participant;");
            while (rs.next()) {
                Participant participant = new Participant(rs.getInt("NoPart"), rs.getString("Nom"), rs.getString("Prenom"), rs.getString("Telephone"));
                liste.add(participant);
            }
            stmt.close();
        }
        catch (SQLException e){
            System.out.println("ParticipantDao.getListeParticipants(): " + e.getMessage());
            e.printStackTrace();
        }
        return liste;
    }
}
