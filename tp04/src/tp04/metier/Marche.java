/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *This class is created to manage all the "portefeuilles" in the market.
 *
 * @author Fei and Nassiba
 */
public class Marche {
    /**
     * libelleM : the libelle of the market.
     */
    private String libelleM;
    /**
     * This ArrayList stock all the "portefeuilles".
     */
    private ArrayList<Portefeuille> listP;
    /**
     * This is the constructor of the class "Marche".
     *
     * @param libelle : the libelle created
     */
    public Marche(final String libelle) {
        this.libelleM = libelle;
        this.listP = new ArrayList<>();
    }
    /**
     * This is the getter of the libelle of the market.
     *
     * @return the libelle
     */
    public final String getLibelleM() {
        return libelleM;
    }
    /**
     * This is the setter of the libelle of the market.
     *
     * @param libelle : the new libelle created
     */
    public final void setLibelleM(final String libelle) {
        this.libelleM = libelle;
    }
    /**
     * This is the getter of the list of "portefeuilles".
     *
     * @return the list of "portefeuilles"
     */
    public final ArrayList<Portefeuille> getListP() {
        return listP;
    }
    /**
     *This is the setter of the list of "portefeuilles".
     *
     * @param list : the list modified
     */
    public final void setListP(final ArrayList<Portefeuille> list) {
        this.listP = list;
    }
    /**
     *This method give the possibility to consult values of all "portefeuilles".
     *
     * @param j : the day given
     * @return the HashMap with all "portfeuilles" and their values
     */
    public final HashMap<Portefeuille, Float>
        consulterPortefeuilles(final Jour j) {
        HashMap<Portefeuille, Float> mapPortefeuille;
        mapPortefeuille = new HashMap<>();
        for (Portefeuille por: listP) {
            float val = por.valeur(j);
            mapPortefeuille.put(por, val);
        }
        return mapPortefeuille;
    }

}
