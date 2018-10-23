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
	
	public List<String> listarPaisesPorLaPoblacionEnXAñoMayorAY(String year, String minPop, String maxPop){
		//return(super.extractList("world/country[population/@year>="+year+"][population>="+minPop+"] | world/country[population/@year>=\"+year+\"][population>="+maxPop+"]/@car_code"));
		 return ( super.extractList( "/world/country[population>"+minPop+" and population<"+maxPop+"]" +
		           "/population[@year>="+year+"]/../@car_code" ) );
		// return super.extractList("//country/population[@year >="+year+"][text()>="+min+"][text()<="+max+"]/../name/text()");
	}
	
	public List<String> gdp(int gdp) {
		//return(super.extractList("//country[gdp_total>="+gdp+"]/name/text()"));
		return(super.extractList("world/country[gdp_total>="+gdp+"]/@car_code"));
	}
	
	public List<String> border(String border) {
		//return(super.extractList("//country[border/@country='"+border+"']/@car_code"));
		return super.extractList("world/country[@car_code='"+border+"']/border/@country");

	}
	
	public List<String> population(int year){
		//return(super.extractList("world/country[population/@year>="+year+"]/@car_code"));
		// No sirve en todas las versiones de java
		// return (super.extractList("//country[population[@year>="+year+"]]/name/text()"));
		
		 return super.extractList("//country/population[@year >="+year+"]/../name/text()");
	}
	
}
