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

public class DeleteUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUI frame = new DeleteUI();
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
	public DeleteUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 262, 143);
		contentPane.add(scrollPane);

		JTextArea all_show = new JTextArea();
		scrollPane.setViewportView(all_show);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 201, 15, 15);
		contentPane.add(lblNewLabel);

		id = new JTextField();
		id.setColumns(10);
		id.setBounds(30, 196, 47, 21);
		contentPane.add(id);

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

		// 刪除(查詢ID)
		JButton btnNewButton_1 = new JButton("刪除");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Id=Integer.parseInt(id.getText());
				
				psi.delete_by_id(Id);
				
				id.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 11));
		btnNewButton_1.setBounds(202, 195, 70, 23);
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
