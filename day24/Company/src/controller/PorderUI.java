package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class PorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField ruler;
	private JTextField pen;
	private JTextField update_id;
	private JTextField delete_id;
	private JTextField update_name;

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

		PorderServiceImpl psi = new PorderServiceImpl();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(65, 10, 314, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("訂單管理系統");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(89, 6, 120, 30);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(15, 60, 400, 73);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 45, 20, 18);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("尺:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(151, 44, 20, 18);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("筆:");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(279, 44, 20, 18);
		panel_1.add(lblNewLabel_1_2);

		name = new JTextField();
		name.setBounds(41, 44, 100, 20);
		panel_1.add(name);
		name.setColumns(10);

		ruler = new JTextField();
		ruler.setColumns(10);
		ruler.setBounds(173, 43, 80, 20);
		panel_1.add(ruler);

		pen = new JTextField();
		pen.setColumns(10);
		pen.setBounds(302, 43, 80, 20);
		panel_1.add(pen);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(15, 143, 400, 192);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 380, 139);
		panel_1_1.add(scrollPane);

		JTextArea out = new JTextArea();
		scrollPane.setViewportView(out);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1_1.setBounds(15, 345, 400, 45);
		contentPane.add(panel_1_1_1);

		update_id = new JTextField();
		update_id.setColumns(10);
		update_id.setBounds(125, 10, 100, 20);
		panel_1_1_1.add(update_id);

		JLabel lblNewLabel_1_3 = new JLabel("ID:");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(104, 11, 20, 18);
		panel_1_1_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_2 = new JLabel("名:");
		lblNewLabel_1_3_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_3_2.setBounds(235, 11, 20, 18);
		panel_1_1_1.add(lblNewLabel_1_3_2);

		update_name = new JTextField();
		update_name.setColumns(10);
		update_name.setBounds(256, 10, 100, 20);
		panel_1_1_1.add(update_name);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1_1_1.setBounds(15, 400, 400, 45);
		contentPane.add(panel_1_1_1_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("ID:");
		lblNewLabel_1_3_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(104, 11, 20, 18);
		panel_1_1_1_1.add(lblNewLabel_1_3_1);

		delete_id = new JTextField();
		delete_id.setColumns(10);
		delete_id.setBounds(125, 10, 100, 20);
		panel_1_1_1_1.add(delete_id);

		/******************** event ********************/

		// create
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// 把JTextField()的數值叫過來
				String Name = name.getText();
				
				// JTextField()預設輸出為String 這兩個是int類型 要轉型
				int Ruler = Integer.parseInt(ruler.getText());
				int Pen = Integer.parseInt(pen.getText());

				// 使用service裡的方法
				psi.addPorder(Name, Ruler, Pen);

				// 點擊按鈕後成功把文字框內容消除
				name.setText("");
				ruler.setText("");
				pen.setText("");
			}
		});
		btnNewButton.setBounds(10, 10, 87, 23);
		panel_1.add(btnNewButton);

		// read
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// 使用service裡的方法
				out.setText(psi.findAllPorder());

			}
		});
		btnNewButton_1.setBounds(10, 10, 87, 23);
		panel_1_1.add(btnNewButton_1);

		// update
		JButton btnNewButton_1_1 = new JButton("修改");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// 把JTextField()的數值叫過來
				int ID = Integer.parseInt(update_id.getText());
				String Name = update_name.getText();

				// 使用service裡的方法
				psi.updatePorder(ID, Name);

				// 點擊按鈕後成功把文字框內容消除
				update_id.setText("");
				update_name.setText("");
			}
		});
		btnNewButton_1_1.setBounds(10, 10, 87, 23);
		panel_1_1_1.add(btnNewButton_1_1);

		// delete
		JButton btnNewButton_1_1_1 = new JButton("刪除");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// 把JTextField()的數值叫過來
				int ID = Integer.parseInt(delete_id.getText());

				// 使用service裡的方法
				psi.deleteById(ID);

				// 點擊按鈕後成功把文字框內容消除
				delete_id.setText("");
			}
		});
		btnNewButton_1_1_1.setBounds(10, 10, 87, 23);
		panel_1_1_1_1.add(btnNewButton_1_1_1);
	}
}
