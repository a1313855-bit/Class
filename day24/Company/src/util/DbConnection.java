package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	
	//測試
	public static void main(String[] args) {

		System.out.println(DbConnection.getDb());
		
		/*
		 * //宣告變數 url=主機 user=用戶名 password=密碼 //主機位置jdbc:mysql://->主機位置/Schema->資料夾
		 * String url="jdbc:mysql://localhost:3306/company"; String user="root"; String
		 * password="1234";
		 * 
		 * //新增(SQL語法) String
		 * Sql="insert into porder(name,ruler,pen,sum) values('teacher',1,2,150)";
		 * 
		 * //檢測是否有安裝Driver(是否有授權) try { //Driver位置
		 * Class.forName("com.mysql.cj.jdbc.Driver"); //輸入主機，用戶名，密碼->轉成Connection
		 * Connection conn=DriverManager.getConnection(url,user,password);
		 * //Connection->轉成Statement Statement st=conn.createStatement();
		 * st.executeUpdate(Sql);
		 * 
		 * 
		 * }catch(ClassNotFoundException e){ System.out.println("no Driver");
		 * e.printStackTrace(); } catch (SQLException e) {
		 * System.out.println("no connection"); e.printStackTrace(); } /*匯入driver(jar檔)
		 * 1.Driver下載完，選擇專案右鍵 2.Build Path->Configure Build Path 3.Libraries->Class Path
		 * 4.Add External JAR...
		 */

	}
	
	//方法
	public static Connection getDb() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/company";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

}
