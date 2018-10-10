/**
 * 
 */
package Liga;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;


/**
 * @author iam26509397
 *
 */
public class Main extends Properties {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
	    InputStream is = null;
	    String pathProp = "C:/Users/danie/Desktop/M06/M06DAM/M6Liga/ES.properties";
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
	    System.out.println("| Options:                 							");
	    System.out.println("|        1. Selecciona Idioma       				");
	    System.out.println("|        2. Ver Resultados  						");
	    System.out.println("|        3. Introducir resultado			        ");
	    System.out.println("|        4. Reinciar liga					        ");
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
		    	pathProp = "C:/Users/danie/Desktop/M06/M06DAM/M6Liga/EN.properties";
		    } else if (idioma == 2) {
		    	pathProp = "C:/Users/danie/Desktop/M06/M06DAM/M6Liga/ES.properties";
		    } else {
		    	System.out.println("Invalid selection");
		    }
	    	System.out.println(pathProp);
	    	is = new FileInputStream(pathProp);
			prop.load(is);
	    	System.out.println(prop.getProperty("team"));
	      	break;
	    case 2:
	    	
	      	break;
	    case 3:
	    	
		  	break;
	    case 4:
	    	
		    break;
	    default:
	    	System.out.println("Invalid selection");
	    	break; 
	    }
	    System.out.println(prop.getProperty("date"));
	}
	

}
