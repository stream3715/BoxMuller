package jp.wcas;

import java.awt.*;

public class BoxMullerCanvas2 extends Canvas {

    private int num;

    BoxMullerCanvas2(int number) {
        num = number;
    }

    public void paint(Graphics g) {
        g.drawLine(0, 900, 1000, 900);
        g.drawLine(500, 0, 500, 1000);

        for (int i = 0; i < 1000; i++) {
            g.drawLine(i, (int) (900 - Main.array_result1[i] / (double) num * 100000), i, (int) (900 - (Main.array_result1[i] / (double) num * 100000)));
        }
        g.setColor(Color.red);

        for (int i = 0; i < 999; i++) {
            g.drawLine(i, (int) (900 - Main.array_result2[i] / (double) num * 100000), i + 1, (int) (900 - (Main.array_result2[i + 1] / (double) num * 100000)));
        }

    }
}
