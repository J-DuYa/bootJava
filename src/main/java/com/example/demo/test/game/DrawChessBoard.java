package com.example.demo.test.game;

import javax.swing.*;
import java.awt.*;

public class DrawChessBoard extends JPanel {
    public Image boardImg;
    final private int ROWS = 19;
    public DrawChessBoard() {
        boardImg = Toolkit.getDefaultToolkit().getImage("B:/xtalpi/bootJava/common.png");
        if (boardImg == null) {
            System.out.println("Png is not exist");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        System.out.println("触发");
        int imgWidth = boardImg.getWidth(this);
        int imgHeight = boardImg.getHeight(this);
        int Fwidth = getWidth();
        int FHeight = getHeight();

        int x = (Fwidth - imgWidth) / 2;
        int y = (FHeight - imgHeight) / 2;
        System.out.println(x + "height: " + y);
        g.drawImage(boardImg, x, y, null);

        int margin = x;
        int span_x = imgWidth/ROWS;
        int span_y = imgHeight/ROWS;

        for (int i = 0; i < ROWS; i++) {
            g.drawLine(x, y+i*span_y, Fwidth-x, y+i*span_y);
        }

        for (int i = 0; i < ROWS; i++) {
            g.drawLine(x+i*span_x, y, x+i*span_x, FHeight-y);
        }
    }
}
