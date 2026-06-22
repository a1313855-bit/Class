package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberDao;
import entity.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		
		//Member member=new Member("qwertyu","qwe","2345","台北市","0900200200","200");
		//new MemberDaoImpl().insert(member);
		
		//System.out.println(new MemberDaoImpl().select_by_username_and_password("reo","1234"));
		
		//System.out.println(new MemberDaoImpl().select_by_username("reo"));
	}

	Connection conn=DbConnection.getDb();
	
	@Override
	public void insert(Member member) {
		String Sql="insert into member(name,username,password,address,phone,mobile)"
				+ " values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUsername());
			ps.setString(3, member.getPassword());
			ps.setString(4, member.getAddress());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getMobile());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Member select_by_username_and_password(String username, String password) {
		Member member=null;
		String Sql="select * from Member where username=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setMobile(rs.getString("mobile"));				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public Member select_by_username(String username) {
		Member member=null;
		String Sql="select * from Member where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setMobile(rs.getString("mobile"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
}
