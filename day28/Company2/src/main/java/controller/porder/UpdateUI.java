package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.PorderService;
import service.impl.PorderServiceImpl;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class UpdateUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField desk;
	private JTextField a;
	private JTextField b;
	private JTextField c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUI frame = new UpdateUI();
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
	public UpdateUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 262, 116);
		contentPane.add(scrollPane);

		JTextArea all_show = new JTextArea();
		scrollPane.setViewportView(all_show);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 175, 15, 15);
		contentPane.add(lblNewLabel);

		id = new JTextField();
		id.setBounds(30, 170, 47, 21);
		contentPane.add(id);
		id.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("桌號:");
		lblNewLabel_1.setBounds(87, 175, 33, 15);
		contentPane.add(lblNewLabel_1);

		desk = new JTextField();
		desk.setColumns(10);
		desk.setBounds(118, 170, 47, 21);
		contentPane.add(desk);

		JLabel lblA = new JLabel("A:");
		lblA.setBounds(10, 203, 15, 15);
		contentPane.add(lblA);

		a = new JTextField();
		a.setColumns(10);
		a.setBounds(30, 198, 47, 21);
		contentPane.add(a);

		JLabel lblB = new JLabel("B:");
		lblB.setBounds(97, 203, 15, 15);
		contentPane.add(lblB);

		b = new JTextField();
		b.setColumns(10);
		b.setBounds(117, 198, 47, 21);
		contentPane.add(b);

		JLabel lblV = new JLabel("C:");
		lblV.setBounds(190, 203, 15, 15);
		contentPane.add(lblV);

		c = new JTextField();
		c.setColumns(10);
		c.setBounds(210, 198, 47, 21);
		contentPane.add(c);

		/*************** event ***************/

		PorderService psi = new PorderServiceImpl();

		// 查詢全部
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				all_show.setText(psi.find_all_Porder());
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 10, 57, 23);
		contentPane.add(btnNewButton);

		// 修改(查詢ID後 修改A,B,C,桌號)
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Id=Integer.parseInt(id.getText());
				String Desk=desk.getText();
				int A=Integer.parseInt(a.getText());
				int B=Integer.parseInt(b.getText());
				int C=Integer.parseInt(c.getText());
				
				psi.change_porder(Id, Desk, A, B, C);
				
				id.setText("");
				desk.setText("");
				a.setText("");
				b.setText("");
				c.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 11));
		btnNewButton_1.setBounds(202, 169, 70, 23);
		contentPane.add(btnNewButton_1);

		// 回管理頁面
		JButton btnNewButton_3 = new JButton("回管理頁面");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderUI porder_ui = new PorderUI();
				porder_ui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 228, 108, 23);
		contentPane.add(btnNewButton_3);

	}
}
