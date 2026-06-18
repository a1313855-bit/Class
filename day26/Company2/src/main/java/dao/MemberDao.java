package dao;

import entity.Member;

public interface MemberDao {
	//create
	void insert(Member member);
	
	//read
	//查詢帳號密碼
	Member select_by_username_and_password(String username,String password);
	//查詢帳號
	Member select_by_username(String username);
	
	//update
	
	
	//delete
	
	
}
