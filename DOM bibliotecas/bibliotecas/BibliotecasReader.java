package bibliotecas;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * 
 * Copyright 2015 Daniel Cruz <i>
 * <a href="mailto:dani.cruz.morales@gmail.com">dani.cruz.morales@gmail.com</a><br><br>
 * 
 * This is free software, licensed under the GNU General Public License v3.<br>
 * See <a href="http://www.gnu.org/licenses/gpl.html">http://www.gnu.org/licenses/gpl.html</a> for more information.
 *
 * @author Daniel Cruz 
 *
 */
public class BibliotecasReader extends DomReader {

	public BibliotecasReader(String xml) throws ParserConfigurationException, SAXException, IOException {
		super(xml);
		
	}
	
	
	public List<String> listarMailsPorCP(String cp){
		return(super.extractList("//row[librarycp="+cp+"]/libraryemail/text()"));
	}
	
	public String telefonoPorID(String id){
		return(super.extractValue("//row[@num="+id+"]/libraryphone/text()"));
	}


	public String idPorTelefono(String telf) {
		
		return(super.extractValue("//row[libraryphone='"+telf+"']/@num"));
	}
	
	/**public void prueba(String cp) {
		List<String> lista = super.extractList("//row[librarycp="+cp+"]/libraryemail/text()");
		super.print(lista);
	}*/
	
	
	
	

}
