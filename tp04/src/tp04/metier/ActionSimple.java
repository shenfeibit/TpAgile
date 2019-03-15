/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class ActionSimple extends Action {

    // attribut lien
    private Map<Jour, Cours> mapCours;
    
    // constructeur
    public ActionSimple(String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        // init spécifique
        this.mapCours = new HashMap();
    }
    
    // enrg possible si pas de cours pour ce jour
    public void enrgCours(Jour j, float v) {
        if(this.mapCours.containsKey(j) == false)
            this.mapCours.put(j, new Cours(j, v));
    }
    
    @Override
    public float valeur(Jour j) {
        if(this.mapCours.containsKey(j) == true)
            return this.mapCours.get(j).getValeur();
        else 
            return 0; // definition d'une constante possible
    }
     public HashMap<Jour, Float> getVariation(){
        HashMap<Jour, Float> listeVariation = new HashMap<Jour, Float>();
        ArrayList<Jour> listeJour= new ArrayList<Jour>();
        ArrayList<Cours> listeCours= new ArrayList<Cours>();
        
        for (Jour j : this.mapCours.keySet()){
            listeJour.add(j);
            listeCours.add(this.mapCours.get(j));
        }
        
        for (int i=1; i<listeCours.size(); i++){
            float var = listeCours.get(i).getValeur()-listeCours.get(i-1).getValeur();
            listeVariation.put(listeJour.get(i), var);
        }
        
        return listeVariation;
    } 
    
}
