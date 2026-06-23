package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Member;
import entity.Porder;
import util.Tool;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class Finish extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finish frame = new Finish();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Finish() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Member member=(Member) Tool.read_file("member.txt");
		Porder porder=(Porder) Tool.read_file("porder.txt");
		
		JTextArea reporter = new JTextArea();
		reporter.setFont(new Font("Monospaced", Font.PLAIN, 14));
		reporter.setBounds(10, 10, 264, 212);
		contentPane.add(reporter);
		
		String show=member.getName()+"這是你的訂單細目"+
		"\n地址:"+member.getAddress()+
		"\n=============================="+
		"\n名稱:"+member.getName()+
		"\n電話:"+member.getPhone()+
		"\n=============================="+
		"\nA:"+porder.getA()+
		"\nB:"+porder.getB()+
		"\nC:"+porder.getC()+
		"\n金額:"+porder.getSum();
		
		reporter.setText(show);
		
		JButton btnNewButton = new JButton("回訂購頁");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderUI porder_ui=new PorderUI();
				porder_ui.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 228, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("列印");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					reporter.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(187, 228, 87, 23);
		contentPane.add(btnNewButton_1);

	}

}
