package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ProderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements ProderDao{

	//測試
	public static void main(String[] args) {
		//create
		//new PorderDaoImpl().add("abc",20,30);
		
		//read
		System.out.println(new PorderDaoImpl().selectAll());
	}

	//使用DbConnection寫好的JDBC連線方法
	Connection conn=DbConnection.getDb();
	
	//create
	@Override
	public void add(String name, int ruler, int pen) {
		//SQL方法"注意:"這裡要寫完整的欄位，不只有要填進去的資料
		String sql="insert into porder(name,ruler,pen,sum) values(?,?,?,?)";
		//把建構式套進來，引數寫上要填入的內容
		Porder porder=new Porder(name,ruler,pen);
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, porder.getName());
			ps.setInt(2, porder.getRuler());
			ps.setInt(3, porder.getPen());
			ps.setInt(4, porder.getSum());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//read
	@Override
	public String selectAll() {
		//SQL方法
		String sql="select * from porder";
		//設置一個return 變數
		String showAll="";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				showAll+="id"+rs.getInt("id")+
						"\t名:"+rs.getString("name")+
						"\t尺:"+rs.getInt("ruler")+
						"\t筆:"+rs.getInt("pen")+
						"\t總額:"+rs.getInt("sum")+"\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return showAll;
	}

}
