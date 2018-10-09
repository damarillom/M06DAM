package ExercisisM61;

import java.io.File;
import java.io.IOException;

import javax.swing.text.TableView.TableRow;

public class Exe5 {
	private static final String S = File.separator; // SEPARATOR
	//private static final String MYENV = System.getenv("HOME");
	private static final String ENVIRONMENT = System.getenv("HOME") + "in" + S + "green" + S + "environment";
	private static final String PATH = System.getenv("HOME") + "in" + S + "and" + S + "out" + S + "comoprogramar.txt";

	public static void ex5() throws IOException {
		File f = new File(ENVIRONMENT);
		File f2 = new File(PATH);
		try {
			f.mkdirs();
			//f.createNewFile();
			f2.getParentFile().mkdirs();
			f2.createNewFile();
			System.out.println(ENVIRONMENT);
			System.out.println(PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

