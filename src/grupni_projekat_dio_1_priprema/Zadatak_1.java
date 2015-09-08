package grupni_projekat_dio_1_priprema;

import java.sql.*;

public class Zadatak_1 {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// Invoke the methods and get the result
		int option = menu();
		searchDB(option);
	}

	// Print the menu and choose an option
	public static int menu() {
		java.util.Scanner input = new java.util.Scanner(System.in);
		// Print user menu
		System.out.println("Search for the Country:\n"
				+ "\n1. Search by Country Name" + "\n2. Search by Population"
				+ "\n3. Search by City Name" + "\n0. Exit");
		// Choose an option
		int option = input.nextInt();
		// Return chosen option
		return option;
	}

	// Search DataBase for the results
	public static void searchDB(int option) throws ClassNotFoundException,
			SQLException {
		java.util.Scanner input = new java.util.Scanner(System.in);
		// Load the JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		// Connect to a database
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/world", "root", "3clips3");
		// Create a statement
		Statement statement = connection.createStatement();
		// Create a result set
		ResultSet resultSet = null;
		// User's option 1
		// Search for the country through the DB and print the result
		if (option == 1) {
			// User input
			// Enter the country name
			System.out.println("\nEnter Country Name:");
			String country = input.nextLine();
			// Execute a statement
			resultSet = statement
					.executeQuery("SELECT*FROM Country WHERE Name = \""
							+ country + "\"");
			// Iterate through the result and print the country
			while (resultSet.next()) {
				System.out.println(resultSet.getString("Code") + "\t"
						+ resultSet.getString("Name") + "\t"
						+ resultSet.getString("Continent") + "\t"
						+ resultSet.getString("Region") + "\t"
						+ resultSet.getFloat("SurfaceArea") + "\t"
						+ resultSet.getInt("IndepYear") + "\t"
						+ resultSet.getInt("Population") + "\t"
						+ resultSet.getFloat("LifeExpectancy") + "\t"
						+ resultSet.getFloat("GNP") + "\t"
						+ resultSet.getFloat("GNPOld") + "\t"
						+ resultSet.getString("LocalName") + "\t"
						+ resultSet.getString("GovernmentForm") + "\t"
						+ resultSet.getString("HeadOfState") + "\t"
						+ resultSet.getInt("Capital") + "\t"
						+ resultSet.getString("Code2"));
			}
			// Close the connection
			connection.close();
			// User's option 2
			// Search for the country based on the population
		} else if (option == 2) {
			// User input
			// Enter the population
			System.out.println("\nEnter Population:");
			int population = input.nextInt();
			// Execute a statement
			resultSet = statement
					.executeQuery("SELECT*FROM Country WHERE Population = \""
							+ population + "\"");
			// Iterate through the result and print the country
			while (resultSet.next()) {

				System.out.println(resultSet.getString("Code") + "\t"
						+ resultSet.getString("Name") + "\t"
						+ resultSet.getString("Continent") + "\t"
						+ resultSet.getString("Region") + "\t"
						+ resultSet.getFloat("SurfaceArea") + "\t"
						+ resultSet.getInt("IndepYear") + "\t"
						+ resultSet.getInt("Population") + "\t"
						+ resultSet.getFloat("LifeExpectancy") + "\t"
						+ resultSet.getFloat("GNP") + "\t"
						+ resultSet.getFloat("GNPOld") + "\t"
						+ resultSet.getString("LocalName") + "\t"
						+ resultSet.getString("GovernmentForm") + "\t"
						+ resultSet.getString("HeadOfState") + "\t"
						+ resultSet.getInt("Capital") + "\t"
						+ resultSet.getString("Code2"));
			}
			// Close the connection
			connection.close();
			// User's option 3
			// Search for the country based on the city
		} else if (option == 3) {
			// User input
			// Enter the city name
			System.out.println("\nEnter City Name:");
			String city = input.nextLine();
			// Execute a statement
			resultSet = statement
					.executeQuery("SELECT*FROM City WHERE Name = \"" + city
							+ "\"");
			// Iterate through the result and print the country
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("ID") + "\t"
						+ resultSet.getString("Name") + "\t"
						+ resultSet.getString("CountryCode") + "\t"
						+ resultSet.getString("District") + "\t"
						+ resultSet.getInt("Population"));
			}
			// Close the connection
			connection.close();
			// Option 0 - exit the program
		} else if (option == 0) {
			System.exit(1);
		} else {
			System.out.println("\nInvalid input!");
		}

	}
}
