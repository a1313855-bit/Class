package service;

import javax.swing.table.DefaultTableModel;

import entity.Porder;

public interface PorderService {
	//Confirm新增
	void add_porder(Porder porder);
	
	//SelectUI
	String find_all_Porder();
	String find_by_name(String name);
	String find_by_sum(int start,int end);
	
	//UpdateUI
	void change_porder(int id,String desk,int a,int b,int c);
	
	//DeleteUI
	void delete_by_id(int id);
	
	//PorderTableUI
	DefaultTableModel findAllPorderTable();
	
}
