import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by manu on 06/05/2017.
 */
public class testPattern {

    private  static java.util.regex.Pattern motif = null;
    private static Matcher matcher = null;
    private static Matcher matcher2 = null;
    public static void main(String[] args) {
        motif = java.util.regex.Pattern.compile("liste[0-9]", java.util.regex.Pattern.CASE_INSENSITIVE);

        if(java.util.regex.Pattern.matches("liste[0-9]", "liste2")){
            System.out.println("liste22 ok");
        }
        else{
            System.out.println("liste22 ko");
        }

        matcher = motif.matcher("LISTE10");

        if(matcher.matches()){
            System.out.println("liste1 est ok");
        }
        else{
            System.out.println("liste1 est ko");
        }

        //La méthode lookingAt() tente de rechercher le motif dans la chaîne à traiter. Mais le debut doit bien être cohérent

        if(matcher.lookingAt()){
            System.out.println("liste1 lookingAt est ok");
        }
        else{
            System.out.println("liste1 lookingAt est ko");
        }

        //La méthode find() permet d'obtenir des informations sur chaque occurrence où le motif est trouvé dans la chaîne à traiter.

        matcher2 = motif.matcher("zzliste1zzzzliste4zz");

        int i = 0;
        while(matcher2.find()){
            System.out.println("position debut "+matcher2.start());
            System.out.println("position fin "+matcher2.end());
            i++;
        }
        System.out.println("le nombre d'occurenec est "+i);


        //La classe Matcher propose aussi les méthodes replaceFirst() et replaceAll() pour facilement remplacer la première ou toutes les occurrences du motif trouvé par une chaîne de caractères.

        System.out.println("la chaine remplacee est "+matcher2.replaceFirst("bhoi"));

        //Formatter

        Formatter formatter = new Formatter();
        formatter.format("%06d \n", 13);
        String resultat = formatter.toString();
        System.out.println("le resultat formatté est "+resultat);

        //Scanner

        //La classe Scanner
        //A partir de Java 5 	Cette classe facilite la lecture dans un flux. Elle est particulièrement utile pour réaliser une lecture de données à partir du clavier dans une application de type console.

        //La méthode next() bloque l'exécution jusqu'à la lecture de données et les renvoie sous la forme d'une chaîne de caractères.

        Scanner scanner = new Scanner(System.in);
        System.out.print("entrez la donnée :");
        String chaine = scanner.next();
        //scanner.close();

        System.out.print("entrez la donnée :");
        try{
            int numb = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("la donnée saisie est incohérence");
        }
        finally {
            scanner.close();
        }



    }
}
