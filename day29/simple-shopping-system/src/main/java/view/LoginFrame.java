package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import model.Member;

public class LoginFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private final LoginController loginController = new LoginController();
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("簡易購物系統 - 會員登入");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 240);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);

        JLabel titleLabel = new JLabel("Simple Shopping System", JLabel.CENTER);
        contentPane.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        contentPane.add(formPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("帳號"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField("admin", 18);
        formPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("密碼"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField("admin123", 18);
        formPanel.add(passwordField, gbc);

        JButton loginButton = new JButton("登入");
        contentPane.add(loginButton, BorderLayout.SOUTH);
        loginButton.addActionListener(e -> doLogin());
    }

    private void doLogin() {
        try {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            Member loginMember = loginController.login(username, password);
            MainFrame mainFrame = new MainFrame(loginMember);
            mainFrame.setVisible(true);
            dispose();
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "登入失敗", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
