package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import model.Member;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public MainFrame(Member loginMember) {
        setTitle("簡易購物系統 - " + loginMember.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 980, 680);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        JLabel userLabel = new JLabel("目前登入：" + loginMember.getName() + " / " + loginMember.getRole());
        userLabel.setBorder(new EmptyBorder(10, 12, 10, 12));
        getContentPane().add(userLabel, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("會員管理 CRUD", new MemberPanel());
        tabbedPane.addTab("購物管理 CRUD", new ShoppingPanel(loginMember));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
}
