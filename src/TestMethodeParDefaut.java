/**
 * Created by eve on 02/05/2017.
 */
public class TestMethodeParDefaut
{
	public static void main(String[] args)
	{
		//Il est aussi possible de créer directement une instance d'une interface si toutes ses méthodes sont des méthodes par défaut.
		//Service service = new Service(){};
		/*Groupe service = new MonService();
		service.afficherNom();*/

		Service service = new ServiceComptable();
		service.afficherNom();

		ServiceComptable ff = new ServiceComptable();
		ff.bingo();
		String name = "Emmanuel";
		String surname = "vedogbeton";
		System.out.println(name.replace('m','u'));

		System.out.println(surname.indexOf(name.charAt(0)));
	}
}
