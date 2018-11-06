/**
 * 
 */
package DanielAmarilloXMLM6UF1;

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
		String pais = "Albania";
		System.out.println("Capital Pais: ");
		System.out.println(r.capital(pais));
		
		System.out.println("Desempleo mayor al 68%: ");
		System.out.println(r.unemploymentPlus());
		
		
		System.out.println("Capitales privincia Alemania:");
		System.out.println(r.GermanCap());
		
	}

}
