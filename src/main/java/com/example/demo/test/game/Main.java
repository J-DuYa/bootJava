package com.example.demo.test.game;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private DrawChessBoard drawChessBoard;
    public Main() {
        drawChessBoard = new DrawChessBoard();
        setTitle("A*寻路算法");
        Container containerPane = getContentPane();
        containerPane.add(drawChessBoard);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.setVisible(true);
    }
}
