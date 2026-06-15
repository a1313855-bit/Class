package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 1.先連線-->jdbc-->database
 * 2.串接Connection-->preparedStatement
 * 3.preparedStatement撰寫sql讀取的資料-->交給 resultSet
 * 4.ResultSet取資料值-->轉給ArrayList
 * 5.for-each
 * 
 */

public class Read {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/company";
		String user="root";
		String password="1234";
		
		String sql="select * from porder";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			//用while把全部資料撈出(rs.next():boolean)
			while(rs.next()) {
				System.out.println("id:"+rs.getInt("id")+
						"\t名:"+rs.getString("name")+
						"\t尺:"+rs.getInt("ruler")+
						"\t筆:"+rs.getInt("pen")+
						"\t總額:"+rs.getInt("sum"));
			}
			
			/*
			rs.next();
			System.out.println("id:"+rs.getInt("id"));
			rs.next();
			System.out.println("id:"+rs.getInt("id"));
			*/
			
		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}
		

	}

}
