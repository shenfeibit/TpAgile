/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class Portefeuille {
    
    Map<Action, Integer> mapLignes;
    
   
    
    public Portefeuille() {
        this.mapLignes = new HashMap();
    }
    
    public void acheter(Action a, int q) {
        if (this.mapLignes.containsKey(a) == false) {
            this.mapLignes.put(a,q);
        } else {
            this.mapLignes.put(a,this.mapLignes.get(a)+q);
        }
    }

    public void vendre(Action a, int q) {
        if (this.mapLignes.containsKey(a) == true) {
            if (this.mapLignes.get(a)> q) {
                this.mapLignes.put(a,this.mapLignes.get(a)-q);
            } else if (this.mapLignes.get(a) == q) {
                this.mapLignes.remove(a);
            }
        }        
    }
    
    public String toString() {
        return this.mapLignes.toString();
    }

    public float valeur(Jour j) {
        float total = 0;
        for (Action a : this.mapLignes.keySet()) {
            total = total + (mapLignes.get(a) * a.valeur(j));
        }
        return total;
    }
}
