import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;



/**
 * Created by eve on 04/05/2017.
 */
public class test10
{
	public static void main(String[] args)
	{
		Hashtable h = new Hashtable();
		h.put("nene", "bijoux");
		h.put(new Double(23.89), "cailloux");
		h.put("viiv", "bijoux");
		h.put("jour", new Date());

		Vector v = new Vector();
		v.add("ffdd");
		v.add("chanine 5");
		v.add("sodff");

		System.out.println("Contenu du vector");

		for(Enumeration e = v.elements(); e.hasMoreElements(); ){
			System.out.println(e.nextElement());
		}


		System.out.println("\nContenu du hashTable");

		for(Enumeration e = h.elements(); e.hasMoreElements(); ){
			System.out.println(e.nextElement());
		}

		//Zip

		try
		{
			ZipFile test = new ZipFile(new File("./tp1-eve.zip"));
		}
		catch (ZipException e){
				e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("Le fichier n'a pas été trouvé");
			e.printStackTrace();
		}

		listerZip("./tp1-eve.zip");

		//ZipOutputStream
	}

	public static void listerZip(String nomFichier){
			ZipFile zipFile;
		try
		{
			zipFile = new ZipFile(nomFichier);
			Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>)zipFile.entries(); //Obtenir une énumération des entrées de l'archive sous la forme d'objets de type ZipEntry
			while(entries.hasMoreElements()){
				ZipEntry zipEntry = entries.nextElement();
				String name = zipEntry.getName();
				Date dateModification = new Date(zipEntry.getTime());
				int methodeCompression = zipEntry.getMethod();
				System.out.println("Le nom de l'entrée est "+name);
				System.out.println("La date de modificatione st "+dateModification);
				System.out.println("la méthode est "+methodeCompression);
			}
			zipFile.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}


}
