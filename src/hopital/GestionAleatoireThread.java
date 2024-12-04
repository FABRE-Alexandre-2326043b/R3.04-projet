package hopital;

import creatures.Creature;
import creatures.Lycanthrope;
import creatures.Meute;
import maladies.BalonnementGastrique;
import maladies.DependanceAuxReseauxSociaux;
import maladies.ErreurChangementNiveauException;
import maladies.Maladie;
import maladies.MaladieDebilitanteChronique;
import maladies.ProphyrieErythropoietiqueCongenitale;
import maladies.SyndromeFearOfMissingOut;
import maladies.ZoopathiePaeaphreniqueLycanthropique;
import serviceMedical.ServiceMedical;

import java.util.List;
import java.util.Random;

public class GestionAleatoireThread implements Runnable {
    private List<Meute> meutes;
    private List<ServiceMedical> servicesMedicaux;

    public GestionAleatoireThread(List<Meute> meutes, List<ServiceMedical> servicesMedicaux) {
        this.meutes = meutes;
        this.servicesMedicaux = servicesMedicaux;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(5000); // Pause entre chaque action aléatoire
                int action = random.nextInt(4);

                switch (action) {
                    case 0 -> lancerHurlementAleatoire();
                    case 1 -> reproductionAleatoire();
                    case 2 -> transformationEnHumainAleatoire();
                    case 3 -> maladieAleatoire();
                }
            } catch (InterruptedException e) {
                System.out.println("Simulation arrêtée.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void lancerHurlementAleatoire() {
        if (meutes.isEmpty()) return;

        Random random = new Random();
        Meute meute = meutes.get(random.nextInt(meutes.size()));
        if (meute.getMembres().isEmpty()) return;

        Lycanthrope lycanthrope = meute.getMembres().get(random.nextInt(meute.getMembres().size()));
        lycanthrope.hurler();
    }

    private void reproductionAleatoire() {
        if (meutes.isEmpty()) return;

        Random random = new Random();
        Meute meute = meutes.get(random.nextInt(meutes.size()));
        meute.reproduction();
        System.out.println("Une reproduction a eu lieu dans une meute !");
    }

    private void transformationEnHumainAleatoire() {
        if (meutes.isEmpty()) return;

        Random random = new Random();
        Meute meute = meutes.get(random.nextInt(meutes.size()));
        if (meute.getMembres().isEmpty()) return;

        Lycanthrope lycanthrope = meute.getMembres().get(random.nextInt(meute.getMembres().size()));
        lycanthrope.seTransformerEnHumain();
    }


private void maladieAleatoire() {
    if (servicesMedicaux.isEmpty()) return;

    Random random = new Random();
    ServiceMedical service = servicesMedicaux.get(random.nextInt(servicesMedicaux.size()));
    if (service.getListeCreatures().isEmpty()) return;

    for (Creature creature : service.getListeCreatures()) {
        Maladie maladie = getRandomMaladie();
        creature.tomberMalade(maladie);
        System.out.println(creature.getNomComplet() + " est tombé malade avec " + maladie.getNomComplet() + " !");
    }
}

private Maladie getRandomMaladie() {
    Random random = new Random();
    int maladieType = random.nextInt(6); // Assuming there are 6 types of Maladie subclasses

    try {
        switch (maladieType) {
            case 0:
                return new BalonnementGastrique(100);
            case 1:
                return new DependanceAuxReseauxSociaux(100);
            case 2:
                return new MaladieDebilitanteChronique(100);
            case 3:
                return new ProphyrieErythropoietiqueCongenitale(100);
            case 4:
                return new SyndromeFearOfMissingOut(100);
            case 5:
                return new ZoopathiePaeaphreniqueLycanthropique(100);
            default:
                return null;
        }
    } catch (ErreurChangementNiveauException e) {
        e.printStackTrace();
        return null;
    }
}

}
