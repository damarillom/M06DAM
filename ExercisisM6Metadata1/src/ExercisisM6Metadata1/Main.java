package ExercisisM6Metadata1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
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
	    System.out.println("| Options:                 						");
	    System.out.println("|        1. Display file's lenght       		");
	    System.out.println("|        2. Dispaly file's last modified date   ");
	    System.out.println("|        3. Create Directory			        ");
	    System.out.println("|        4. list the elements inside the directory		            ");
	    System.out.println("|        5. Rename			           								");
	    System.out.println("|        6. Display permissions			    				        ");
	    System.out.println("|        7. Set read-only attribute						            ");
	    System.out.println("|        8. All files whose name matches the given string		 	");
	    System.out.println("=====================================================================");
	    swValue = Keyin.inInt(" Select option: ");

	    // Switch construct
	    switch (swValue) {
	    case 1:
	    	System.out.println("Option 1 selected");
	    	if (file.exists()) {
	    		System.out.println(file.length() + " bytes");
	    	} else {
	    		System.out.println("El fichero no existe");
	    	}
	      	break;
	    case 2:
	    	System.out.println("Option 2 selected");
	    	if (file.exists()) {
	    		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    		System.out.println(sdf.format(file.lastModified()));
	    	} else {
	    		System.out.println("El fichero no existe");
	    	}
	      	break;
	    case 3:
	    	System.out.println("Option 3 selected");
	    	//System.out.println(file.mkdir());
	    	if(!file.exists()){
				// create the folder
				boolean result = file.mkdir();
				if(result){
					System.out.println("Successfully created "+file.getAbsolutePath());
				}
				else{
					System.out.println("Failed creating "+file.getAbsolutePath());
				}
			} else {
	    		System.out.println("El fichero no existe");
	    	}
		  	break;
	    case 4:
	    	System.out.println("Option 4 selected");
	    	if (file.exists()) {
	    		File[] listOfFiles = file.listFiles();
	    		for (int i = 0; i < listOfFiles.length; i++) {
	    			  if (listOfFiles[i].isFile()) {
	    				  System.out.println("Archivo " + listOfFiles[i].getName());
	    			  } else if (listOfFiles[i].isDirectory()) {
	    				  System.out.println("Directorio " + listOfFiles[i].getName());
	    			  }
	    		}
	    	} else {
	    		System.out.println("El fichero no existe");
	    	}
		    break;
	    case 5:
		    System.out.println("Option 5 selected");
		    if (file.exists()) {
			    String[] pathArray = path.split("/");
			    String newPath = "";
			    for (int i = 0; i < (pathArray.length - 1); i++) {
			    	newPath += pathArray[i] + "/";
			    }
			    String newName = Keyin.inString(" Select a new name: ");
				File newfile =new File(newPath + newName);	
				if(file.renameTo(newfile)){
					System.out.println("Rename succesful");
				}else{
					System.out.println("Rename failed");
				}
		    } else {
	    		System.out.println("El fichero no existe");
	    	}
		    break;
	    case 6:
		    System.out.println("Option 6 selected");
		    if (file.exists()) {
		    	System.out.println("Executable: " + file.canExecute()); 
	            System.out.println("Readable: " + file.canRead()); 
	            System.out.println("Writable: "+ file.canWrite()); 
		    } else {
	    		System.out.println("El fichero no existe");
	    	}
		    break;
	    case 7:
	    	System.out.println("Option 7 selected");
	    	if (file.exists()) {
	    		file.setReadOnly();
	    	} else {
	    		System.out.println("El fichero no existe");
	    	}
	    	break;
	    case 8:
	    	System.out.println("Option 8 selected");
	    	
	    	if (file.exists()) {
	    		String search = Keyin.inString(" Select the string to search: ");
	    		/**File[] listOfFiles = file.listFiles();
	    		for (int i = 0; i < listOfFiles.length; i++) {
	    			  if (listOfFiles[i].isFile()) {
	    				  if (listOfFiles[i].getName().contains(search)) {
	    					  System.out.println("Archivo " + listOfFiles[i].getName());
	    				  }
	    			  } else if (listOfFiles[i].isDirectory()) {
	    				  if (listOfFiles[i].getName().contains(search)) {
	    					  System.out.println("Directorio " + listOfFiles[i].getName());
	    				  }
	    			  }
	    		}*/
	    		Main.busqueda(file, search, path);
	    	} else {
	    		System.out.println("El fichero no existe");
	    	}
	    	break;
	    default:
	    	System.out.println("Invalid selection");
	    	break; 
	    }
	}
	public static void busqueda(File file, String search, String path) {
		File[] listOfFiles = file.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			  if (listOfFiles[i].isFile()) {
				  if (listOfFiles[i].getName().contains(search)) {
					  System.out.println("Archivo " + listOfFiles[i].getName());
				  }
			  } else if (listOfFiles[i].isDirectory()) {
				  File file2 = new File(path + file.getName());
				  Main.busqueda(file2, search, path);
			  }
		}
	}
	private String abrirArchivo() {
		  String aux="";   
		  String texto="";
		  try
		  {
		   /**llamamos el metodo que permite cargar la ventana*/
		   JFileChooser file=new JFileChooser();
		   file.showOpenDialog(this);
		   /**abrimos el archivo seleccionado*/
		   File abre=file.getSelectedFile();
		 
		   /**recorremos el archivo, lo leemos para plasmarlo
		   *en el area de texto*/
		   if(abre!=null)
		   {     
		      FileReader archivos=new FileReader(abre);
		      BufferedReader lee=new BufferedReader(archivos);
		      while((aux=lee.readLine())!=null)
		      {
		         texto+= aux+ "\n";
		      }
		         lee.close();
		    }    
		   }
		   catch(IOException ex)
		   {
		     JOptionPane.showMessageDialog(null,ex+"" +
		           "\nNo se ha encontrado el archivo",
		                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
		    }
		  return texto;//El texto se almacena en el JTextArea
		}
}
