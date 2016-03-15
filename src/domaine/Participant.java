package domaine;

/**
 * 634.1 Programmation - TP P02
 * 
 * @author Olivier CHEVALLIER
 * @version 1.0
*/
public class Participant {
    private int noPart;
    private String nom;
    private String prenom;
    private String telephone;
    
    public Participant (int noPart, String nom, String prenom, String telephone){
        this.noPart = noPart;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }
    
    public boolean equals(Participant participant){
        return this.noPart == participant.noPart;
    }
    
    public String toString(){ return this.nom + " " + this.prenom; }
    
    public int getNoPart(){ return this.noPart; }
    
    public String getNom(){ return this.nom; }
    
    public String getPrenom(){ return this.prenom; }
    
    public String getTelephone(){ return this.telephone; }
}
