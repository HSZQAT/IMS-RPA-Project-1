package film_shop.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDriver {

	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/film_shop";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	static Connection connection;
	static Statement statement;

	public static void connect() {

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void execUpdate(String query) {

		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ResultSet execQuery(String query) {

		ResultSet results = null;

		try {
			results = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return results;

	}

	public static void close() {

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
