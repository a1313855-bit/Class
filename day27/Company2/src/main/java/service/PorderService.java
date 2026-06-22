package service;

import entity.Porder;

public interface PorderService {
	//Confirm新增
	void add_porder(Porder porder);
	
	//SelectUI
	String find_all_Porder();
	String find_by_name(String name);
	String find_by_sum(int start,int end);
}
