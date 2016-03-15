package metier;

import java.util.*;
import base.ParticipantDao;
import domaine.Participant;

/**
 * 634.1 Programmation - TP P02
 * 
 * @author olivierchevallier
 * @version 1.0
*/
public class ListeParticipants  {
    ArrayList liste;
    
    public ListeParticipants(){ liste = ParticipantDao.getListeParticipants(); }
    
    public int size() { return this.liste.size(); }
    
    public Participant get(int pos) { return (Participant)this.liste.get(pos); }
}
