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
public class ActionComposee extends Action {
    // attribut lien
    Map<ActionSimple, Float> mapPanier;

    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }
    
    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }

    @Override
    public float valeur(Jour j) {
        float valeur;
        
        valeur = 0;
        for(ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }
        
        return valeur;
    }
    
    public HashMap<Jour, Float> getVariation(){
        HashMap<Jour, Float> listeVariation = new HashMap<Jour, Float>();
        ArrayList<Jour> listeJour= new ArrayList<Jour>();
        ArrayList<Float> listeCours= new ArrayList<Float>();
        
        Map.Entry<ActionSimple, Float> entry = mapPanier.entrySet().iterator().next();
        ActionSimple key= entry.getKey();
 
        for (Jour j : key.getVariation().keySet()){
            listeJour.add(j);
            listeCours.add(this.valeur(j));
        }
        
        for (int i=1; i<listeJour.size(); i++){
            float var = listeCours.get(i)-listeCours.get(i-1);
            listeVariation.put(listeJour.get(i), var);
        }
        return listeVariation;
    } 
    
    
}
