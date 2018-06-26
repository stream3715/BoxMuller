import java.awt.*;

public class TimeCanvas extends Canvas {
    private double num;

    TimeCanvas(double number) {
        num = 2 * number;
    }

    public void paint(Graphics g) {

        g.drawLine(0, 500, 1000, 500);
        g.drawLine(500, 0, 500, 1000);

        if (num < 1000) {
            for (int i = 0; i < num; i++) {
                g.drawLine(i * (int) (1000 / num), (int) (500 - (Main.timearray.get(i) * 100)), i * (int) (1000 / num), (int) (500 - (Main.timearray.get(i) * 100)));
            }
        } else {
            for (int i = 0; i < num; i += num / 1000) {
                double temp = 0;
                for (int j = i; j < i + (num / 1000); j++) {
                    temp += Main.timearray.get(j);
                }
                Main.timearray.set(i, temp);
            }

            for (int i = 0; i < 1000; i++) {
                g.drawLine(i, (int) (500 - (Main.timearray.get(i * (int) (num / 1000)) * 10)), i, (int) (500 - (Main.timearray.get(i * (int) (num / 1000)) * 10)));
            }
        }
    }
}
