import java.awt.*;

public class BoxMullerCanvas1 extends Canvas {
    private double num;

    BoxMullerCanvas1(double number) {
        num = 2 * number;
    }

    public void paint(Graphics g) {

        g.drawLine(0, 900, 1000, 900);
        g.drawLine(500, 0, 500, 1000);

        for (int i = 0; i < 999; i++) {
            g.drawLine(i, (int) (900 - Main.array_result1[i] / num * 10000), i + 1, (int) (900 - (Main.array_result1[i + 1] / num * 10000)));
        }
    }
}
