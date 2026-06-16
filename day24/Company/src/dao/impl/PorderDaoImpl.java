package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ProderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements ProderDao {

	// 測試
	public static void main(String[] args) {
		///// create測試 /////
		// new PorderDaoImpl().add("abc",20,30);

		// inject 注入的方式create測試
		// Porder porder = new Porder("abc555", 3, 4);
		// new PorderDaoImpl().add(porder);

		// 也可以寫成一行
		// new PorderDaoImpl().add(new Porder("aqa", 6, 7));

		///// read測試 /////
		// System.out.println(new PorderDaoImpl().selectAll());

		// read測試 (一筆訂單)
		// Porder p = new PorderDaoImpl().selectById(2);
		// System.out.println(p + "\t" + p.getId() + "\t" + p.getName());

		///// update測試 /////
		// 先找出要修改的其中一筆
		Porder p = new PorderDaoImpl().selectById(9);
		// 寫入修改的值
		// p.setName("fff");
		// p.setRuler(1);
		// p.setPen(1);

		// 使用方法修改
		// new PorderDaoImpl().update(p);

		///// delete測試 /////
		//new PorderDaoImpl().delete(12);
	}

	// 使用DbConnection寫好的JDBC連線方法
	Connection conn = DbConnection.getDb();

	// create (inject)注入寫法
	@Override
	public void add(Porder porder) {
		String sql = "insert into porder(name,ruler,pen,sum) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
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

	// create
	@Override
	public void add(String name, int ruler, int pen) {
		// SQL方法"注意:"這裡要寫完整的欄位，不只有要填進去的資料
		String sql = "insert into porder(name,ruler,pen,sum) values(?,?,?,?)";
		// 把建構式套進來，引數寫上要填入的內容
		Porder porder = new Porder(name, ruler, pen);
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, porder.getName());
			ps.setInt(2, porder.getRuler());
			ps.setInt(3, porder.getPen());
			ps.setInt(4, porder.getSum());

			//新增要記得打這串(更新SQL)
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// read
	@Override
	public String selectAll() {
		// SQL方法
		String sql = "select * from porder";
		// 設置一個return 變數
		String showAll = "";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				showAll += "id:" + rs.getInt("id") + "\t名:" + rs.getString("name") + "\t尺:" + rs.getInt("ruler")
						+ "\t筆:" + rs.getInt("pen") + "\t總額:" + rs.getInt("sum") + "\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return showAll;
	}

	// read(一筆)
	@Override
	public Porder selectById(int id) {
		// 設置一個return 變數
		Porder porder = null;
		// SQL方法
		String sql = "select * from porder where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				porder = new Porder();

				porder.setId(rs.getInt("id"));
				porder.setName(rs.getString("name"));
				porder.setRuler(rs.getInt("ruler"));
				porder.setPen(rs.getInt("pen"));
				porder.setSum(rs.getInt("sum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return porder;
	}

	// update
	@Override
	public void update(Porder porder) {
		// SQL方法
		String sql = "update porder set name=?,ruler=?,pen=?,sum=? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, porder.getName());
			ps.setInt(2, porder.getRuler());
			ps.setInt(3, porder.getPen());
			ps.setInt(4, porder.getSum());
			ps.setInt(5, porder.getId());

			//修改要記得打這串(更新SQL)
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// delete
	@Override
	public void delete(int id) {
		// SQL方法
		String sql = "delete from porder where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			//刪除要記得打這串(更新SQL)
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
