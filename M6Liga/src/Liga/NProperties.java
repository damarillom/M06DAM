package Liga;

import java.io.IOException;
import java.util.Properties;

public class NProperties extends Properties {
	public NProperties(String idioma){
        if(idioma.equals("ES")){//espa�ol
            getProperties("ES.properties");
        }else if(idioma.equals("EN")){//Ingles
            getProperties("EN.properties");
        }else{//sino por default idioma espa�ol
            getProperties("ES");
        }
    }
 
    /* se leen las propiedades */
     private void getProperties(String idioma) {
        try {                
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {   
        	
        }
   }
}
