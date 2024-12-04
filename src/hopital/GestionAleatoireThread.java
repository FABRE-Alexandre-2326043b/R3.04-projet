package hopital;

import java.util.Random;

public class GestionAleatoireThread extends Thread {
    private Hopital hopital = Hopital.getInstance();

    /**
     * Permet la gestion des évènements aléatoires
     * */
    private Random random = new Random ();

    @Override
    public void run () {
        while (true) {

        }
    }
}
