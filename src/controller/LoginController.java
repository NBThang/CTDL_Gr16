package controller;

import view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private LoginView lgv;

    public LoginController(LoginView lgv) {
        this.lgv = lgv;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        SwingUtilities.invokeLater(() -> new BookView());
    }
}
