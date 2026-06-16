package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create2 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/company";
		String user="root";
		String password="1234";
		
		String sql="insert into porder(name,ruler,pen,sum) values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "rty");
			ps.setInt(2, 1);
			ps.setInt(3, 2);
			ps.setInt(4, 150);
			ps.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}
	}

}
