package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpDate {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/company";
		String user = "root";
		String password = "1234";
		
		String sql="Update porder set name=?,ruler=?,pen=?,sum=? where id=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,"qqq");
			ps.setInt(2, 5);
			ps.setInt(3, 5);
			ps.setInt(4, 500);
			ps.setInt(5, 6);
			ps.executeUpdate();
			

		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}
	}

}
