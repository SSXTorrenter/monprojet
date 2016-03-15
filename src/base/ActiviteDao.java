package base;

import java.util.*;
import domaine.*;
import java.sql.Connection;     // connexion à la BD
import java.sql.Statement;      // interrogation de la base de données
import java.sql.ResultSet;      // le résultat de la requête
import java.sql.SQLException;   // gestion de l'exception "SQLException"

/**
 * 634.1 Programmation - TP P02
 * 
 * Gestion des accès à la base de données pour l'entité Activite.
 * 
 * @author Olivier CHEVALLIER
 * @version 1.0
*/
public class ActiviteDao {
    /**
     * Retourne la liste de toutes les activités stockées dans la base de données sous forme d'une ArrayList
     * @return La liste des activités
     */
    public static ArrayList listeActivites(){
        ArrayList liste = new ArrayList();
        try{
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Activite;");
            while(rs.next()){
                Activite activite = new Activite(rs.getInt("NoAct"), rs.getString("Libelle"));
                liste.add(activite);
            }
        }
        catch(SQLException e){ 
            System.out.println("ActiviteDao.listeActivites(): " + e.getMessage());
            e.printStackTrace();
        }
        return liste;
    }
    
    /**
     * Retourne la liste des activités (sous forme d'une ArrayList) pour un participant donné.
     * @param participant Le participant
     * @return La liste des activités
     */
    public static ArrayList listeActiviteParticipant(Participant participant){
        ArrayList liste = new ArrayList();
        int noParticipant = participant.getNoPart();
        try{
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Activite JOIN PrendPart ON Activite.NoAct = PrendPart.NoAct WHERE noPart = " + noParticipant + ";");
            while(rs.next()){
                Activite activite = new Activite(rs.getInt("NoAct"), rs.getString("Libelle"));
                liste.add(activite);
            }
        }
        catch(SQLException e) {
            System.out.println("ActiviteDao.listeActiviteParticipant(): " + e.getMessage());
            e.printStackTrace();
        }
        return liste;
    }
    
    /**
     * Supprime l'activité d'un participant
     * @param participant le participant auquel on doit supprimer l'activité
     * @param activite l'activité a supprimer
     */
    public static void supprimerActiviteParticipant(Participant participant, Activite activite){
        int noParticipant = participant.getNoPart();
        int noActivite = activite.getNoAct();
        try{
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM PrendPart WHERE noPart = " + noParticipant + " AND noAct = " + noActivite + ";");
        }
        catch(SQLException e) {
            System.out.println("ActiviteDao.supprimerActiviteParticipant(): " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Ajoute une activité à un participant
     * @param participant Le participant auquel on doit ajouter l'activité
     * @param activite L'activité à ajouter
     */
    public static void ajouterActiviteParticipant(Participant participant, Activite activite){
        int noParticipant = participant.getNoPart();
        int noActivite = activite.getNoAct();
        try{
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO PrendPart (NoPart, NoAct) VALUES ('" + noParticipant + "', '" + noActivite + "');");
        }
        catch(SQLException e) {
            System.out.println("ActiviteDao.ajouterActiviteParticipant(): " + e.getMessage());
            e.printStackTrace();
        }
    }
}
