package service.impl;

import dao.impl.PorderDaoImpl;
import service.PorderService;

public class PorderServiceImpl implements PorderService{

	//測試
	public static void main(String[] args) {
		new PorderServiceImpl().addPorder("a",-5,10);

	}
	
	//使用dao資料夾裡，已經設定好的方法
	PorderDaoImpl pdi=new PorderDaoImpl();

	@Override
	public void addPorder(String name, int ruler, int pen) {
		//新增判斷，除錯方法
		if(ruler>=0 && pen>=0) {
			pdi.add(name, ruler, pen);
		}else {
			System.out.println("尺與筆需>=0");
		}
		
	}

	@Override
	public String findAllPorder() {
		// TODO Auto-generated method stub
		return pdi.selectAll();
	}

}
