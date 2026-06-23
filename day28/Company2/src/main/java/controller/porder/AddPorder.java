package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Member;
import entity.Porder;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField desk;
	private JTextField c;
	private JTextField b;
	private JTextField a;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorder frame = new AddPorder();
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
	public AddPorder() {
		
		Member member=(Member) Tool.read_file("member.txt");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("");
		title.setFont(new Font("新細明體", Font.PLAIN, 20));
		title.setBounds(39, 21, 185, 37);
		contentPane.add(title);
		
		title.setText(member.getName()+"	請輸入產品數量");
		
		JLabel lblNewLabel = new JLabel("A:");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel.setBounds(75, 78, 36, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblB = new JLabel("B:");
		lblB.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblB.setBounds(75, 103, 36, 15);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C:");
		lblC.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblC.setBounds(75, 128, 36, 15);
		contentPane.add(lblC);
		
		JLabel lblNewLabel_3 = new JLabel("桌號:");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(55, 154, 36, 20);
		contentPane.add(lblNewLabel_3);
		
		desk = new JTextField();
		desk.setBounds(101, 153, 96, 21);
		contentPane.add(desk);
		desk.setColumns(10);
		
		c = new JTextField();
		c.setColumns(10);
		c.setBounds(101, 125, 96, 21);
		contentPane.add(c);
		
		b = new JTextField();
		b.setColumns(10);
		b.setBounds(101, 100, 96, 21);
		contentPane.add(b);
		
		a = new JTextField();
		a.setColumns(10);
		a.setBounds(101, 75, 96, 21);
		contentPane.add(a);
		
		/*************** event ***************/
		
		btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int A=Integer.parseInt(a.getText());
				int B=Integer.parseInt(b.getText());
				int C=Integer.parseInt(c.getText());
				String Desk=desk.getText();
				
				Porder porder=new Porder(member.getName(),Desk,A,B,C);
				
				Tool.save_file("porder.txt", porder);
				
				Confirm confirm=new Confirm();
				confirm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(102, 206, 87, 23);
		contentPane.add(btnNewButton);

	}
}
