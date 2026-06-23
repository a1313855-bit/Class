package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderUI;
import entity.Member;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginSuccess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccess frame = new LoginSuccess();
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
	public LoginSuccess() {
		
		Member member=(Member) Tool.read_file("member.txt");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("登入成功");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(73, 35, 86, 31);
		contentPane.add(lblNewLabel);
		
		JLabel show_member = new JLabel("");
		show_member.setFont(new Font("新細明體", Font.PLAIN, 16));
		show_member.setBounds(52, 75, 118, 31);
		contentPane.add(show_member);
		
		show_member.setText(member.getName()+"\t歡迎你");
		
		/*************** event ***************/
		
		JButton btnNewButton = new JButton("進入購物");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderUI porder_ui=new PorderUI();
				porder_ui.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(73, 116, 87, 23);
		contentPane.add(btnNewButton);

	}
}
