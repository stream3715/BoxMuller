import java.awt.*;

public class BoxMullerCanvas2 extends Canvas {

    private double num;

    BoxMullerCanvas2(double number) {
        num = 2 * number;
    }

    public void paint(Graphics g) {
        g.drawLine(0, 900, 1000, 900);
        g.drawLine(500, 0, 500, 1000);

        double workarray[] = Main.array_result1.clone();
        g.setColor(Color.blue);
        for (int i = 0; i < 999; i++) {
            workarray[i + 1] += workarray[i];
            g.drawLine(i, (int) (900 - (workarray[i] / num * 100)), i + 1, (int) (900 - ((workarray[i + 1]) / num * 100)));
        }

    }
}
