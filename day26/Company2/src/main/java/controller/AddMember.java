package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Member;
import service.MemberService;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private JTextField mobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
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
	public AddMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("暱稱:");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel.setBounds(81, 53, 52, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("用戶名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(81, 83, 52, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("密碼:");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(81, 113, 52, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("地址:");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(81, 143, 52, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("電話:");
		lblNewLabel_4.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(81, 173, 52, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("市話:");
		lblNewLabel_5.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(81, 203, 52, 20);
		contentPane.add(lblNewLabel_5);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(141, 52, 115, 21);
		contentPane.add(name);

		username = new JTextField();
		username.setColumns(10);
		username.setBounds(141, 82, 115, 21);
		contentPane.add(username);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(141, 112, 115, 21);
		contentPane.add(password);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(141, 142, 115, 21);
		contentPane.add(address);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(141, 172, 115, 21);
		contentPane.add(phone);

		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(141, 202, 115, 21);
		contentPane.add(mobile);

		JLabel lblNewLabel_6 = new JLabel("會員註冊");
		lblNewLabel_6.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(113, 15, 87, 20);
		contentPane.add(lblNewLabel_6);

		/*************** event ***************/

		MemberService msi = new MemberServiceImpl();

		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username = username.getText();
				if (msi.check_username(Username)) {
					AddMemberError addmembererror = new AddMemberError();
					addmembererror.setVisible(true);
					dispose();
				} else {
					String Name = name.getText();
					String Password = password.getText();
					String Address = address.getText();
					String Phone = phone.getText();
					String Mobile = mobile.getText();

					Member member = new Member(Name,Username,Password,Address,Phone,Mobile);
					
					msi.create_member(member);
					
					AddMemberSuccess addmembersuccess=new AddMemberSuccess();
					addmembersuccess.setVisible(true);
					dispose();
				}

			}
		});
		btnNewButton.setBounds(113, 242, 87, 23);
		contentPane.add(btnNewButton);

	}

}
