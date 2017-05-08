import java.io.*;

/**
 * Created by manu on 08/05/2017.
 */
public class TestExceptionChainee {
    /**
     * Il est fréquent durant le traitement d'une exception de lever une autre exception. Pour ne pas perdre la trace de l'exception d'origine, Java propose le chaînage d'exceptions pour conserver l'empilement des exceptions levées durant les traitements.

     Il y a deux façons de chaîner deux exceptions :

     Utiliser la surcharge du constructeur de Throwable qui attend un objet Throwable en paramètre
     Utiliser la méthode initCause() d'une instance de Throwable

     */

    /**
     * 7.6. L'utilisation des exceptions
     * <p>
     * Il est préférable d'utiliser les exceptions fournies par Java lorsqu'une de ces exceptions répond au besoin plutôt que de définir sa propre exception.
     * <p>
     * Il existe trois types d'exceptions :
     * <p>
     * Error : ces exceptions concernent des problèmes liés à l'environnement. Elles héritent de la classe Error (exemple : OutOfMemoryError)
     * RuntimeException : ces exceptions concernent des erreurs de programmation qui peuvent survenir à de nombreux endroits dans le code (exemple : NullPointerException). Elles héritent de la classe RuntimeException
     * Checked exception : ces exceptions doivent être traitées ou propagées. Toutes les exceptions qui n'appartiennent pas aux catégories précédentes sont de ce type
     * <p>
     * Les exceptions de type Error et RuntimeException sont dites unchecked exceptions car les méthodes n'ont pas d'obligation à les traiter ou à déclarer leur propagation explicitement. Ceci se justifie par le fait que leur levée n'est pas facilement prédictible.
     * <p>
     * Il n'est pas recommandé de créer ses propres exceptions en dérivant d'une exception de type unchecked (classe de type RuntimeException). Même si cela peut sembler plus facile puisqu'il n'est pas obligatoire de déclarer leur propagation, cela peut engendrer certaines difficultés, notamment :
     * <p>
     * oublier de traiter cette exception
     * ne pas savoir que cette exception peut être levée par une méthode.
     * <p>
     * Cependant, l'utilisation d'exceptions de type unchecked se répend de plus en plus notamment depuis la diffusion de la plate-forme .Net qui ne propose que ce type d'exceptions.
     */

    public static void main(String[] args) {

        try {
            String donnees = lireFichier();
            System.out.println("donnees=" + donnees);
        } catch (SaisieErroneeException e) {
            e.printStackTrace();
        }
    }

    public static String lireFichier() throws SaisieErroneeException {
        File fichier = new File("./Suite2.txt");
        FileReader reader = null;
        StringBuffer donnees = new StringBuffer();
        BufferedReader bufferedReader = null;

        try {
            reader = new FileReader(fichier);
            bufferedReader = new BufferedReader(reader); //tu peux l'utiliser à la place de reader
            char[] buffer = new char[2048];
            int len;
            while ((len = reader.read(buffer)) > 0) {
                donnees.append(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            //La méthode getCause() héritée de Throwable permet d'obtenir l'exception originale.
            System.out.println(e.getCause().getMessage());
        } catch (IOException e) {
            new SaisieErroneeException("Impossible de lire le fichier", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return donnees.toString();
    }
}
