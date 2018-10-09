package ExercisisM61;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Exe1 exe1 = new Exe1();
		exe1.write();
		exe1.read();
		
		System.out.println("///////////");
		Exe2 exe2 = new Exe2();
		exe2.write();
		exe2.read();
		
		System.out.println("///////////");
		Exe3 exe3 = new Exe3();
		exe3.write();
		exe3.read();
		
		System.out.println("///////////");
		String[][] players;
        final int NUM_ROWS = 12; //rows
        final int NUM_COLS = 4;  //columns
        players = new String[NUM_ROWS][NUM_COLS];

              
        players[0][0] = "Jordi";
        players[1][0] = "Joel";
        players[2][0] = "Marco";
        players[3][0] = "Jonathan";
        players[4][0] = "Dani";
        players[5][0] = "Cristóbal";
        players[6][0] = "Ricard";
        players[7][0] = "Pere";
        players[8][0] = "Raúl";
        players[9][0] = "Miquel";
        players[10][0] = "Joan";
        players[11][0] = "Miguel";

        players[0][1] = "4";
        players[1][1] = "5";
        players[2][1] = "6";
        players[3][1] = "7";
        players[4][1] = "8";
        players[5][1] = "9";
        players[6][1] = "10";
        players[7][1] = "11";
        players[8][1] = "12";
        players[9][1] = "13";
        players[10][1] = "14";
        players[11][1] = "15";
        
        players[0][2] = "point guard";
        players[1][2] = "shooting guard";
        players[2][2] = "power forward";
        players[3][2] = "point guard";
        players[4][2] = "center";
        players[5][2] = "small forward";
        players[6][2] = "small forward";
        players[7][2] = "shooting guard";
        players[8][2] = "power forward";
        players[9][2] = "small forward";
        players[10][2] = "center";
        players[11][2] = "power forward";
        
        players[0][3] = "1.72";
        players[1][3] = "1.69";
        players[2][3] = "1.84";
        players[3][3] = "1.64";
        players[4][3] = "1.74";
        players[5][3] = "1.82";
        players[6][3] = "1.81";
        players[7][3] = "1.78";
        players[8][3] = "1.83";
        players[9][3] = "1.88";
        players[10][3] = "1.82";
        players[11][3] = "1.78"; 
		Team team = new Team(players);
		Exe4 exe4 = new Exe4();
		exe4.write(team);
		exe4.read();
		
	}
}
