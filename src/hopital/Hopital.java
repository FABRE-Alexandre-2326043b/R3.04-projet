package hopital;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import medecins.Medecin;
import serviceMedical.ServiceMedical;

public class Hopital {
	//Attributs
	
	
	private String nom;
	
	
	private int nbServicesMedicauxMax;
	
	
	private List<ServiceMedical> listeServicesMedicauxExistants = new ArrayList<ServiceMedical>();
	
	
	private List<Medecin> listeMedecins = new ArrayList<Medecin>();
	
	//Constructeur
	
	
	public Hopital(String nom, int nbServicesMedicauxMax) {
		this.nom = nom;
		this.nbServicesMedicauxMax = nbServicesMedicauxMax;
	}
	
	public void ajouterMedecin(Medecin medecin) {
		this.listeMedecins.add(medecin);
	}
	
	public void ajouterServiceMedical(ServiceMedical serviceMedical) {
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
	
	//toString
	
	@Override
	public String toString() {
		return "Hopital[nom=" + this.nom +
				", nbServicesMedicauxMax=" + this.nbServicesMedicauxMax +
				", listeServicesMedicauxExistants=" + this.listeServicesMedicauxExistants +
				", listeMedecins" + this.listeMedecins + "]";
	}
	
}
