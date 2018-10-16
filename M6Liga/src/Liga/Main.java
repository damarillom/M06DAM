/**
 * 
 */
package Liga;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author iam26509397
 *
 */
public class Main extends Properties {
	/**
	 * @param args
	 * @throws IOException 
	 */
	private final static File FILE = new File("./data/liga.bin");
	static String pathProp;
	public static void main(String[] args) throws IOException {
		
		String lanSO = Locale.getDefault().toString();
		if (lanSO.equals("es_ES")) {
			pathProp = "./ES.properties";
		} else if (lanSO.equals("en_US")) {
			pathProp = "./EN.properties";
		} else {
			pathProp = "./EN.properties";
		}
		//JSONParser parser = new JSONParser();
		
		menu();
	}
	
	public static void menu() throws IOException {
		//JSONParser parser = new JSONParser();
		int maxScore = 0;
		int minScore = 0;
		int refereeLen = 0;
		int nEquipos = 0;
		JSONParser parser = new JSONParser();
		 
        try {
 
            Object obj = parser.parse(new FileReader("./data/data.json"));
 
            JSONObject jsonObject = (JSONObject) obj;
            nEquipos = Integer.parseInt((String) jsonObject.get("nEquipos"));
            maxScore = Integer.parseInt((String) jsonObject.get("maxScore"));
            minScore = Integer.parseInt((String) jsonObject.get("minScore"));
            refereeLen = Integer.parseInt((String) jsonObject.get("refereeLen"));
        } catch (Exception e) {
        	System.out.println("Error:" + e);
        }
		Properties prop = new Properties();
	    InputStream is = null;
	    final String pathArch = "./data/liga.bin";
	    //String pathProp = "./ES.properties";
	    is = new FileInputStream(pathProp);
		prop.load(is);
		//Generamos el archivo properties
		//prueba.generarProperties();
		
		//leer properties
		/**Properties prop = new Properties();
		InputStream is = null;
		
		try {
			is = new FileInputStream("C:/Users/danie/Desktop/M06/M06DAM/M6Liga/config.properties");
			prop.load(is);
		} catch(IOException e) {
			System.out.println(e.toString());
		}
		System.out.println(prop.getProperty("date"));*/
		
		//System.out.println("Working Directory = " + System.getProperty("user.dir"));
		// Local variable
	    int swValue;
	    String path;
	    //path = Keyin.inString("Inserte la ruta del archivo o directorio: ");
	    path = "";
	    File file = new File(path);
	    // Display menu graphics
	    System.out.println("=====================================================================");
	    System.out.println("|   MENU SELECTION DEMO    						");
	    System.out.println("=====================================================================");
	    System.out.println("| "+prop.getProperty("options")+":                 							");
	    System.out.println("|        1. "+prop.getProperty("lan")+"       				");
	    System.out.println("|        2. "+prop.getProperty("see")+"  						");
	    System.out.println("|        3. "+prop.getProperty("intro")+"			        ");
	    System.out.println("|        4. "+prop.getProperty("reboot")+"					        ");
	    System.out.println("=====================================================================");
	    swValue = Keyin.inInt(" Select option: ");
	    // Switch construct
	    switch (swValue) {
	    case 1:
	    	int idioma;
	    	System.out.println("| Options:         	 ");
		    System.out.println("|        1. English  ");
		    System.out.println("|        2. Spanish  ");
		    idioma = Keyin.inInt(" Select option:    ");
		    /**Properties prop = new Properties();
		    InputStream is = null;
		    String pathProp = "";*/
		    if (idioma == 1) {
		    	pathProp = "./EN.properties";
		    } else if (idioma == 2) {
		    	pathProp = "./ES.properties";
		    } else {
		    	System.out.println("Invalid selection");
		    }
	    	System.out.println(pathProp);
	    	is = new FileInputStream(pathProp);
			prop.load(is);
	    	//System.out.println(prop.getProperty("team"));
	      	break;
	    case 2:
	    	long bytePart = prueba.weightMatch();
	    	long jump2 = 0;
	    	try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
	    		System.out.printf("%-10s%-40s%-10s%-10s%-10s\n","Resultado","Arbitro","fecha", "Local", "Visitante");
	    		for (int i = 0; i < nEquipos; i++) {
		    		for (int j = 0; j < nEquipos; j++) {
		    			raf.seek(jump2);
		    			/**System.out.println("ScoreT1:" + raf.readInt());
		    			System.out.println("ScoreT2:" + raf.readInt());
		    			System.out.println("referee:" + raf.readUTF());	
		    			System.out.println("fecha:" + raf.readInt());
		    			System.out.println("T1:" + raf.readInt());
		    			System.out.println("T2:" + raf.readInt() + "\n\n");*/
		    			
		    			System.out.printf("%-10s%-40s%-10s%-10s%-10s\n",raf.readInt() +"-"+ raf.readInt(),""+ raf.readUTF(),""+ raf.readInt(), ""+raf.readInt(), ""+raf.readInt());
		    			
		    			jump2 += bytePart;
		    				
		    		}
	    		}
	    	}
	      	break;
	    case 3:
	    	long bitePart = prueba.weightMatch();
	    	long jump = 0;
	    	try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
	    		for (int i = 0; i < nEquipos; i++) {
		    		for (int j = 0; j < nEquipos; j++) {
		    			raf.seek(jump);
		    			int scoreT1 = raf.readInt();
		   				int scoreT2 = raf.readInt();
		   				String referee = raf.readUTF();
	    				int date = raf.readInt();
	    				int eLocal = raf.readInt();
		   				int eVisit = raf.readInt();
		   				if (scoreT1 == -1) {
		   					System.out.println(eLocal);
		   					System.out.println(eVisit);
		    				if (i != j) {
		   						scoreT1 = Keyin.inInt(" Score team Local: ");
		   						scoreT2 = Keyin.inInt(" Score visit team: ");
		   						referee = Keyin.inString(" Introduce Referee: ");
		    					date = Keyin.inInt(" date (format DDMMYYYY): ");
		    					raf.seek(jump);
		    					try  {
		    						if (scoreT1 <= maxScore && scoreT1 > minScore && scoreT2 <= maxScore && scoreT2 > minScore && referee.length() <= refereeLen) {
		   								raf.writeInt(scoreT1);
		   								raf.writeInt(scoreT2);
		   								raf.writeUTF(referee);
		   								raf.writeInt(date);
		    							raf.writeInt(i);
		    							raf.writeInt(j);
		    						}
		    					
		    					} catch (Exception e) {
									System.out.println("ERROR: " + e);
								}
		    						
		   						i = nEquipos;
		   						j = nEquipos;
		   					} else {
		    					raf.writeInt(-2);
    							raf.writeInt(-2);
    							raf.writeUTF("NO");
    							raf.writeInt(99999999);
    							raf.writeInt(i);
    							raf.writeInt(j);
    							
		   					}
		   				}
		   				jump += bitePart;
		    		}
	    		}
	    	}
		  	break;
	    case 4:
	    	try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
	    		long jumpC = 0;
	    		long byteToC = prueba.weightMatch();
	    		for (int i = 0; i < nEquipos; i++) {
	    			for (int j = 0; j < nEquipos; j++) { 
	    				raf.seek(jumpC);
	    				Partido partido = new Partido(i, j);
	    				raf.writeInt(partido.getScoreT1());
	    				raf.writeInt(partido.getScoreT2());
	    				raf.writeUTF(partido.getReferee());
	    				raf.writeInt(partido.getDate());
	    				raf.writeInt(partido.geteLocal());
	    				raf.writeInt(partido.geteVisit());
	    				
	    				System.out.println(partido.getDate()+"-"+partido.geteLocal() +"-"+partido.geteVisit() );
	    				jumpC += byteToC;
	            	}               
	        	}
	    		
	    		String patrocinador = Keyin.inString(" Insert patrocinador: ");
	    		String temporada = Keyin.inString(" Insert Temporada: ");
	    		raf.writeUTF(patrocinador);
	    		raf.writeUTF(temporada);	
	    	} catch (Exception e) {
				System.out.println(e);
			}
		    break;
	    default:
	    	System.out.println("Invalid selection");
	    	break; 
	    }
	    //System.out.println(prop.getProperty("date"));
	    menu();
	}
	

}
