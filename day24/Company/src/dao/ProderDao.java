package dao;

import model.Porder;

public interface ProderDao {
	//create
	void add(String name,int ruler,int pen);
	//inject 注入 (物件)
	void add(Porder porder);
	
	//read
	String selectAll();
	Porder selectById(int id);
	
	//updata
	void update(Porder porder);
	
	//delete
	void delete(int id);
	
}
