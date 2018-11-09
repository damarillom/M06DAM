package world;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JDBCExample {

	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/java", "dani", "jupiter");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			try {
				
				PreparedStatement preparedStatement = null;
		        String sql = "DROP TABLE prueba";
		        //try {
		        	preparedStatement = connection.prepareStatement(sql);
		        //} catch (Exception e) {
		        	
		        //}
				/**preparedStatement = null;
		        sql = "CREATE TABLE prueba IF NOT EXISTS (ID INT, NAME TEXT)";
		        preparedStatement = connection.prepareStatement(sql);
		        preparedStatement.executeUpdate();*/
		        
		        
		        /**PreparedStatement preparedStatement = null;
		        String sql = "DROP TABLE pais";
		        try {
		        	preparedStatement = connection.prepareStatement(sql);
		        } catch (Exception e) {
		        	
		        }
				preparedStatement = null;
		        sql = "CREATE TABLE pais IF NOT EXISTS (ID int NOT NULL AUTO_INCREMENT, NAME TEXT)";
		        preparedStatement = connection.prepareStatement(sql);
		        preparedStatement.executeUpdate();
		        
		        preparedStatement = null;
		        sql = "DROP TABLE province";
		        try {
		        	preparedStatement = connection.prepareStatement(sql);
		        } catch (Exception e) {
		        	
		        }
				preparedStatement = null;
		        sql = "CREATE TABLE privince IF NOT EXISTS (ID int NOT NULL AUTO_INCREMENT, NAME TEXT, pais INT)";
		        preparedStatement = connection.prepareStatement(sql);
		        preparedStatement.executeUpdate();
		        
		        preparedStatement = null;
		        sql = "DROP TABLE city";
		        try {
		        	preparedStatement = connection.prepareStatement(sql);
		        } catch (Exception e) {
		        	
		        }
				preparedStatement = null;
		        sql = "CREATE TABLE city IF NOT EXISTS (ID int NOT NULL AUTO_INCREMENT, NAME TEXT, province INT, pais INT)";
		        preparedStatement = connection.prepareStatement(sql);
		        preparedStatement.executeUpdate();
		        
		        WorldReader r = new WorldReader("data/world.xml");
		        
		        System.out.println(r.getListCountrys());*/
		        
		        System.out.println("table is create");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
		} else {
			System.out.println("Failed to make connection!");
		}
		
		
	}

}
