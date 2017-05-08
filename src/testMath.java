import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by manu on 08/05/2017.
 */
public class testMath {

    static double[] valeur = {-5.7, -5.5, -5.2, -5.0, 5.0, 5.2, 5.5, 5.7};

    public static void main(String[] args) {

        //round
        //Pour les types float et double, cette méthode ajoute 0,5 à l'argument et restitue la plus grande valeur entière (int) inférieure ou égale au résultat.
        for (int i = 0; i < valeur.length; i++) {
            System.out.println("round("+valeur[i]+") = "+Math.round(valeur[i]));
        }

        //rint(double)
        //Cette méthode effectue la même opération mais renvoie un type double.
        for (int i = 0; i < valeur.length; i++) {
            System.out.println("rint("+valeur[i]+") = "+Math.rint(valeur[i]));
        }

        //floor(double)
        //Cette méthode renvoie l'entier le plus proche inférieur ou égal à l'argument.
        for (int i = 0; i < valeur.length; i++) {
            System.out.println("floor("+valeur[i]+") = "+Math.floor(valeur[i]));
        }
        //ceil(double)
        //Cette méthode renvoie l'entier le plus proche supérieur ou égal à l'argument.
        for (int i = 0; i < valeur.length; i++) {
            System.out.println("ceil("+valeur[i]+") = "+Math.ceil(valeur[i]));
        }
        //abs
        //Cette méthode donne la valeur absolue de x (les nombres négatifs sont convertis en leur opposé). La méthode est définie pour les types int, long, float et double.
        System.out.println(" abs(-5.7) = "+Math.abs(-5.7));

        //IEEEremainder(double, double)
        System.out.println("IEEEremainder(10.0, 3.0) = "+Math.IEEEremainder(10.0, 3.0));

        //pow(double, double)
        //Cette méthode élève le premier argument à la puissance indiquée par le second.
        System.out.println(" 5 au cube  = "+Math.pow(5.0, 3.0) );

        //sqrt(double)
        System.out.println(" racine carrée de 25  = "+Math.sqrt(25.0) );

        //exp(double)
        //Cette méthode calcule l'exponentielle de l'argument
        System.out.println(" exponentiel de 5  = "+Math.exp(5.0) );

        //log(double)
        //Cette méthode calcule le logarithme naturel de l'argument
        System.out.println(" logarithme de 5  = "+Math.log(5.0) );

        //random()
        //La méthode random() renvoie un nombre aléatoire compris entre 0.0 et 1.0.
        System.out.println(" un nombre aléatoire  = "+Math.random() );

        //CLasse BigDecimal
        //La classe BigDecimal qui hérite de la classe java.lang.Number permet de réaliser des calculs en virgule flottante avec une précision dans les résultats similaire à celle de l'arithmétique scolaire.
        double valeur_old = 10*0.09;
        System.out.println(valeur_old); //0.8999999999999999
        //Cependant certains calculs, notamment ceux relatifs à des aspects financiers par exemple, requièrent une précision particulière : ces calculs utilisent généralement une précision de deux chiffres.
        //La classe BigDecimal permet de réaliser de tels calculs en permettant d'avoir le contrôle sur la précision (nombre de décimales significatives après la virgule) et la façon dont l'arrondi est réalisé.

        BigDecimal valeur1 = new BigDecimal("10");
        BigDecimal valeur2 = new BigDecimal("0.09");
        BigDecimal valeur3 = valeur1.multiply(valeur2);
        System.out.println(valeur3);
        //Remarque : il est préférable d'utiliser le constructeur attendant en paramètre la valeur sous forme de chaîne de caractères.
        BigDecimal valeur4 = new BigDecimal(2.8);
        BigDecimal valeur5 = new BigDecimal("2.8");

        System.out.println("valeur4="+valeur4);//2.79999999999999982236431605997495353221893310546875
        System.out.println("valeur5="+valeur5);//2.8
        //Aucun constructeur de la classe BigDecimal n'attend en paramètre un objet de type BigDecimal : il est nécessaire d'utiliser le constructeur qui attend en paramètre la valeur sous la forme d'une chaîne de caractères et de lui passer en paramètre le résultat de l'appel de la méthode toString() de l'instance de BigDecimal encapsulant la valeur.
        //La classe BigDecimal propose de nombreuses méthodes pour réaliser des opérations arithmétiques sur la valeur qu'elle encapsule telles que add(), substract(), multiply(), divide(), min(), max(), pow(), remainder(), divideToIntegralValue(), ...

        //Le classe BigDecimal est immuable : la valeur qu'elle encapsule ne peut pas être modifiée. Toutes les méthodes qui effectuent une opération sur la valeur encapsulée retournent un nouvel objet de type BigDecimal qui encapsule le résultat de l'opération.

        //Une erreur courante est d'invoquer la méthode mais de ne pas exploiter le résultat de son exécution.

        BigDecimal valeur6 = new BigDecimal("10.5");
        BigDecimal bonus = new BigDecimal("4.2");

        valeur6.add(bonus);
        System.out.println("valeur=" + valeur6);

        valeur6 = valeur6.add(bonus);
        System.out.println("valeur=" + valeur6);
        //La méthode setScale() permet de spécifier la précision de la valeur et éventuellement le mode d'arrondi à appliquer
        //C'est une bonne pratique de toujours préciser le mode d'arrondi car si un arrondi est nécessaire et que le mode d'arrondi n'est pas précisé alors une exception de type ArithmeticException est levée.
        BigDecimal valeur7 = new BigDecimal(2.8);
        //valeur7.setScale(1);
        System.out.println("valeur7="+valeur7);
        //La classe BigDecimal propose plusieurs modes d'arrondis : ROUND_CEILING, ROUND_DOWN, ROUND_FLOOR, ROUND_HALF_UP, ROUND_HALF_DOWN, ROUND_HALF_EVEN, ROUND_UNNECESSARY et ROUND_UP
        BigDecimal valeur = null;
        String strValeur = null;

        strValeur = "0.222";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_CEILING); //Si valeur positive arrondi directement à la prochaine valeur, après précision
        System.out.println("ROUND_CEILING    "+strValeur+" :  "+valeur.toString());

