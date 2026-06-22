package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import dao.impl.PorderDaoImpl;
import entity.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService{

	public static void main(String[] args) {
		System.out.println(new PorderServiceImpl().find_all_Porder());

	}
	
	PorderDao pdi=new PorderDaoImpl();

	//===============Confirm新增===============//
	
	@Override
	public void add_porder(Porder porder) {
		if(porder!=null) {
			pdi.insert(porder);
		}
	}

	//===============SelectUI(查詢全部)===============//
	
	@Override
	public String find_all_Porder() {
		List<Porder> l=pdi.select_all();
		String show="";
		int count=0;
		int sum=0;
		for(Porder p:l) {
			count++;
			sum+=p.getSum();
			show+="ID:"+p.getId()+
					"\t名稱:"+p.getName()+
					"\t桌號:"+p.getDesk()+
					"\tA:"+p.getA()+
					"\tB:"+p.getB()+
					"\tC:"+p.getC()+
					"\t金額:"+p.getSum()+"\n";
		}
		
		show+="共:"+count+"筆"+
		"\n總金額:"+sum+"元";

		return show;
	}

	//===============SelectUI(查詢客戶名)===============//
	
	@Override
	public String find_by_name(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	//===============SelectUI(查詢金額區間)===============//
	
	@Override
	public String find_by_sum(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

}
