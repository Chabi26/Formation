package MesClassesInternes;

/**
 * Created by eve on 02/05/2017.
 */
public interface Service
{
	public default void afficherNom(){
		System.out.println("Nom du service : inconnu");
	}

	//void tester();
}
