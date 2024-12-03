package r304projet.maladies;

import org.junit.jupiter.api.Test;

import maladies.Maladie;
import maladies.ProphyrieErythropoietiqueCongenitale;

class MaladieTest {

	@Test
	void isNotNull() {
		Maladie m = new ProphyrieErythropoietiqueCongenitale(100);
		assert(m != null);
	}

}
