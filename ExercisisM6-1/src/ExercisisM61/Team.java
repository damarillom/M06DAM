package ExercisisM61;

import java.io.Serializable;
import java.util.Arrays;

public class Team implements Serializable{
	private static final long serialVersionUID = 1;
	String[][] players;
	public Team(String[][] players) {
		this.players = players;
	}
	public String[][] getPlayers() {
		return players;
	}
	public void setPlayers(String[][] players) {
		this.players = players;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Team [players=" + Arrays.toString(players) + "]";
	}
	
}
