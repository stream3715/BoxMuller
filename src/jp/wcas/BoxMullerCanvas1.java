package jp.wcas;

import java.awt.*;

public class BoxMullerCanvas1 extends Canvas {
    private int num, sum;

    BoxMullerCanvas1(int number) {
        num = number;
    }

    public void paint(Graphics g) {

        g.drawLine(0, 900, 1000, 900);
        g.drawLine(500, 0, 500, 1000);

        for (int i = 0; i < 1000; i++) {
            sum += Main.array_result1[i];
        }
        sum /= (double) num;
        System.out.println(sum);
        for (int i = 0; i < 1000; i++) {
            g.drawLine(i, (int) (900 - Main.array_result1[i] / (double) num * 100000), i, (int) (900 - (Main.array_result1[i] / (double) num * 100000)));
        }
    }
}
