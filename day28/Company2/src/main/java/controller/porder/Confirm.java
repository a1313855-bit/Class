package controller.porder;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Member;
import entity.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Confirm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm frame = new Confirm();
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
	public Confirm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);			
		contentPane.setLayout(null);
		
		Member member=(Member) Tool.read_file("member.txt");
		Porder porder=(Porder) Tool.read_file("porder.txt");
		
		JLabel title = new JLabel("");
		title.setFont(new Font("新細明體", Font.PLAIN, 20));
		title.setBounds(39, 10, 205, 24);
		contentPane.add(title);
		
		String s=member.getName()+"	這是你的細目";
		title.setText(s);
		
		JTextArea show_all = new JTextArea();
		show_all.setBounds(10, 40, 264, 181);
		contentPane.add(show_all);
		
		String t="A:"+porder.getA()+
				"\nB:"+porder.getB()+
				"\nC:"+porder.getC()+
				"\n金額:"+porder.getSum();
		
		show_all.setText(t);
		
		/*************** event ***************/
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PorderServiceImpl().add_porder(porder);
				Finish finish=new Finish();
				finish.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(97, 231, 87, 23);
		contentPane.add(btnNewButton);
		
		

	}
}
