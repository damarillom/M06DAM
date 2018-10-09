package ExercisisM61;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exe3 {
	final String path = "../../Documents/archivosM06/Team_data2.bin";
	public void write() throws FileNotFoundException, IOException {
		String[] players;
		int[] nums;
		String[] pos;
		double[] time;
        final int NUM_ROWS = 12; 
        players = new String[NUM_ROWS];
        nums = new int[NUM_ROWS];
        pos = new String[NUM_ROWS];
        time = new double[NUM_ROWS];
              
        players[0] = "Jordi";
        players[1] = "Joel";
        players[2] = "Marco";
        players[3] = "Jonathan";
        players[4] = "Dani";
        players[5] = "Cristóbal";
        players[6] = "Ricard";
        players[7] = "Pere";
        players[8] = "Raúl";
        players[9] = "Miquel";
        players[10] = "Joan";
        players[11] = "Miguel";

        nums[0] = 4;
        nums[1] = 5;
        nums[2] = 6;
        nums[3] = 7;
        nums[4] = 8;
        nums[5] = 9;
        nums[6] = 10;
        nums[7] = 11;
        nums[8] = 12;
        nums[9] = 13;
        nums[10] = 14;
        nums[11] = 15;
        
        pos[0] = "point guard";
        pos[1] = "shooting guard";
        pos[2] = "power forward";
        pos[3] = "point guard";
        pos[4] = "center";
        pos[5] = "small forward";
        pos[6] = "small forward";
        pos[7] = "shooting guard";
        pos[8] = "power forward";
        pos[9] = "small forward";
        pos[10] = "center";
        pos[11] = "power forward";
        
        time[0] = 1.72;
        time[1] = 1.69;
        time[2] = 1.84;
        time[3] = 1.64;
        time[4] = 1.74;
        time[5] = 1.82;
        time[6] = 1.81;
        time[7] = 1.78;
        time[8] = 1.83;
        time[9] = 1.88;
        time[10] = 1.82;
        time[11] = 1.78;
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(path))) {
	        for (int i = 0; i < players.length; i++) {
	        	out.writeUTF(players[i]);
	        	out.writeInt(nums[i]);
	        	out.writeUTF(pos[i]);
	        	out.writeDouble(time[i]);
	        }
        }
	}
	public void read() throws FileNotFoundException, IOException {
		try (DataInputStream in = new DataInputStream(new FileInputStream(path))) {
			while (in.available() > 0) {
				String name = in.readUTF();
				int num = in.readInt();
				String pos = in.readUTF();
				double time = in.readDouble();
				
				System.out.println(name + " " + num + " " + pos  + " " + time);
				//System.out.printf("%20s%3d", name, num);
				
			}
		}
	}
}
