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
		String año="2010";
		String minPop = "2900139";
		String maxPop = "3900138";
		System.out.println("listarPaisesPorPoblacionEnXAño="+año);
		for(String s:r.listarPaisesPorLaPoblacionEnXAñoMayorAY(año,minPop, maxPop)){
			System.out.println("\t"+s);
		}
		System.out.println();
		
		System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		int gdp = 12700;
		for(String s:r.gdp(gdp)){
			System.out.println("\t"+s);
		}
		
		System.out.println();
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		String border = "AL";
		for(String s:r.border(border)){
			System.out.println("\t"+s);
		}
		System.out.println();
		
		System.out.println("***************************************************************************************************************");
		int year2 = 2012;
		for(String s:r.population(year2)){
			System.out.println("\t"+s);
		}
	}

}
