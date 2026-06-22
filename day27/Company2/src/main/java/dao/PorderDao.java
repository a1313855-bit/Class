package dao;

import java.util.List;

import entity.Porder;

public interface PorderDao {
	//create
	void insert(Porder porder);
	
	//read
	List<Porder> select_all();
	List<Porder> select_by_id(int id);
	List<Porder> select_by_name(String name);
	List<Porder> select_by_sum(int start,int end);
	
	//update
	void updete(Porder porder);
	
	//delete
	void delete(int id);
	
}
