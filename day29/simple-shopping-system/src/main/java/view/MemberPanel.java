package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.MemberController;
import model.Member;

public class MemberPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private final MemberController memberController = new MemberController();
    private final DefaultTableModel tableModel = new DefaultTableModel(
            new Object[] { "ID", "帳號", "密碼", "姓名", "Email", "電話", "角色" }, 0);
    private JTable table;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JComboBox<String> roleBox;
    private Integer selectedId;

    public MemberPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout(8, 8));
        add(rightPanel, BorderLayout.EAST);

        JPanel formPanel = new JPanel(new GridLayout(12, 1, 4, 4));
        rightPanel.add(formPanel, BorderLayout.CENTER);

        usernameField = new JTextField();
        passwordField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        roleBox = new JComboBox<>(new String[] { "USER", "ADMIN" });

        formPanel.add(new JLabel("帳號"));
        formPanel.add(usernameField);
        formPanel.add(new JLabel("密碼"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel("姓名"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("電話"));
        formPanel.add(phoneField);
        formPanel.add(new JLabel("角色"));
        formPanel.add(roleBox);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 4, 4));
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        JButton createButton = new JButton("新增");
        JButton updateButton = new JButton("修改");
        JButton deleteButton = new JButton("刪除");
        JButton clearButton = new JButton("清空");
        buttonPanel.add(createButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        table.getSelectionModel().addListSelectionListener(e -> loadSelectedRow());
        createButton.addActionListener(e -> create());
        updateButton.addActionListener(e -> update());
        deleteButton.addActionListener(e -> delete());
        clearButton.addActionListener(e -> clearForm());

        reloadTable();
    }

    private void reloadTable() {
        tableModel.setRowCount(0);
        List<Member> members = memberController.findAll();
        for (Member member : members) {
            tableModel.addRow(new Object[] {
                    member.getId(),
                    member.getUsername(),
                    member.getPassword(),
                    member.getName(),
                    member.getEmail(),
                    member.getPhone(),
                    member.getRole()
            });
        }
    }

    private void loadSelectedRow() {
        int row = table.getSelectedRow();
        if (row < 0) {
            return;
        }
        selectedId = (Integer) tableModel.getValueAt(row, 0);
        usernameField.setText(String.valueOf(tableModel.getValueAt(row, 1)));
        passwordField.setText(String.valueOf(tableModel.getValueAt(row, 2)));
        nameField.setText(String.valueOf(tableModel.getValueAt(row, 3)));
        emailField.setText(String.valueOf(tableModel.getValueAt(row, 4)));
        phoneField.setText(String.valueOf(tableModel.getValueAt(row, 5)));
        roleBox.setSelectedItem(String.valueOf(tableModel.getValueAt(row, 6)));
    }

    private Member readForm() {
        Member member = new Member();
        member.setId(selectedId);
        member.setUsername(usernameField.getText());
        member.setPassword(passwordField.getText());
        member.setName(nameField.getText());
        member.setEmail(emailField.getText());
        member.setPhone(phoneField.getText());
        member.setRole(String.valueOf(roleBox.getSelectedItem()));
        return member;
    }

    private void create() {
        try {
            memberController.create(readForm());
            reloadTable();
            clearForm();
            showMessage("新增會員成功");
        } catch (RuntimeException ex) {
            showError(ex);
        }
    }

    private void update() {
        try {
            memberController.update(readForm());
            reloadTable();
            clearForm();
            showMessage("修改會員成功");
        } catch (RuntimeException ex) {
            showError(ex);
        }
    }

    private void delete() {
        try {
            memberController.delete(selectedId);
            reloadTable();
            clearForm();
            showMessage("刪除會員成功");
        } catch (RuntimeException ex) {
            showError(ex);
        }
    }

    private void clearForm() {
        selectedId = null;
        usernameField.setText("");
        passwordField.setText("");
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        roleBox.setSelectedIndex(0);
        table.clearSelection();
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void showError(RuntimeException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "錯誤", JOptionPane.ERROR_MESSAGE);
    }
}
