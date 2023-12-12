package controller;

import view.BookView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookViewController implements ActionListener {
    private BookView bk;
    public BookViewController(BookView bk) {
        this.bk = bk;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ban da nhan nut");

    }
}
