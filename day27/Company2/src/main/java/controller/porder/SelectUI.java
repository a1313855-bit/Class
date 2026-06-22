package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.PorderService;
import service.impl.PorderServiceImpl;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class SelectUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField money_start;
	private JTextField money_end;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectUI frame = new SelectUI();
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
	public SelectUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 264, 90);
		contentPane.add(scrollPane);

		JTextArea all_show = new JTextArea();
		scrollPane.setViewportView(all_show);

		JTextArea name_show = new JTextArea();
		name_show.setBounds(10, 176, 264, 90);
		contentPane.add(name_show);

		JTextArea sum_show = new JTextArea();
		sum_show.setBounds(10, 309, 264, 90);
		contentPane.add(sum_show);

		JLabel lblNewLabel = new JLabel("客戶名:");
		lblNewLabel.setBounds(69, 143, 46, 23);
		contentPane.add(lblNewLabel);

		name = new JTextField();
		name.setBounds(112, 143, 96, 21);
		contentPane.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("金額:");
		lblNewLabel_1.setBounds(69, 276, 27, 23);
		contentPane.add(lblNewLabel_1);

		money_start = new JTextField();
		money_start.setColumns(10);
		money_start.setBounds(100, 276, 78, 21);
		contentPane.add(money_start);

		money_end = new JTextField();
		money_end.setColumns(10);
		money_end.setBounds(196, 276, 78, 21);
		contentPane.add(money_end);

		JLabel lblNewLabel_1_1 = new JLabel("~");
		lblNewLabel_1_1.setBounds(183, 276, 6, 23);
		contentPane.add(lblNewLabel_1_1);

		/*************** event ***************/

		PorderService psi=new PorderServiceImpl();
		
		//查詢(全部)
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 11));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				all_show.setText(psi.find_all_Porder());
			}
		});
		btnNewButton.setBounds(10, 10, 57, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 11));
		btnNewButton_1.setBounds(10, 143, 57, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("查詢");
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 11));
		btnNewButton_2.setBounds(10, 276, 57, 23);
		contentPane.add(btnNewButton_2);
	}
}
