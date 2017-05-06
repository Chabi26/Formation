import java.io.*;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;



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

		compresser("atoto.zip", "Suite2.txt");

		decompresser("./aziper.zip", "./monzip2");
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

		public static void compresser(String nomArchive, String nomFichier){

		//La classe ZipOutputStream est un flux qui permet l'écriture de données dans l'archive.
			try
			{
				ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(nomArchive));
				//Modifier la méthode de compression utilisée par défaut. Les valeurs possibles sont STORED (aucune compression) ou DEFLATED (avec compression)
				zip.setMethod(ZipOutputStream.DEFLATED);
				//Modifier le taux de compression : les valeurs entières possibles vont de 0 à 9 où 9 correspond au taux de compression le plus élevé. Des constantes sont définies dans la classe Deflater : Deflater.BEST_COMPRESSION, Deflater.DEFAULT_COMPRESSION, Deflater.BEST_SPEED, Deflater.NO_COMPRESSION
				zip.setLevel(Deflater.BEST_COMPRESSION);

				//lecture du fichier
				File fichier = new File(nomFichier);
				FileInputStream fis = new FileInputStream(fichier);
				byte[] bytes = new byte[fis.available()];
				fis.read(bytes);

				// ajout d'une nouvelle entrée dans l'archive contenant le fichier
				ZipEntry entry = new ZipEntry(nomFichier);
				entry.setTime(fichier.lastModified());
				zip.putNextEntry(entry);
				zip.write(bytes);

				// fermeture des flux
				zip.closeEntry();
				fis.close();
				zip.close();
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		public static void decompresser(String nomArchive, String chemin){

            try {
                ZipFile zipFile = new ZipFile(nomArchive);
                Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zipFile.entries();
                ZipEntry entry = null;
                File fichier = null;
                File sousRep = null;
                while(entries.hasMoreElements()){
                    entry = entries.nextElement();
                    if(!entry.isDirectory()){
                        System.out.println("Extraction du fichier "+entry.getName());
                        fichier = new File(chemin + File.separatorChar + entry.getName());
                        sousRep = fichier.getParentFile();

                        if(sousRep != null){
                            if(!sousRep.exists()){
                                sousRep.mkdirs();
                            }
                        }

                        int i = 0;
                        byte[] bytes = new byte[1024];
                        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fichier));
                        BufferedInputStream in = new BufferedInputStream(zipFile.getInputStream(entry));

                        while((i = in.read(bytes)) != -1){
                            out.write(bytes, 0, i);
                        }
                        in.close();
                        out.flush();
                        out.close();

                    }

                }
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
