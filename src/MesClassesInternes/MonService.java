package MesClassesInternes;

/**
 * Created by eve on 02/05/2017.
 */
//public class MesClassesInternes.MonService implements MesClassesInternes.Service, MesClassesInternes.Groupe, MesClassesInternes.ServiceEtendu
public class MonService implements ServiceEtendu
{
	//Dans un cas où plusieurs interfaces ont la même méthodes par defaut, il faut forcément explicitement implémenter la méthode ici

	/*@Override
	public void afficherNom(){
		System.out.println("C'est le manou");
	}*/

	public void afficherNom(){
		System.out.println("C'est le manou");
	}

	public void bingo(){
		System.out.println("le bingo");
	}
	/*@Override
	public void tester()
	{

	}*/
}
