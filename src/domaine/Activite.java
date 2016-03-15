package domaine;

/**
 * 634.1 Programmation - TP P02
 * 
 * @author Olivier CHEVALLIER
 * @version 1.0
*/
public class Activite {
    private int noAct;
    private String libelle;
    
    public Activite (int noAct, String libelle){
        this.noAct = noAct;
        this.libelle = libelle;
    }
    
    public boolean equals (Activite activite){ 
        return this.noAct == activite.noAct;
    }
    
    public int getNoAct(){ return this.noAct;}
    
    public String toString(){ return this.libelle; }
}
