package hopital;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import creatures.Creature;
import maladies.Maladie;
import medecins.Medecin;
import serviceMedical.ServiceMedical;
import serviceMedical.TropDeCreaturesException;


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

	/**
	 * Instance de l'hôpital utilisé dans le modèle Singleton
	 * */
	private static Hopital instance;
	
	
	//Constructeur
	
	/**
	 * Constructeur de la classe Hopital
	 * @param nom String: nom de l'hôpital
	 * @param nbServicesMedicauxMax int: le nombre de services médicaux maximum dans l'hôpital
	 * */
	private Hopital(String nom, int nbServicesMedicauxMax) {
		this.nom = nom;
		this.nbServicesMedicauxMax = nbServicesMedicauxMax;
	}

	/**
	 *
	 * */
	public static Hopital getInstance() {
		if (instance == null) {
			instance = new Hopital("Hopital", 1);
		}
		return instance;
	}

	/**
	 * Fonction qui permet d'ajouter une instance de type Medecin dans un tableau dynamique
	 * @param medecin Medecin: un médecin
	 * @see Medecin
	 * */
	public void ajouterMedecin(Medecin medecin) {
		this.listeMedecins.add(medecin);
	}

	/**
	 * Fonction qui permet de supprimer un instance de type Medecin dans un tableau dynamique
	 * @param medecin Medecin: un médecin
	 * @see Medecin
	 * */
	public void supprimerMedecin(Medecin medecin) {
		this.listeMedecins.remove(medecin);
	}

	/***/
	public Medecin getMedecin(String nom) {
		for (Medecin medecin : this.listeMedecins) {
			if (medecin.getNom().equals(nom)) {
				return medecin;
			}
		}
		return null;
	}

	/**
	 * Fonction qui permet d'ajouter une instance de type ServiceMedical
	 * @param serviceMedical ServiceMedical: un service médical
	 * @throws TropDeServicesMedicauxException Exception qui occure si le nombre de services médicaux est dépassé.
	 * @see ServiceMedical
	 * */
	public void ajouterServiceMedical(ServiceMedical serviceMedical) throws TropDeServicesMedicauxException {
		if (this.listeServicesMedicauxExistants.size() == this.nbServicesMedicauxMax) {
			throw new TropDeServicesMedicauxException();
		}
		this.listeServicesMedicauxExistants.add(serviceMedical);
	}
	/**
	 * Fonction qui permet de supprimer une instance de type ServiceMedical
	 * @param serviceMedical ServiceMedical: un service médical
	 * @throws NullPointerListeServicesMedicauxException Exception qui est envoyée si on veut supprimer un service médical alors qu'il y en a pas
	 * @see ServiceMedical
	 * */
	public void supprimerServiceMedical(ServiceMedical serviceMedical) throws NullPointerListeServicesMedicauxException {
		if (this.listeServicesMedicauxExistants.isEmpty()) {
			throw new NullPointerListeServicesMedicauxException();
		}
		this.listeServicesMedicauxExistants.remove(serviceMedical);
	}

	public ServiceMedical getServiceMedical(String nom) {
		for (ServiceMedical serviceMedical : this.listeServicesMedicauxExistants) {
			if (serviceMedical.getNom().equals(nom)) {
				return serviceMedical;
			}
		}
		return null;
	}

	/**
	 * Fonction permettant de connaître le nombre de créatures
	 * @return compteur int: Compteur du nombre de créatures dans l'hôpital
	 * */
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

	/**
	 * Fonction permettant l'affichage de toute les créatures de l'hôpital.
	 * */
	public void afficherCreatures() {
		for (int i = 0; i < listeServicesMedicauxExistants.size(); ++i) {
			System.out.println(listeServicesMedicauxExistants.get(i).getNom() + "a pour créatures: ");
			Iterator<Creature> iterateurCreature = listeServicesMedicauxExistants.get(i).getListeCreatures().iterator();
			for (; iterateurCreature.hasNext();) {
				System.out.println("\t" + iterateurCreature.next().toString());
			}
		}
	}

	/**
	 * Permet au médecin d'examiner le service médical passé en paramètre
	 * @param serviceMedical ServiceMedical: service médical que le médecin contrôle
	 * @param medecin Medecin: un médecin de l'hôpital
	 * @see ServiceMedical
	 * */
	public void examinerServiceMedical(Medecin medecin, ServiceMedical serviceMedical) {
		serviceMedical.afficherCaracteristiquesCreatures();
	}

	/**
	 * Permet au médecin de soigner les créatures d'un service médical
	 * @param serviceMedical ServiceMecial: service médical auquel le médecin
	 * @see ServiceMedical
	 * */
	public void soignerCreatures(ServiceMedical serviceMedical, Creature creature, Maladie maladie) {
		serviceMedical.soignerCreature(creature, maladie);
	}

	/**
	 * Permet au médecin de revoir le budget d'un service médical
	 * @param serviceMedical ServiceMedical: service médical dont le médecin veut modifier le budget
	 * @see ServiceMedical
	 * */
	public void reviserBudgetServiceMedical(ServiceMedical serviceMedical) {
		serviceMedical.reviserBudget();
	}

	/**
	 * Permet de transférer une créature d'un service médical à l'autre
	 * @param creature Creature: créature qui sera transférée
	 * @param serviceMedicalEnvoyante: service médical qui envoie sa créature dans un autre service médical
	 * @see ServiceMedical: service médical qui reçoit la créature envoyée
	 * @see Creature
	 * */
	public void transfererCreatureServicesMedicales(Creature creature,
													ServiceMedical serviceMedicalEnvoyante,
													ServiceMedical serviceMedicalReceptrice) throws TropDeCreaturesException {
		serviceMedicalReceptrice.retirerCreature(creature);
		serviceMedicalEnvoyante.ajouterCreature(creature);
	}

	/**
	 * Permet de récupérer le nom de l'hôpital
	 * @return String nom: nom de l'hôpital
	 * */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Permet de modifier le nom de l'hôpital
	 * @param nom String: Nouveau nom de l'hôpital
	 * */
	public void setNom (String nom) {
		this.nom = nom;
	}

	/**
	 * Permet de modifier le nombre maximum de services médicaux
	 * @param nbServicesMedicauxMax int: le nombre maximum de services médicaux
	 */
	public void setNbServicesMedicauxMax (int nbServicesMedicauxMax) {
		this.nbServicesMedicauxMax = nbServicesMedicauxMax;
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
