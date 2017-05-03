package MesClassesInternes;

/**
 * Created by eve on 02/05/2017.
 */
public class ClassePrincipale6 {
	public static void main(String[] args)
	{
		ClassePrincipale8 cp = new ClassePrincipale8();
		ClassePrincipale8.ClasseInterne ci = cp. new ClasseInterne();
		System.out.println(ci.getClass().getName());
	}
	class ClasseInterne1 {

		class ClasseInterne2 {
			class ClasseInterne3 {

			}
		}
	}



}
