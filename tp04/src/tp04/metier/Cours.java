/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

/**
 *This is the class "cours" provide the value of share related to a day.
 * @author Fei and Nassiba
 */
public class Cours {
        /**
         *This is the day given.
         */
        private final Jour jour;
        /**
         *This is the value of share related to the day.
         */
        private final float valeur;
        /**
         * This is the getter of the value.
         *
         * @return : the value
         */
        public final float getValeur() {
            return valeur;
        }
        /**
         * This is the getter of the day.
         *
         * @return : the day
         */
        public final Jour getJour() {
            return jour;
        }
        /**
         * This is the constructor of the "cours".
         *
         * @param jou : the jour given
         * @param val : the value of the share given
         */
        public Cours(final Jour jou, final float val) {
            this.jour = jou;
            this.valeur = val;
        }

    }
