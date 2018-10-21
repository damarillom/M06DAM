/**
 * 
 */
package world;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * @author danie
 *
 */
public class MainWorld {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		WorldReader r = new WorldReader("data/world.xml");
		String año="1970";
		String minPop = "1214489";
		System.out.println("listarPaisesPorPoblacionEnXAño="+año);
		for(String s:r.listarPaisesPorLaPoblacionEnXAñoMayorAY(año,minPop)){
			System.out.println("\t"+s);
		}
		System.out.println();
	}

}
