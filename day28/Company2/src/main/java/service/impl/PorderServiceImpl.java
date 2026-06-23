package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.PorderDao;
import dao.impl.PorderDaoImpl;
import entity.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService {

	public static void main(String[] args) {
		// System.out.println(new PorderServiceImpl().find_all_Porder());

		// System.out.println(new PorderServiceImpl().find_by_name("Mr.C"));

		// System.out.println(new PorderServiceImpl().find_by_sum(300, 500));

		// new PorderServiceImpl().change_porder(1,A2, 2, 3, 4);

		// new PorderServiceImpl().delete_by_id(2);

	}

	PorderDao pdi = new PorderDaoImpl();

	// ===============Confirm新增===============//

	@Override
	public void add_porder(Porder porder) {
		if (porder != null) {
			pdi.insert(porder);
		}
	}

	// ===============SelectUI(查詢全部)===============//

	@Override
	public String find_all_Porder() {
		List<Porder> l = pdi.select_all();
		String show = "";
		int count = 0;
		int sum = 0;
		for (Porder p : l) {
			count++;
			sum += p.getSum();
			show += "ID:" + p.getId() + "\t名稱:" + p.getName() + "\t桌號:" + p.getDesk() + "\tA:" + p.getA() + "\tB:"
					+ p.getB() + "\tC:" + p.getC() + "\t金額:" + p.getSum() + "\n";
		}

		show += "\n共:" + count + "筆" + "\n總金額:" + sum + "元";

		return show;
	}

	// ===============SelectUI(查詢客戶名)===============//

	@Override
	public String find_by_name(String name) {
		List<Porder> l = pdi.select_by_name(name);
		String show = "";
		int count = 0;
		int sum = 0;
		if (l.size() != 0) {
			for (Porder p : l) {
				count++;
				sum += p.getSum();
				show += "ID:" + p.getId() + "\t名稱:" + p.getName() + "\t桌號:" + p.getDesk() + "\tA:" + p.getA() + "\tB:"
						+ p.getB() + "\tC:" + p.getC() + "\t金額:" + p.getSum() + "\n";
			}
			show += "\n共:" + count + "筆" + "\n總金額:" + sum + "元";
		} else {
			show = "此會員 無訂單";
		}
		return show;
	}

	// ===============SelectUI(查詢金額區間)===============//

	@Override
	public String find_by_sum(int start, int end) {
		/*
		 * 1.檢查start,end不能是負數 2.檢查此區間是否有訂單 3.輸出資料
		 */
		String show = "";
		if (start >= 0 && end >= 0) {
			List<Porder> l = pdi.select_by_sum(start, end);
			int count = 0;
			int sum = 0;
			if (l.size() != 0) {
				for (Porder p : l) {
					count++;
					sum += p.getSum();
					show += "ID:" + p.getId() + "\t名稱:" + p.getName() + "\t桌號:" + p.getDesk() + "\tA:" + p.getA()
							+ "\tB:" + p.getB() + "\tC:" + p.getC() + "\t金額:" + p.getSum() + "\n";
				}
				show += "\n共:" + count + "筆" + "\n總金額:" + sum + "元";
			} else {
				show = "此金額區間 無訂單";
			}
		} else {
			show = "金額必須>=0";
		}
		return show;
	}

	// ===============UpdateUI===============//
	@Override
	public void change_porder(int id, String desk, int a, int b, int c) {
		List<Porder> l = pdi.select_by_id(id);
		if (l.size() != 0) {
			Porder porder = l.get(0);
			porder.setDesk(desk);
			porder.setA(a);
			porder.setB(b);
			porder.setC(c);
			pdi.updete(porder);
		}

	}

	// ===============DeleteUI===============//
	@Override
	public void delete_by_id(int id) {
		List<Porder> l = pdi.select_by_id(id);
		if (l.isEmpty() != true) {
			pdi.delete(id);
		}

	}

	// ===============PorderTableUI===============//
	@Override
	public DefaultTableModel findAllPorderTable() {
		List<Porder> l = pdi.select_all();

		DefaultTableModel model = new DefaultTableModel();
		// 建立欄位標題
		model.addColumn("編號");
		model.addColumn("客戶");
		model.addColumn("桌號");
		model.addColumn("A餐");
		model.addColumn("B餐");
		model.addColumn("C餐");
		model.addColumn("金額");

		for (Porder p : l) {
			// 將每一筆資料建立一維陣列
			Object[] row = new Object[] { p.getId(), p.getName(), p.getDesk(), p.getA(), p.getB(), p.getC(),
					p.getSum() };

			// 將此陣列放入table中
			model.addRow(row);
		}

		return model;
	}

}
