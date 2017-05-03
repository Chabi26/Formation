package MesClassesInternes;

/**
 * Created by eve on 02/05/2017.
 */
public class ClassePrincipale8
{
	public class ClasseInterne{
		//static  int var = 3; pas de static dans une classe interne
	}

	private class ClasseInterne2{

	}

	public static void main(String[] args)
	{
		ClassePrincipale8 cp = new ClassePrincipale8();
		ClassePrincipale8.ClasseInterne ci = cp. new ClasseInterne();
		System.out.println(ci.getClass().getName());
	}
}
