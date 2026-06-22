package service.impl;

import dao.MemberDao;
import dao.impl.MemberDaoImpl;
import entity.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{

	public static void main(String[] args) {
		//登入測試
		//System.out.println(new MemberServiceImpl().login("reo","1234"));
		
		//註冊測試
		//new MemberServiceImpl().create_member(new Member("fox","ninnin","1234","新北市","0900000001","001"));
		
		//帳號重複測試
		//System.out.println(new MemberServiceImpl().check_username("reo"));

	}

	MemberDao mdi=new MemberDaoImpl();
	
	//===============登入===============//
	@Override
	public Member login(String username, String password) {
		return mdi.select_by_username_and_password(username, password);
	}

	//===============註冊===============//
	@Override
	public void create_member(Member member) {
		mdi.insert(member);		
	}

	//===============檢查帳號===============//
	@Override
	public boolean check_username(String username) {
		boolean x=false;
		
		Member member=mdi.select_by_username(username);
		
		//如果member不是null(有帳號) 就會顯示有過此帳號
		if(member!=null) {
			x=true;
		}
		
		return x;
	}

}
