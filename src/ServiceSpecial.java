/**
 * Created by eve on 02/05/2017.
 */
public interface ServiceSpecial extends Service, Groupe
{
	default void afficherNom(){
		System.out.println("Ici c'est le service spécial");
	}
}
