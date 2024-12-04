
package hopital;

import maladies.ErreurChangementNiveauException;
import menu.*;
import serviceMedical.TropDeCreaturesException;
import creatures.Meute;
import serviceMedical.ServiceMedical;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MauvaiseEntreeException, NullPointerListeServicesMedicauxException,
                                                  ErreurChangementNiveauException, TropDeServicesMedicauxException,
                                                  TropDeCreaturesException {
        List<Meute> meutes = new ArrayList<>();
        List<ServiceMedical> servicesMedicaux = new ArrayList<>();

        GestionAleatoireThread gestionAleatoire = new GestionAleatoireThread(meutes, servicesMedicaux);
        Thread simulationThread = new Thread(gestionAleatoire);
        simulationThread.start();

        MenuPrincipal menuPrincipal = MenuPrincipal.getInstanceMenuPrincipal();
        menuPrincipal.afficherMenuDemarrageApplication();
        System.out.println("Configuration initiale terminée!");
        menuPrincipal.afficherMenu();

        simulationThread.interrupt();
        System.out.println("Merci d'avoir utilisé le logiciel de gestion de l'hôpital fantastique.");

        menuPrincipal.closeScanner();
    }
}
