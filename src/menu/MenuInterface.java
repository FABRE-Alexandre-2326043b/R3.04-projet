package menu;

import hopital.NullPointerListeServicesMedicauxException;
import hopital.TropDeServicesMedicauxException;
import maladies.ErreurChangementNiveauException;
import serviceMedical.TropDeCreaturesException;

/**
 * Interface qui possède les signatures des fonctions de base d'un menu
 * */
public interface MenuInterface {
	/**
	 * Signature de la fonction qui permet d'afficher le menu
	 * */
    void afficherMenu() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, ErreurChangementNiveauException, TropDeServicesMedicauxException, TropDeCreaturesException;
	
	/**
	 * Signature qui présente les différents choix
	 * */
    void menuDeChoix() throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException, ErreurChangementNiveauException, TropDeServicesMedicauxException, TropDeCreaturesException;
}
