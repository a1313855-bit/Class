package service.impl;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService {

	// 測試
	public static void main(String[] args) {
		///// create測試 /////
		// new PorderServiceImpl().addPorder("a", -5, 10);

		///// update測試 /////
		//new PorderServiceImpl().updatePorder(2, "teacher");
		
		///// delete測試 /////
		//new PorderServiceImpl().deleteById(13);

	}

	// 使用dao資料夾裡，已經設定好的方法
	PorderDaoImpl pdi = new PorderDaoImpl();

	///// create /////
	@Override
	public void addPorder(String name, int ruler, int pen) {
		// 新增判斷，除錯方法
		if (ruler >= 0 && pen >= 0) {
			pdi.add(name, ruler, pen);
		} else {
			System.out.println("尺與筆需>=0");
		}

	}

	///// read /////
	@Override
	public String findAllPorder() {
		// TODO Auto-generated method stub
		return pdi.selectAll();
	}

	///// update /////
	@Override
	public void updatePorder(int id, String name) {
		/*
		 * 1.判斷id是否存在 2.有-->修改
		 */
		Porder porder = pdi.selectById(id);
		if (porder != null) {
			porder.setName(name);

			pdi.update(porder);
		} else {
			System.out.println("無此ID");
		}
	}

	///// delete /////
	@Override
	public void deleteById(int id) {
		/*
		 * 1.判斷id是否存在 2.有-->刪除
		 */
		Porder porder = pdi.selectById(id);
		if (porder != null) {
			pdi.delete(id);
		} else {
			System.out.println("無此ID");
		}
	}

}
