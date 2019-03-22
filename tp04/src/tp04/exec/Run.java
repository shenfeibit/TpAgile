/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.exec;
//commentaire
import java.util.HashMap;
import tp04.metier.Action;
import tp04.metier.ActionComposee;
import tp04.metier.ActionSimple;
import tp04.metier.Jour;
import tp04.metier.Marche;
import tp04.metier.Portefeuille;

public class Run {

    public static void main(String[] args) {
        ActionSimple bnp, axa;
        ActionComposee bqAss;
        Jour j1, j2;

        // init des objets metiers Jour
        j1 = new Jour(2014, 1);
        j2 = new Jour(2014, 2);

        // creation d'actions simples et composée
        bnp = new ActionSimple("BNP");
        axa = new ActionSimple("AXA");
        bqAss = new ActionComposee("Banque-Assurance");
        // enrg de la composition de l'action composée
        bqAss.enrgComposition(axa, 0.3f);
        bqAss.enrgComposition(bnp, 0.7f);
        // enrg. de 2 cours pour chaque action
        axa.enrgCours(j1, 200);
        axa.enrgCours(j2, 250);
        bnp.enrgCours(j1, 100);
        bnp.enrgCours(j2, 200);
        // affichage des cours - comme 1 action simple et 1 action
        System.out.println("Action simple *bnp* à j1 : " + bnp.valeur(j1));
        System.out.println("Action *Banque-Assurance* à j2 : " + bqAss.valeur(j2));

        Marche m = new Marche("Marche Banque Assurance France");
        Portefeuille p;
        p = new Portefeuille("p1");
        m.addPortefeuille(p);
        p.acheter(axa, 10);
        System.out.println("Portefeuille : " + p);
        p.acheter(bnp, 20);
        System.out.println("Portefeuille : " + p);
        p.acheter(bqAss, 5);
        System.out.println("Portefeuille : " + p);
        p.acheter(bqAss, 15);
        System.out.println("Portefeuille : " + p);
        System.out.println("Portefeuille à j1 : " + p.valeur(j1));
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(bnp, 50);
        System.out.println("Portefeuille : " + p);

        Portefeuille p2 = new Portefeuille("p2");
        m.addPortefeuille(p2);
        p2.acheter(axa, 10);
        p.acheter(bqAss, 70);

        HashMap<Portefeuille, Float> mapM = m.consulterPortefeuilles(j1);
        for(Portefeuille por : mapM.keySet()){
            System.out.println("portfeuille: "+por.getLibelleP()+" valeur : "+mapM.get(por));
        }


        
        //consulter portefeuille des actions ainsi que leur valeurs:
        System.out.println("les actions du portefeuille et leurs valeurs:"+p.consultAct(j1));

        
        
        //tester variation
        for(Action aa : p.getVariation().keySet()){
            for(Jour j : p.getVariation().get(aa).keySet()){
                System.out.println(aa.getLibelle()+"-" + j.getNoJour() + " variation "+ p.getVariation().get(aa).get(j));
            }
        }
        
    }

}
