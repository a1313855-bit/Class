package util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Create {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/company";
		String user = "root";
		String password = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}

	}

}
