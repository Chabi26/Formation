import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;

import javafx.scene.input.DataFormat;



/**
 * Created by eve on 04/05/2017.
 */
public class test9
{
	public static void main(String[] args)
	{
		StringTokenizer tokenizer = new StringTokenizer("chaine1,chaine2,chaine3,chaine4",",");
		while(tokenizer.hasMoreTokens()){
			System.out.println(tokenizer.nextToken());

		}

		Random random = new Random();
		System.out.println(Integer.MIN_VALUE); //-2147483648
		System.out.println(Integer.MAX_VALUE); //2147483647
		System.out.println(Long.MIN_VALUE); //-9223372036854775808
		System.out.println(Long.MAX_VALUE); //9223372036854775807
		int a = random.nextInt()%100;
		long l = random.nextLong();
		double d = random.nextDouble();
		System.out.println("le nombre a est "+a);
		System.out.println("le nombre decimal  est "+d);

		Date maintenant = new Date();
		System.out.println(DateFormat.getInstance().format(maintenant));

		//Il faut utiliser Calendar pour les manipulation, pleins de deprecated dans Date

		Calendar c = Calendar.getInstance();
		if(c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
		System.out.println("Nous sommes lundi");
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY)
			System.out.println(" nous sommes mardi ");
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY)
			System.out.println(" nous sommes mercredi ");
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY)
			System.out.println(" nous sommes jeudi ");
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
			System.out.println(" nous sommes vendredi ");
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
			System.out.println(" nous sommes samedi ");
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			System.out.println(" nous sommes dimanche ");


		//La classe SimpleDateFormat est la seule implémentation de la classe DateFormat fournie en standard.
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
		final String dateStr = sdf.format(new Date());
		System.out.println("La date formattée est "+dateStr);
		final Date date;
		try
		{
			date = sdf.parse(dateStr);
			System.out.println("La date parsée est "+date);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}


		//Vector à partir de java 1.2 tu vas utiliser les collections
		Vector v = new Vector();
		v.addElement(new Integer(23));
		v.addElement(new Float(3.12));
		v.insertElementAt("chaine ", 1);
		System.out.println("le vecteur contient "+v.size()+" élements");

		Integer retrouve = (Integer)v.elementAt(0);
		System.out.println("le premier element est "+retrouve);

		for (int i = 0; i<v.size(); i++ ){
			System.out.println(v.elementAt(i));
		}

		//HashTable à partir de java 1.2 tu vas utiliser les collections

		Hashtable dico = new Hashtable();
		dico.put("toto", "filou");
		dico.put(new Integer(2), "dd");
		dico.put(new Integer(2),"deuxième");

		System.out.println("Dans le hashtable "+dico.get("toto"));




	}
}
