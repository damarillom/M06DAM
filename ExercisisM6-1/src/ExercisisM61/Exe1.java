package ExercisisM61;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;


public class Exe1 {
	final String path = "../../Documents/archivosM06/Ex1_1.bin";
	public void write() throws FileNotFoundException, IOException {
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(path))) {
			out.writeUTF("John");
			out.writeDouble(85.5);
			out.writeUTF("Jim");
			out.writeDouble(185.5);
			out.writeUTF("George");
			out.writeDouble(105.5);
		}
	}
	public void read() throws FileNotFoundException, IOException {
		try (DataInputStream in = new DataInputStream(new FileInputStream(path))) {
			while (in.available() > 0) {
				String name = in.readUTF();
				double num = in.readDouble();
				System.out.println(name + " " + num);
				
			}
		}
		
	}
}

