package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/company";
		String user = "root";
		String password = "1234";
		String sql="delete from porder where id=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.executeUpdate();
			 
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		}
	}

}
