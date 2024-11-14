package serviceMedical;

public class Crypte extends ServiceMedical {
	public int niveauVentilation;
	public int temperature;
	
	
	
	public void reviserBudget() {
		int cout = (6 - niveauVentilation)/6;
		if(temperature < 20) {
			cout -= (18 - temperature)/18;
		}else {
			cout -= (38 - temperature)/18;
		}
		
		if(cout == 0.0) {
			budget="inexistant";
		}else if(cout < 0.16) {
			budget="insuffisant";
		}else if(cout < 0.33) {
			budget="faible";
		}else if(cout < 0.5) {
			budget="médiocre";
		}else if(cout < 0.66) {
			budget="bien";
		}else if(cout < 0.83) {
			budget="très bien";
		}else {
			budget="excellent";
		}
	}
}
