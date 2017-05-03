import java.util.Date;



/**
 * Created by eve on 03/05/2017.
 */
public class MettreMaj {

	static final String lMaj = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String lMin = "abcdefghijklmnopqrstuvwxyz";

	public static void main(java.lang.String[] args) {
		System.out.println(MetMaj("chaine avec MAJ et des min"));
		int valeur = Integer.valueOf("999").intValue();
		System.out.println(Float.isNaN(Float.valueOf("2.4").floatValue()));
		System.out.println(Double.isInfinite(Double.valueOf("2.4").doubleValue()));

		System.out.printf("%d \n"	                  ,1333);
		System.out.printf("%4d \n"	                  ,1333);
		System.out.printf("%04d \n"	                  ,1333);
		System.out.printf("%f \n"	                  ,3.14116);
		System.out.printf("%.2f \n"	                  ,3.14116);
		System.out.printf("%s \n"	                  ,"chaine avec MAJ et des min");
		System.out.printf("%10s \n"	                  ,"chaine avec MAJ et des min");
		System.out.printf("%-10s \n"	          ,"chaine avec MAJ et des min");
		System.out.printf("%tD \n"                    , new Date());
		System.out.printf("%tF \n"                    , new Date());
		System.out.printf("%1$te %1$tb %1$ty \n"       , new Date());
		System.out.printf("%1$tA %1$te %1$tB %1$tY \n", new Date());
		System.out.printf("%1$tr \n"                  , new Date());
	}

	public static String MetMaj(String s) {
		StringBuffer sb = new StringBuffer(s);

		for ( int i = 0; i < sb.length(); i++) {
			int index = lMin.indexOf(sb.charAt(i));
			System.out.println("Index : "+index);
			//if (index <=0 ) sb.setCharAt(i,lMaj.charAt(index));
		}
		return sb.toString();
	}
}
