package DanielAmarilloMoralesM6UF1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Prueba {
	private final static File FILE = new File("./data/partido.bin");
	private final static File FILE2 = new File("./data/team.bin");
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
		public static long weightTeam() throws FileNotFoundException, IOException {
			try (RandomAccessFile raf = new RandomAccessFile(FILE2, "rw")){	
				String teamDes = "卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉科特卡拉"; 
				
				raf.writeUTF(teamDes);
				
	    	} catch (Exception e) {
				System.out.println(e);
			}
			return FILE2.length() + 2;
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
			new File("./data/backup/"+directory).mkdir();
			File sourceLocation= new File("./data/liga");
	        File targetLocation = new File("./data/backup/"+directory);
	        FileUtils.copyDirectory(sourceLocation, targetLocation);

		}
		public static void borrarArchivo() throws IOException {
			//BufferedWritter
			/**BufferedWriter bw = new BufferedWriter(new FileWriter("./data/liga/liga.bin"));
			bw.write("");
			bw.close();*/
			//RandomAccessFile
			File temp = new File("./data/liga/liga.bin");
	        if (temp.exists()) {
	        	RandomAccessFile raf = new RandomAccessFile(temp, "rw");
	        	raf.setLength(0);
	        }
		}
}
