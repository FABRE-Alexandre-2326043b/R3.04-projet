package hopital;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import creatures.Creature;
import medecins.Medecin;
import serviceMedical.ServiceMedical;


/**
 * La classe <strong>Hôpital</strong> est une classe qui permet de gérer les éléments d'un hôpital, en particulier
 * la gestion du personnel et des patiens.<br>
 * Une instance de la classe possède un nom et 2 tableaux dynamiques:<br>
 *   - listeServicesMedicauxExistants: un tableau dynamique qui contient tous les services médicaux de l'hôpital<br>
 *   - listeMedecins : un tableau dynamique qui est composée des médecins qui sont à l'hôpital.<br><br>
 * Chaque hôpital peut ajouter un service médical ou un médecin avec les méthodes ajouterServiceMedical(ServiceMedical serviceMedical)
 * 																			   et ajouterMedecin(Medecin medecin).
 * */
public class Hopital {
	//Attributs
	/**
	 * Le nom de l'hôpital
	 * */
	private String nom;
	
	/**
	 * Le nombre maximum de Services Médicaux disponible dans l'hôpital
	 * */
	private int nbServicesMedicauxMax;
	
	/**
	 * La liste des services médicaux qui sont présents dans l'hôpital. Chaque élément de ce tableau dynamique est un objet ServiceMedical.
	 * */
	private List<ServiceMedical> listeServicesMedicauxExistants = new ArrayList<ServiceMedical>();
	
	/**
	 * La liste des médecins présents dans l'hôpital. Chaque élément de ce tableau dynamique est un objet Médecin.
	 * */
	private List<Medecin> listeMedecins = new ArrayList<Medecin>();
	
	
	//Constructeur
	
	
	public Hopital(String nom, int nbServicesMedicauxMax) {
		this.nom = nom;
		this.nbServicesMedicauxMax = nbServicesMedicauxMax;
	}
	
	public void ajouterMedecin(Medecin medecin) {
		this.listeMedecins.add(medecin);
	}
	
	public void ajouterServiceMedical(ServiceMedical serviceMedical) throws TropDeServicesMedicauxException {
		if (this.listeServicesMedicauxExistants.size() == this.nbServicesMedicauxMax) {
			throw new TropDeServicesMedicauxException();
		}
		this.listeServicesMedicauxExistants.add(serviceMedical);
	}
	
	public boolean serviceMedicalExiste(ServiceMedical serviceMedical) {
		boolean existe = false;
		Iterator<ServiceMedical> iterateur = this.listeServicesMedicauxExistants.iterator();
		for (; iterateur.hasNext(); ) {
			if (iterateur.next() == serviceMedical) {
				existe = true;
			}
		}
		return existe;
	}
	
	public int connaitreNombreCreatures() {
		int compteur = 0;
		Iterator<ServiceMedical> iterateurServiceMedical = this.listeServicesMedicauxExistants.iterator();
		while (iterateurServiceMedical.hasNext()) {
			Iterator<Creature> iterateurCreature = iterateurServiceMedical.next().getListeCreatures().iterator();
			while (iterateurCreature.hasNext()) {
				++compteur;
			}
		}
		return compteur;
	}
	
	public void afficherCreatures() {
		for (int i = 0; i < listeServicesMedicauxExistants.size(); ++i) {
			Iterator<Creature> iterateurCreature = listeServicesMedicauxExistants.get(i).getListeCreatures().iterator();
			for (; iterateurCreature.hasNext();) {
				System.out.println(iterateurCreature.next().toString() + ",");
			}
		}
	}
	
	
	//toString
	
	/**
	 * Affiche les caractéristiques d'une instance d'hôpital.
	 * @return String chaîne de caractères listants toutes les valeurs des attributs d'une instance de la classe Hopital.
	 * */
	@Override
	public String toString() {
		return "Hopital[nom=" + this.nom +
				", nbServicesMedicauxMax=" + this.nbServicesMedicauxMax +
				", listeServicesMedicauxExistants=" + this.listeServicesMedicauxExistants +
				", listeMedecins" + this.listeMedecins + "]";
	}
	
}
