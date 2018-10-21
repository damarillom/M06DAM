/**
 * 
 */
package world;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * @author danie
 *
 */
public class WorldReader extends DomReader {

	public WorldReader(String xml) throws ParserConfigurationException, SAXException, IOException {
		super(xml);
	}
	
	public List<String> listarPaisesPorLaPoblacionEnXAñoMayorAY(String year, String minPop){
		return(super.extractList("//country[population/@year="+year+"][population>"+minPop+"]/@car_code"));
	}
	
}
