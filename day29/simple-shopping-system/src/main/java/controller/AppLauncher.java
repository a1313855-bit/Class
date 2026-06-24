package controller;

import javax.swing.SwingUtilities;

import view.LoginFrame;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
