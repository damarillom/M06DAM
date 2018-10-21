package bibliotecas;

import java.io.IOException;

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
public class MainBibliotecas {

	

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		BibliotecasReader r=new BibliotecasReader("data/bibliotecas.xml");
		
		
		String cp="48450";
		System.out.println("emails para cp="+cp);
		for(String s:r.listarMailsPorCP(cp)){
			System.out.println("\t"+s);
		}
		System.out.println();
		
		String id="6";
		System.out.println("Telefono para id (row) "+id);
		System.out.println("\t"+r.telefonoPorID(id));
		System.out.println();
		
		String telf="944 672 946";
		System.out.println("Id para telefono "+telf);
		System.out.println("\t"+r.idPorTelefono(telf));
		System.out.println();
		
		/**System.out.println("prueba");
		r.prueba(cp);*/

	}

	

}
