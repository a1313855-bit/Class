package service;

import entity.Member;

public interface MemberService {
	//登入
	Member login(String username,String password);
	
	//註冊
	void create_member(Member member);
	
	//檢查帳號
	boolean check_username(String username);

}
