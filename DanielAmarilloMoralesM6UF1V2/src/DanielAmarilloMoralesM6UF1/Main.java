package DanielAmarilloMoralesM6UF1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	private final static File FILE = new File("./data/liga/liga.bin");
	static String pathProp;
	public static void main(String[] args) throws IOException {
		int maxScore = 0;
		int minScore = 0;
		int refereeLen = 0;
		int nEquipos = 0;
		String lan = "";
		JSONParser parser = new JSONParser();
		try {
	    	Object obj = parser.parse(new FileReader("./data/data.json"));
	    	
	        JSONObject jsonObject = (JSONObject) obj;
	        nEquipos = Integer.parseInt((String) jsonObject.get("nEquipos"));
	        maxScore = Integer.parseInt((String) jsonObject.get("maxScore"));
	        minScore = Integer.parseInt((String) jsonObject.get("minScore"));
	        refereeLen = Integer.parseInt((String) jsonObject.get("refereeLen"));
	        String patrocinador = (String) jsonObject.get("patrocinador");
			String temporada = (String) jsonObject.get("temporada");
			lan = (String) jsonObject.get("lan");
	    	
			if (lan.equals("ES")) {
				pathProp = "./data/ES.properties";
			} else if (lan.equals("EN")) {
				pathProp = "./data/EN.properties";
			} else {
				String lanSO = Locale.getDefault().toString();
				if (lanSO.equals("es_ES")) {
					lan = "ES";
					pathProp = "./data/ES.properties";
				} else if (lanSO.equals("en_US")) {
					lan = "EN";
					pathProp = "./data/EN.properties";
				} else {
					lan = "EN";
					pathProp = "./data/EN.properties";
				}
			}    		
			
	    	JSONObject newObj = new JSONObject();
			newObj.put("nEquipos", nEquipos+"");
			newObj.put("maxScore", maxScore+"");
			newObj.put("minScore", minScore+"");
			newObj.put("refereeLen", refereeLen+"");
			newObj.put("patrocinador", patrocinador);
			newObj.put("temporada", temporada);
			newObj.put("lan", lan);
			
			
			String ruta = "./data/data.json";
			File archivo = new File(ruta);
			BufferedWriter bw;
			try (FileWriter fileJson = new FileWriter("./data/data.json")) {
				fileJson.write(newObj.toJSONString());
				//System.out.println("Successfully Copied JSON Object to File...");
				//System.out.println("\nJSON Object: " + obj);
			}
	    } catch (Exception e) {
	    	System.out.println("Error:" + e);
	    }
		
		
		//Prueba.jsonIdioma();
		//Escoge el idioma del SO
		/**String lanSO = Locale.getDefault().toString();
		if (lanSO.equals("es_ES")) {
			pathProp = "./ES.properties";
		} else if (lanSO.equals("en_US")) {
			pathProp = "./EN.properties";
		} else {
			pathProp = "./EN.properties";
		}*/
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
	    final String pathArch = "./data/liga/liga.bin";
	    //String pathProp = "./ES.properties";
	    is = new FileInputStream(pathProp);
		prop.load(is);
		//Generamos el archivo properties
		//prueba.generarProperties();
		
	
		
		//System.out.println("Working Directory = " + System.getProperty("user.dir"));
		// Local variable
	    int swValue;
	    String path;
	    //path = Keyin.inString("Inserte la ruta del archivo o directorio: ");
	    path = "";
	    File file = new File(path);
	    // Display menu graphics
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    try {
	    	 
            Object obj = parser.parse(new FileReader("./data/data.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(prop.getProperty("welcome")+  " " + jsonObject.get("patrocinador") +  " " + jsonObject.get("temporada") + " de Daniel Amarillo Morales");
	    } catch (Exception e) {
			// TODO: handle exception
		}
	    System.out.println();
	    System.out.println();
	    
	    System.out.println("=====================================================================");
	    System.out.println("|   MENU SELECTION DEMO    						");
	    System.out.println("=====================================================================");
	    System.out.println("| "+prop.getProperty("options")+":                 							");
	    System.out.println("|        1. "+prop.getProperty("lan")+"       				");
	    System.out.println("|        2. "+prop.getProperty("see")+"  						");
	    System.out.println("|        3. "+prop.getProperty("intro")+"			        ");
	    System.out.println("|        4. "+prop.getProperty("reboot")+"					        ");
	    System.out.println("|        5. Agregar Diagonal					        ");
	    System.out.println("|        6. Mostrar Diagonal					        ");
	    System.out.println("|        7. Ranking					        ");
	    System.out.println("|        8. "+prop.getProperty("exit")+"					        ");
	    System.out.println("=====================================================================");
	    swValue = Keyin.inInt(" Select option: ");
	    // Switch construct
	    switch (swValue) {
	    case 1:
	    	int idioma;
	    	//Menu idiomas
	    	System.out.println("| Options:         	 ");
		    System.out.println("|        1. English  ");
		    System.out.println("|        2. Spanish  ");
		    idioma = Keyin.inInt(" Select option:    ");
		    /**Properties prop = new Properties();
		    InputStream is = null;
		    String pathProp = "";*/
		    String lan = "";
		    //Elige el properties a usar
		    if (idioma == 1) {
		    	pathProp = "./data/EN.properties";
		    	lan = "EN";
		    } else if (idioma == 2) {
		    	pathProp = "./data/ES.properties";
		    	lan = "ES";
		    } else {
		    	System.out.println("Invalid selection");
		    }
		    
		    //Carga los properties elegidos
	    	//System.out.println(pathProp);
	    	is = new FileInputStream(pathProp);
			prop.load(is);
			
			
			try {
		    	Object obj = parser.parse(new FileReader("./data/data.json"));
		    	
		        JSONObject jsonObject = (JSONObject) obj;
		        nEquipos = Integer.parseInt((String) jsonObject.get("nEquipos"));
		        maxScore = Integer.parseInt((String) jsonObject.get("maxScore"));
		        minScore = Integer.parseInt((String) jsonObject.get("minScore"));
		        refereeLen = Integer.parseInt((String) jsonObject.get("refereeLen"));
		        String patrocinador = (String) jsonObject.get("patrocinador");
				String temporada = (String) jsonObject.get("temporada");
				
		    	
			   		
				
		    	JSONObject newObj = new JSONObject();
				newObj.put("nEquipos", nEquipos+"");
				newObj.put("maxScore", maxScore+"");
				newObj.put("minScore", minScore+"");
				newObj.put("refereeLen", refereeLen+"");
				newObj.put("patrocinador", patrocinador);
				newObj.put("temporada", temporada);
				newObj.put("lan", lan);
				
				
				String ruta = "./data/data.json";
				File archivo = new File(ruta);
				BufferedWriter bw;
				try (FileWriter fileJson = new FileWriter("./data/data.json")) {
					fileJson.write(newObj.toJSONString());
					//System.out.println("Successfully Copied JSON Object to File...");
					//System.out.println("\nJSON Object: " + obj);
				}
		    } catch (Exception e) {
		    	System.out.println("Error:" + e);
		    }
	    	
	    	//System.out.println(prop.getProperty("team"));
	      	break;
	    case 2:
	    	long bytePart = Prueba.weightMatch();
	    	long bytePart2 = Prueba.weightTeam();
	    	long jump2 = 0;
	    	try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
	    		//Pone los encabezados de la tabla
	    		System.out.printf("%-10s%-40s%-10s%-10s%-10s\n","Resultado","Arbitro","fecha", "Local", "Visitante");
	    		//A�ade los partidos a la tabla
	    		for (int i = 0; i < nEquipos; i++) {
		    		for (int j = 0; j < nEquipos; j++) {
		    			raf.seek(jump2);
		    			/**System.out.println("ScoreT1:" + raf.readInt());
		    			System.out.println("ScoreT2:" + raf.readInt());
		    			System.out.println("referee:" + raf.readUTF());	
		    			System.out.println("fecha:" + raf.readInt());
		    			System.out.println("T1:" + raf.readInt());
		    			System.out.println("T2:" + raf.readInt() + "\n\n");*/
		    			if (i != j) {
		    				System.out.printf("%-10s%-40s%-10s%-10s%-10s\n",raf.readInt() +"-"+ raf.readInt(),""+ raf.readUTF(),raf.readInt() + "-" + raf.readInt() + "-" + raf.readInt(), ""+raf.readInt(), ""+raf.readInt());
		    				
		    			}
		    			jump2 += bytePart;
		    		}
	    		}
	    	}
	      	break;
	    case 3:
	    	long bitePart = Prueba.weightMatch();
	    	//long bitePart2 = Prueba.weightTeam();
	    	long jump = 0;
	    	try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
	    		//Recorremos todos los partidos
	    		for (int i = 0; i < nEquipos; i++) {
		    		for (int j = 0; j < nEquipos; j++) {
		    			raf.seek(jump);
		    			int scoreT1 = raf.readInt();
		   				int scoreT2 = raf.readInt();
		   				String referee = "";//raf.readUTF();
	    				int day = raf.readInt();
	    				int month = raf.readInt();
	    				int year = raf.readInt();
	    				int eLocal = raf.readInt();
		   				int eVisit = raf.readInt();
		   				//Comprobamos que no se haya jugado
		   				if (scoreT1 == -1) {
		   					//System.out.println(eLocal);
		   					//System.out.println(eVisit);
		   					
		   					//y que no sea un partido entre el mismo equipo 2 veces
		    				if (i != j) {
		   						scoreT1 = Keyin.inInt(" Score team Local: ");
		   						scoreT2 = Keyin.inInt(" Score visit team: ");
		   						referee = Keyin.inString(" Introduce Referee: ");
		    					day = Keyin.inInt(" day: ");
		    					month = Keyin.inInt(" month (numeric): ");
		    					year = Keyin.inInt(" year: ");
		    					raf.seek(jump);
		    					try  {
		    						if (scoreT1 <= maxScore && scoreT1 > minScore && scoreT2 <= maxScore && scoreT2 > minScore && referee.length() <= refereeLen) {
		   								raf.writeInt(scoreT1);
		   								raf.writeInt(scoreT2);
		   								raf.writeUTF(referee);
		   								raf.writeInt(day);
		   								raf.writeInt(month);
		   								raf.writeInt(year);
		    							raf.writeInt(i);
		    							raf.writeInt(j);
		    						}
		    					
		    					} catch (Exception e) {
									System.out.println("ERROR: " + e);
								}
		    						
		   						i = nEquipos;
		   						j = nEquipos;
		   					} 
		   				}
		   				jump += bitePart;
		    		}
	    		}
	    	}
		  	break;
	    case 4:
	    	//Hace una copia de seguridad
	    	Prueba.copiaSeguridad();
	    	
	    	//modifica el json con los valores que pide al usuario
	    	try {
            	Object obj = parser.parse(new FileReader("./data/data.json"));
            	
                JSONObject jsonObject = (JSONObject) obj;
                nEquipos = Keyin.inInt(" Total of teams: ");
                maxScore = Keyin.inInt(" Max Score of a team: ");
                minScore = Integer.parseInt((String) jsonObject.get("minScore"));
                refereeLen = Integer.parseInt((String) jsonObject.get("refereeLen"));
                String patrocinador = Keyin.inString(" Insert patrocinador: ");
	    		String temporada = Keyin.inString(" Insert Temporada: ");
            	String lang = (String) jsonObject.get("lan");
            	
            	JSONObject newObj = new JSONObject();
        		newObj.put("nEquipos", nEquipos+"");
        		newObj.put("maxScore", maxScore+"");
        		newObj.put("minScore", minScore+"");
        		newObj.put("refereeLen", refereeLen+"");
        		newObj.put("patrocinador", patrocinador);
        		newObj.put("temporada", temporada);
        		newObj.put("lan", lang);
        		
        		String ruta = "./data/data.json";
        		File archivo = new File(ruta);
        		BufferedWriter bw;
        		try (FileWriter fileJson = new FileWriter("./data/data.json")) {
        			fileJson.write(newObj.toJSONString());
        			//System.out.println("Successfully Copied JSON Object to File...");
        			//System.out.println("\nJSON Object: " + obj);
        		}
            } catch (Exception e) {
            	System.out.println("Error:" + e);
            }
	    	
	    	//hace que liga.bin este vacio
	    	Prueba.borrarArchivo();
	    	
	    	//Rellena liga.bin con los partidos con valores por defecto usados para los partidos no jugados
	    	try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
	    		long jumpC = 0;
	    		long byteToC = Prueba.weightMatch();
	    		long byteToC2 = Prueba.weightMatch();
	    		for (int i = 0; i < nEquipos; i++) {
	    			new File("./data/liga/t"+i).mkdir();
	    			for (int j = 0; j < nEquipos; j++) { 
	    				if (i != j) {
		    				raf.seek(jumpC);
		    				Partido partido = new Partido(i, j);
		    				raf.writeInt(partido.getScoreT1());
		    				raf.writeInt(partido.getScoreT2());
		    				raf.writeUTF(partido.getReferee());
		    				raf.writeInt(partido.getDay());
		    				raf.writeInt(partido.getMonth());
		    				raf.writeInt(partido.getYear());
		    				raf.writeInt(partido.geteLocal());
		    				raf.writeInt(partido.geteVisit());
		    				
		    				//System.out.println(partido.getDate()+"-"+partido.geteLocal() +"-"+partido.geteVisit() );
		    				//jumpC += byteToC;
	    				} else {
	    					{
		    					raf.seek(jumpC);
		    					raf.writeUTF("Prueba Equipo " + i);
		    					//jumpC += byteToC2;
		    				} 
	    				}
	    				jumpC += byteToC;
	            	}               
	        	}
	    		
	    		//String patrocinador = Keyin.inString(" Insert patrocinador: ");
	    		//String temporada = Keyin.inString(" Insert Temporada: ");
	    		//raf.writeUTF(patrocinador);
	    		//raf.writeUTF(temporada);	
	    		
	    		
	    	} catch (Exception e) {
				System.out.println(e);
			}
		    break;
	    case 5:
	    	long biteDiagonal = Prueba.weightMatch();
	    	//long bitePart2 = Prueba.weightTeam();
	    	long jump4 = 0;
	    	try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
	    		//Recorremos todos los partidos
	    		for (int i = 0; i < nEquipos; i++) {
		    		for (int j = 0; j < nEquipos; j++) {
		    			if (i == j) {
		    				String des = "Equipo " + i + ": ";
		    				des += Keyin.inString("Descripcion equipo " + i +":");
		    				raf.seek(jump4);
		    				try {
		    					if (des.length() < 300) {
		    						raf.writeUTF(des);
		    					}
		    				} catch (Exception e) {
								// TODO: handle exception
							}
		    			}
		    			/**raf.seek(jump4);
		    			int scoreT1 = raf.readInt();
		   				int scoreT2 = raf.readInt();
		   				String referee = raf.readUTF();
	    				int day = raf.readInt();
	    				int month = raf.readInt();
	    				int year = raf.readInt();
	    				int eLocal = raf.readInt();
		   				int eVisit = raf.readInt();
		   				//Comprobamos que no se haya jugado
		   				if (scoreT1 == -1) {
		   					//System.out.println(eLocal);
		   					//System.out.println(eVisit);
		   					
		   					//y que no sea un partido entre el mismo equipo 2 veces
		    				if (i != j) {
		   						scoreT1 = Keyin.inInt(" Score team Local: ");
		   						scoreT2 = Keyin.inInt(" Score visit team: ");
		   						referee = Keyin.inString(" Introduce Referee: ");
		    					day = Keyin.inInt(" day: ");
		    					month = Keyin.inInt(" month (numeric): ");
		    					year = Keyin.inInt(" year: ");
		    					raf.seek(jump);
		    					try  {
		    						if (scoreT1 <= maxScore && scoreT1 > minScore && scoreT2 <= maxScore && scoreT2 > minScore && referee.length() <= refereeLen) {
		   								raf.writeInt(scoreT1);
		   								raf.writeInt(scoreT2);
		   								raf.writeUTF(referee);
		   								raf.writeInt(day);
		   								raf.writeInt(month);
		   								raf.writeInt(year);
		    							raf.writeInt(i);
		    							raf.writeInt(j);
		    						}
		    					
		    					} catch (Exception e) {
									System.out.println("ERROR: " + e);
								}
		    						
		   						i = nEquipos;
		   						j = nEquipos;
		   					} 
		   				}*/
		   				jump4 += biteDiagonal;
		    		}
	    		}
	    	}
		  	break;
	    case 6:
	    	long byteDiagonal = Prueba.weightMatch();
	    	long byteDiagonal2 = Prueba.weightTeam();
	    	long jump3 = 0;
	    	try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
	    		for (int i = 0; i < nEquipos; i++) {
		    		for (int j = 0; j < nEquipos; j++) {
		    			raf.seek(jump3);
		    			if (i == j) {
		    				System.out.println(raf.readUTF());
		    			}
		    			
		    			jump3 += byteDiagonal;
		    		}
	    		}
	    	}
	    	break;
	    case 7:
	    	long bytePartRank = Prueba.weightMatch();
	    	long jump6 = 0;
	    	int puntE0 = 0;
	    	try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")){
	    		for (int i = 0; i < nEquipos; i++) {
		    		for (int j = 0; j < nEquipos; j++) {
		    			raf.seek(jump6);
		    			if (i != j) {
		    				if (i == 0 || j == 0) {
		    					int scoreT1 = raf.readInt();
				   				int scoreT2 = raf.readInt();
				   				String referee = raf.readUTF();
			    				int day = raf.readInt();
			    				int month = raf.readInt();
			    				int year = raf.readInt();
			    				int eLocal = raf.readInt();
				   				int eVisit = raf.readInt();
				   				if (eLocal == 0) {
				   					if (scoreT1 > scoreT2) {
				   						puntE0 += 3;
				   					} else if (scoreT1 == scoreT2) {
				   						puntE0 += 1;
				   					}
				   				} else if (eVisit == 0) {
				   					if (scoreT1 < scoreT2) {
				   						puntE0 += 3;
				   					} else if (scoreT1 == scoreT2) {
				   						puntE0 += 1;
				   					}
				   				}
		    				}
		    			}
		    			jump6 += bytePartRank;
		    		}
	    		}
	    	}
	    	System.out.println("Score Equipo 1: " + puntE0);
	    	break;
	    case 8:
		    System.exit(0);
	    	break;
	    default:
	    	System.out.println("Invalid selection");
	    	break; 
	    }
	    //System.out.println(prop.getProperty("date"));
	    menu();
	}

}
