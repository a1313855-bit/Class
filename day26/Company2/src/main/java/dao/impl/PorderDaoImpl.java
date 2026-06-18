package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import entity.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao {

	public static void main(String[] args) {
		// 新增測試
		// Porder porder=new Porder("Mr.D", "B1", 2, 2, 2);
		// new PorderDaoImpl().insert(porder);

		// 查詢全部
		// System.out.println(new PorderDaoImpl().select_all());

		/* 利用ArrayList可以做到加總
		List<Porder> l = new PorderDaoImpl().select_all();
		Porder p = l.get(0);
		System.out.println(p.getId() + "\t" + p.getName());
		int sum = 0;
		for (Porder o : l) {
			sum = sum + o.getSum();
		}
		System.out.println("合計:" + sum);
		*/
		
		//查詢(ID一筆)
		//System.out.println(new PorderDaoImpl().select_by_id(1));
		
		//.size();-->有資料會寫1 無資料會顯示0
		//.isEmpty();-->有資料會顯示false 無資料會顯示true
		
		//修改
		//Porder p=new PorderDaoImpl().select_by_id(1).get(0);
		//p.setA(5);
		
		//new PorderDaoImpl().updete(p);
		
		
		//刪除
		//new PorderDaoImpl().delete(4);
		
	}

	Connection conn = DbConnection.getDb();

	// ====================新增====================//

	@Override
	public void insert(Porder porder) {
		String sql = "insert into porder(name,desk,a,b,c,sum) " + "values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, porder.getName());
			ps.setString(2, porder.getDesk());
			ps.setInt(3, porder.getA());
			ps.setInt(4, porder.getB());
			ps.setInt(5, porder.getC());
			ps.setInt(6, porder.getSum());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ====================查詢(全部)====================//

	@Override
	public List<Porder> select_all() {
		String sql = "select * from porder";
		List<Porder> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Porder porder = new Porder();
				porder.setId(rs.getInt("id"));
				porder.setName(rs.getString("name"));
				porder.setDesk(rs.getString("desk"));
				porder.setA(rs.getInt("a"));
				porder.setB(rs.getInt("b"));
				porder.setC(rs.getInt("c"));
				porder.setSum(rs.getInt("sum"));

				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	// ====================查詢(ID單筆)====================//

	@Override
	public List<Porder> select_by_id(int id) {
		String sql="select * from porder where id=?";
		List<Porder> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Porder porder=new Porder();
				porder.setId(rs.getInt("id"));
				porder.setName(rs.getString("name"));
				porder.setDesk(rs.getString("desk"));
				porder.setA(rs.getInt("a"));
				porder.setB(rs.getInt("b"));
				porder.setC(rs.getInt("c"));
				porder.setSum(rs.getInt("sum"));
				
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	// ====================修正====================//
	@Override
	public void updete(Porder porder) {
		String sql="update porder set name=?,desk=?,a=?,b=?,c=?,sum=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, porder.getName());
			ps.setString(2, porder.getDesk());
			ps.setInt(3, porder.getA());
			ps.setInt(4, porder.getB());
			ps.setInt(5, porder.getC());
			ps.setInt(6, porder.getSum());
			ps.setInt(7, porder.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ====================刪除====================//
	@Override
	public void delete(int id) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
