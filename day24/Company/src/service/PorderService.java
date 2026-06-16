package service;

public interface PorderService {
	//create
	void addPorder(String name,int ruler,int pen);
	
	//read
	String findAllPorder();
	
	//update
	void updatePorder(int id,String name);
	
	//delete
	void deleteById(int id);
	
}
