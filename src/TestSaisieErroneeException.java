/**
 * Created by manu on 08/05/2017.
 */
public class TestSaisieErroneeException {

    public static void controle(String chaine) throws SaisieErroneeException {
        if (chaine.equals("") == true) {
            throw new SaisieErroneeException("La chaîne est vide");
        }
    }

    public static void main(String[] args) {
        String chaine1 = "Bonjour";
        String chaine2 = "";

        try {
            controle(chaine1);
        } catch (SaisieErroneeException e) {
            e.printStackTrace();
        }

        try {
            controle(chaine2);
        } catch (SaisieErroneeException e) {
            e.printStackTrace();
        }

    }
}
