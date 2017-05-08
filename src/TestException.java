/**
 * Created by manu on 08/05/2017.
 */
public class TestException {

    public static void main(String[] args) {
        int i = 3;
        int j = 0;
        try {
            System.out.println("résultat = " + (i / j));
        } catch (ArithmeticException e) {
            System.out.println("Lecture du message avec getMessage");
            System.out.println(e.getMessage());
            System.out.println("Lecture du message avec toString");
            System.out.println(e.toString());
            System.out.println("Lecture du message avec printStackTrace");
            e.printStackTrace();
        }

        //Les classes Exception, RunTimeException et Error

        //Ces trois classes descendent de Throwable : en fait, toutes les exceptions dérivent de la classe Throwable.

        //La classe Error représente une erreur grave intervenue dans la machine virtuelle Java ou dans un sous système Java. L'application Java s'arrête instantanément dès l'apparition d'une exception de la classe Error.
        //La classe Exception représente des erreurs moins graves. Les exceptions héritant de la classe RuntimeException n'ont pas besoin d'être détectées impérativement par des blocs try/catch.

        //Pour générer une exception, il suffit d'utiliser le mot clé throw, suivi d'un objet dont la classe dérive de Throwable. Si l'on veut générer une exception dans une méthode avec throw, il faut l'indiquer dans la déclaration de la méthode, en utilisant le mot clé throws.

        //En cas de nécessité, on peut créer ses propres exceptions. Elles descendent des classes Exception ou RunTimeException mais pas de la classe Error. Il est préférable (par convention) d'inclure le mot « Exception » dans le nom de la nouvelle classe.
        System.out.println("Après exception");
    }
}