        strValeur = "-0.222";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_CEILING);//Si valeur négative applique juste la précision
        System.out.println("ROUND_CEILING   "+strValeur+" : "+valeur.toString());

        strValeur = "0.222";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_DOWN);//applique juste la précision
        System.out.println("ROUND_DOWN       "+strValeur+" :  "+valeur.toString());

        strValeur = "0.228";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_DOWN);//applique juste la précision
        System.out.println("ROUND_DOWN       "+strValeur+" :  "+valeur.toString());

        strValeur = "-0.228";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_DOWN);//applique juste la précision
        System.out.println("ROUND_DOWN      "+strValeur+" : "+valeur.toString());

        strValeur = "0.222";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_FLOOR);//Si valeur positive applique juste la précision
        System.out.println("ROUND_FLOOR      "+strValeur+" :  "+valeur.toString());

        strValeur = "-0.222";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_FLOOR);//Si valeur negative arrondi directement à la prochaine valeur, après précision
        System.out.println("ROUND_FLOOR     "+strValeur+" : "+valeur.toString());

        strValeur = "0.222";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_HALF_UP);//C'est l'arrondi qu'on utilise en classe, au delà de 0.5 (superieur ou égal) on arrondi sinon on laisse
        System.out.println("ROUND_HALF_UP    "+strValeur+" :  "+valeur.toString());

        strValeur = "0.225";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_HALF_UP);//C'est l'arrondi qu'on utilise en classe, au delà de 0.5 (superieur ou égal) on arrondi sinon on laisse
        System.out.println("ROUND_HALF_UP    "+strValeur+" :  "+valeur.toString());

        strValeur = "0.225";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_HALF_DOWN);//C'est l'arrondi qu'on utilise en classe, au delà de 0.5 (strictement superieur) on arrondi sinon on laisse
        System.out.println("ROUND_HALF_DOWN  "+strValeur+" :  "+valeur.toString());

        strValeur = "0.226";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_HALF_DOWN);//C'est l'arrondi qu'on utilise en classe, au delà de 0.5 (strictement superieur) on arrondi sinon on laisse
        System.out.println("ROUND_HALF_DOWN  "+strValeur+" :  "+valeur.toString());

        strValeur = "0.215";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_HALF_EVEN);//Notez qu'il s'agit du mode arrondir qui minimise les erreurs cumulatives lorsqu'elles sont appliquées à plusieurs reprises sur une suite de calculs.C'est un arrondi vers le voisin le plus proche. Mais s'ils sont équidistants deux cas se produisent: soit la valeur à gauche est impaire --> on se comporte comme en ROUND_HALF_UP, soit elle est paire et on se comporte en ROUND_HALF_DOWN
        System.out.println("ROUND_HALF_EVEN  "+strValeur+" :  "+valeur.toString());

        strValeur = "0.225";

        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_HALF_EVEN);//Notez qu'il s'agit du mode arrondir qui minimise les erreurs cumulatives lorsqu'elles sont appliquées à plusieurs reprises sur une suite de calculs.C'est un arrondi vers le voisin le plus proche. Mais s'ils sont équidistants deux cas se produisent: soit la valeur à gauche est impaire --> on se comporte comme en ROUND_HALF_UP, soit elle est paire et on se comporte en ROUND_HALF_DOWN
        System.out.println("ROUND_HALF_EVEN  "+strValeur+" :  "+valeur.toString());

        strValeur = "0.222";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_UP);//arrondi directement à la prochaine valeur, après précision
        System.out.println("ROUND_UP         "+strValeur+" :  "+valeur.toString());

        strValeur = "0.226";
        valeur = (new BigDecimal(strValeur)).setScale(2, BigDecimal.ROUND_UP);//arrondi directement à la prochaine valeur, après précision
        System.out.println("ROUND_UP         "+strValeur+" :  "+valeur.toString());

        //Le mode d'arrondi doit aussi être précisé lors de l'utilisation de la méthode divide().

        BigDecimal valeurX = new BigDecimal("1");
        System.out.println(valeurX.divide(new BigDecimal("3"),2, BigDecimal.ROUND_HALF_UP));

        //La précision et le mode d'arrondi doivent être choisis avec attention parce que leur choix peut avoir de grandes conséquences sur les résultats de calculs notamment si le résultat final est constitué de multiples opérations. Dans ce cas, il est préférable de garder la plus grande précision durant les calculs et de n'effectuer l'arrondi qu'à la fin.
        //Il faut être vigilent lors de la comparaison entre deux objets de type BigDecimal. La méthode equals() compare les valeurs mais en tenant compte de la précision. Ainsi, il est préférable d'utiliser la méthode compareTo() qui n'effectue la comparaison que sur la valeur.

        BigDecimal valeur1X = new BigDecimal("10.00");
        BigDecimal valeur2X = new BigDecimal("10.0");

        System.out.println("valeur1.equals(valeur2) = "+valeur1X.equals(valeur2X));
        System.out.println("valeur1.compareTo(valeur2) = "+(valeur1X.compareTo(valeur2X)==0));

        //La méthode compareTo() renvoie 0 si les deux valeurs sont égales, renvoie -1 si la valeur de l'objet fourni en paramètre est plus petite et renvoie 1 si la valeur de l'objet fourni en paramètre est plus grande.

        //Il est possible de passer en paramètre de la méthode format() de la classe NumberFormat un objet de type BigDecimal : attention dans ce cas, le nombre de décimales est limité à 16.
        BigDecimal payment = new BigDecimal("1234.567");
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String s = n.format(payment);
        System.out.println(s);
    }
}
