/**
 * 
 */
package Liga;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author iam26509397
 *
 */
public class prueba extends Properties {
	private final static File FILE = new File("./data/partido.bin");
	//static String pathArch = "./data/partido.bin";
	public static void generarProperties() {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty("team", "equipo");
			prop.setProperty("referee", "arbitro");
			prop.setProperty("date", "fecha");

			// save properties to project root folder
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	public static long weightMatch() throws FileNotFoundException, IOException {
		try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
    	//try (DataOutputStream out = new DataOutputStream(new FileOutputStream(pathArch))) {
    		
			Partido partido = new Partido(200, 200, "卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉", 11011999, 1, 2); 
    		//Partido partido = new Partido(200, 200, "IGNASI", 11011999, 1, 2); 

			raf.writeInt(partido.getScoreT1());
			raf.writeInt(partido.getScoreT2());
			raf.writeUTF(partido.getReferee());
			raf.writeInt(partido.getDate());
			raf.writeInt(partido.geteLocal());
			raf.writeInt(partido.geteVisit());
			
    	} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(FILE.length());
		return FILE.length();
	}
	
}
