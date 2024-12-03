package serviceMedical;

public class CentreQuarantaine extends ServiceMedical {
	public int isolation;
	
	public void reviserBudget() {		
		int cout = (6 - isolation)/6;
		cout -= nbCreatures/nbCreaturesMax;

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
