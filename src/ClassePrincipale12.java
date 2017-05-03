import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MesClassesInternes.ClassePrincipale8;



/**
 * Created by eve on 02/05/2017.
 */
public class ClassePrincipale12 {

	public static void main(String args[]) {
		ClassePrincipale12 cp = new ClassePrincipale12();
		cp.maMethode();

	}

	public void maMethode() {
		 int varLocale = 3;

		class ClasseInterne {
			public void affiche() {
				System.out.println("varLocale = " + varLocale);
			}
		}

		ClasseInterne ci = new ClasseInterne();
		ci.affiche();
	}

/*	public void init() {
		boutonQuitter.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			}
		);
	}*/
}