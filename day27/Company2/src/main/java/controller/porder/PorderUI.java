package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Member;
import util.Tool;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderUI frame = new PorderUI();
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
	public PorderUI() {
		
		Member member=(Member) Tool.read_file("member.txt");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title = new JLabel("");
		title.setFont(new Font("新細明體", Font.PLAIN, 20));
		title.setBounds(39, 10, 185, 37);
		contentPane.add(title);
		
		title.setText(member.getName()+"\t請選擇功能");

		/*************** event ***************/

		JButton btnNewButton = new JButton("刪除");
		btnNewButton.setBounds(73, 214, 87, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setBounds(73, 169, 87, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("查詢");
		btnNewButton_2.setBounds(73, 124, 87, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("新增");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorder add_porder=new AddPorder();
				add_porder.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(73, 79, 87, 23);
		contentPane.add(btnNewButton_3);

	}
}
