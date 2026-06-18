package dao;

import java.util.List;

import entity.Porder;

public interface PorderDao {
	//create
	void insert(Porder porder);
	
	//read
	List<Porder> select_all();
	List<Porder> select_by_id(int id);
	
	//update
	void updete(Porder porder);
	
	//delete
	void delete(int id);
	
}
