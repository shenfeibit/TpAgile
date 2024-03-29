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
public class Portefeuille {
    private final String libelleP;
    /**
     * This is the hashmap where we stock the "actions" and thier vlaues.
     */
    private final Map<Action, Integer> mapLignes;
    /**
     * This is the constructor of class "portefeuille".
     */
    public Portefeuille(final String libelle) {
        this.libelleP=libelle;
        this.mapLignes = new HashMap();
    }

    public String getLibelleP() {
        return libelleP;
    }
    
    /**
     * This method provide the possibility for clients to buy the shares.
     *
     * @param a : the share to be bought
     * @param q : the quantity of the share to be bought
     */
    public final void acheter(final Action a, final int q) {
        if (!this.mapLignes.containsKey(a)) {
            this.mapLignes.put(a, q);
        } else {
            this.mapLignes.put(a, this.mapLignes.get(a) + q);
        }
    }
    /**
     * This method provide the possibility for clients to sale the shares.
     *
     * @param a : the share to be saled
     * @param q : the quantity of the share to be saled
     */
    public final void vendre(final Action a, final int q) {
        if (this.mapLignes.containsKey(a)) {
            if (this.mapLignes.get(a) > q) {
                this.mapLignes.put(a, this.mapLignes.get(a) - q);
            } else if (this.mapLignes.get(a) == q) {
                this.mapLignes.remove(a);
            }
        }
    }
    /**
     * This is the method provide the text of the hashmap.
     *
     * @return the text
     */
    @Override
    public final String toString() {
        return this.mapLignes.toString();
    }
    /**
     * This method retun the value of the "portefeuille" of a day given.
     *
     * @param j : the day given
     * @return the value of the "portefeuille"
     */
    public final float valeur(final Jour j) {
        float total = 0;
        for (Action a : this.mapLignes.keySet()) {
            total = total + (mapLignes.get(a) * a.valeur(j));
        }
        return total;
    }
    public HashMap<Action,Float> consultAct(Jour j){

         HashMap<Action,Float> hash= new HashMap<>();
        for(Action act:this.mapLignes.keySet()){
            hash.put(act,act.valeur(j));

        }
          return hash;
    }
    
     public Map<Action, Map<Jour,Float>> getVariation(){
        Map<Action, Map<Jour,Float>> map = new HashMap<Action, Map<Jour,Float>>();
        
        for (Action a : this.mapLignes.keySet()){
            map.put(a, a.getVariation());
            
        }
     
        return map;
    }


}

