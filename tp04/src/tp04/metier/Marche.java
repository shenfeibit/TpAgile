/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 21511708
 */
public class Marche {
    
    private String libelleM;
    private ArrayList<Portefeuille> listP ;

    public Marche(String libelleM) {
        this.libelleM = libelleM;
        this.listP = new ArrayList<Portefeuille>();
    }

    public String getLibelleM() {
        return libelleM;
    }

    public void setLibelleM(String libelleM) {
        this.libelleM = libelleM;
    }

    public ArrayList<Portefeuille> getListP() {
        return listP;
    }

    public void setListP(ArrayList<Portefeuille> listP) {
        this.listP = listP;
    }
    
    public HashMap<Portefeuille, Float> consulterPortefeuilles(Jour j){
        HashMap<Portefeuille, Float> mapPortefeuille;
        mapPortefeuille = new HashMap<Portefeuille, Float>();
        for(Portefeuille por: listP){
            float val = por.valeur(j);
            mapPortefeuille.put(por, val);
        }
        return mapPortefeuille;
    }
    
}
