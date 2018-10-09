package ExercisisM61;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Exe4 {
	static final String PATH = "data/Team_data3.bin";
	public void write(Team team) throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PATH))) {
	        out.writeObject(team);
        } catch (Exception e) {
			System.out.println("Error: " + e);
		}
        
	}
	public void read() throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH))) {
	        Team team = (Team) in.readObject();
	        for (int i = 0; i < team.players.length; i++) {
	        	System.out.printf("%20s%20s%20s%20s\n", team.getPlayers()[i][0], team.getPlayers()[i][1], team.getPlayers()[i][2], team.getPlayers()[i][3]);
	        }
        } catch (Exception e) {
        	System.out.println("Error: " + e);
		}
	}
}
