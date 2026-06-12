package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Student;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StudentUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;
	private JTextField math;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentUI frame = new StudentUI();
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
	public StudentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(61, 10, 306, 44);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新增");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel.setBounds(122, 10, 46, 24);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(61, 64, 306, 168);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1.setBounds(39, 18, 46, 18);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("國文:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(39, 46, 46, 17);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("英文:");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(39, 73, 46, 18);
		panel_1.add(lblNewLabel_1_2);
		
		name = new JTextField();
		name.setBounds(116, 18, 96, 21);
		panel_1.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.setBounds(116, 48, 96, 21);
		panel_1.add(chi);
		chi.setColumns(10);
		
		eng = new JTextField();
		eng.setBounds(116, 73, 96, 21);
		panel_1.add(eng);
		eng.setColumns(10);
		
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("數學:");
		lblNewLabel_1_2_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(39, 101, 46, 18);
		panel_1.add(lblNewLabel_1_2_1);
		
		math = new JTextField();
		math.setBounds(116, 104, 96, 21);
		panel_1.add(math);
		math.setColumns(10);
		
		
		/*====================event=====================*/
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			/*
			 * 1.擷取name,chi,eng,math
			 * 2.chi,eng,math-->轉int
			 * 3.new Student(name,chi,eng,math);
			 * 4.將 Student存成物件檔
			 * 5.切換頁面-->StudentScore-->讀取物件檔
			 * 
			 */
				
				String Name=name.getText();
				int Chi=Integer.parseInt(chi.getText());
				int Eng=Integer.parseInt(eng.getText());
				int Math=Integer.parseInt(math.getText());
			
				Student s=new Student(Name,Chi,Eng,Math);
				
				try {
					FileOutputStream fos=new FileOutputStream("Student.txt");
					ObjectOutputStream oos=new ObjectOutputStream(fos);
					oos.writeObject(s);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				StudentScore score=new StudentScore();
				score.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton.setBounds(85, 135, 142, 23);
		panel_1.add(btnNewButton);

	}

}
