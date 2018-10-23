/**
 * 
 */
package Liga;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author iam26509397
 *
 */
public class Prueba {
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
	
	//modifica un archivo para saber cuanto pesaria un partido con el limite
	public static long weightMatch() throws FileNotFoundException, IOException {
		try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
    	//try (DataOutputStream out = new DataOutputStream(new FileOutputStream(pathArch))) {
    		
			Partido partido = new Partido(200, 200, "卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉", 11, 11, 2000, 1, 2); 
    		//Partido partido = new Partido(200, 200, "IGNASI", 11011999, 1, 2); 

			raf.writeInt(partido.getScoreT1());
			raf.writeInt(partido.getScoreT2());
			raf.writeUTF(partido.getReferee());
			raf.writeInt(partido.getDay());
			raf.writeInt(partido.getMonth());
			raf.writeInt(partido.getYear());
			raf.writeInt(partido.geteLocal());
			raf.writeInt(partido.geteVisit());
			
    	} catch (Exception e) {
			System.out.println(e);
		}
		//System.out.println(FILE.length());
		return FILE.length() + 2;
	}
	public static void copiaSeguridad() throws IOException {
		JSONParser parser = new JSONParser();
		String directory = "";
        try {
 
            Object obj = parser.parse(new FileReader("./data/data.json"));
 
            JSONObject jsonObject = (JSONObject) obj;
            directory = (String) jsonObject.get("patrocinador");
            directory += (String) jsonObject.get("temporada");
        } catch (Exception e) {
        	System.out.println("Error:" + e);
        }
		new File("./copiaSeguridad/"+directory).mkdir();
		File sourceLocation= new File("./data");
        File targetLocation = new File("./copiaSeguridad/"+directory);
        FileUtils.copyDirectory(sourceLocation, targetLocation);

	}
	public static void borrarArchivo() throws IOException {
		//BufferedWritter
		/**BufferedWriter bw = new BufferedWriter(new FileWriter("./data/liga.bin"));
		bw.write("");
		bw.close();*/
		//RandomAccessFile
		File temp = new File("./data/liga.bin");
        if (temp.exists()) {
        	RandomAccessFile raf = new RandomAccessFile(temp, "rw");
        	raf.setLength(0);
        }
	}
}
