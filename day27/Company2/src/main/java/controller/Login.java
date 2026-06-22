package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Member;
import service.MemberService;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("用戶名:");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel.setBounds(44, 53, 52, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("密碼:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(44, 91, 52, 20);
		contentPane.add(lblNewLabel_1);

		username = new JTextField();
		username.setBounds(106, 52, 115, 21);
		contentPane.add(username);
		username.setColumns(10);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(106, 91, 115, 21);
		contentPane.add(password);

		JLabel lblNewLabel_2 = new JLabel("會員登入");
		lblNewLabel_2.setBounds(95, 15, 80, 20);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 20));

		/*************** event ***************/

		MemberService msi = new MemberServiceImpl();

		// 登入
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username = username.getText();
				String Password = password.getText();

				Member member = msi.login(Username, Password);

				if (member != null) {
					Tool.save_file("member.txt", member);
					
					LoginSuccess loginsuccess = new LoginSuccess();
					loginsuccess.setVisible(true);
					dispose();
				} else {
					LoginError loginerror = new LoginError();
					loginerror.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(44, 132, 87, 23);
		contentPane.add(btnNewButton);

		// 註冊
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMember addmember = new AddMember();
				addmember.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(158, 132, 87, 23);
		contentPane.add(btnNewButton_1);

	}
}
