package creatures;

import java.util.ArrayList;

import maladies.Maladie;

public class Creature {
    public String nomComplet ;
    public String sexe ;
    public int poids ;
    public int taille ;
    public int age ;
    public int indicateurMoral ;
    public ArrayList<Maladie> listeMaladies ;

    public void attendre () {
        indicateurMoral-=1;
    }
    public ArrayList<Maladie> getListeMaladies() {
		return listeMaladies;
	}
	public void hurler () {
        System.out.println(nomComplet + " hurle");
    }
    public void sEmporter (){
        System.out.println(nomComplet + " s'emporte");
    }
    public void tomberMalade (Maladie maladie){
        System.out.println(nomComplet + " tombe malade de " + maladie.getNomComplet());
        listeMaladies.add(maladie);
    }
    public void etreSoigne (Maladie maladie) {
        System.out.println(nomComplet + "est guéri de " + maladie.getNomComplet());
        listeMaladies.remove(maladie);
    }
    public void trepasser(){
        System.out.println(nomComplet + "trépasse");
    }
}
