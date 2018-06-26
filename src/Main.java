import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static double[] array_result1 = new double[1000];
    static ArrayList<Double> timearray = new ArrayList<>();
    private static int sig1 = 0, sig2 = 0, sig3 = 0, count = 0;
    private static double sum;

    public static void main(String args[]) {
        double average = Double.valueOf(args[0]);
        double dispersion = Math.sqrt(Double.valueOf(args[1]));
        double number = Double.valueOf(args[2]);


        JFrame frame1 = new JFrame();
        JFrame frame_t = new JFrame();

        frame1.setTitle("確率密度関数");
        setValue(frame1);
        JPanel cp1 = new JPanel();

        frame_t.setTitle("時系列");
        setValue(frame_t);
        JPanel cp_t = new JPanel();

        cp1.setLayout(null);
        frame1.add(cp1);

        cp_t.setLayout(null);
        frame_t.add(cp_t);

        cp1.setBounds(0, 0, 1000, 1000);
        cp_t.setBounds(0, 0, 1000, 1000);

        for (int i = 0; i < number; i++) {
            calc(average, dispersion, array_result1);
        }

        TimeCanvas canvas_t = new TimeCanvas(number);
        cp_t.add(canvas_t);

        canvas_t.setBounds(0, 0, 1000, 1000);
        frame_t.setVisible(true);
        //

        BoxMullerCanvas1 canvas1 = new BoxMullerCanvas1(number);
        cp1.add(canvas1);

        canvas1.setBounds(0, 0, 1000, 1000);
        frame1.setVisible(true);

        JFrame frame2 = new JFrame();

        frame2.setTitle("確率分布関数");
        setValue(frame2);

        JPanel cp2 = new JPanel();

        cp2.setLayout(null);
        frame2.add(cp2);

        cp2.setBounds(0, 0, 1000, 1000);

        BoxMullerCanvas2 canvas2 = new BoxMullerCanvas2(number);
        cp2.add(canvas2);

        canvas2.setBounds(0, 0, 1000, 1000);
        frame2.setVisible(true);
        for (int i = 0; i < 1000; i++) {
            sum += Main.array_result1[i];
        }
        sum /= number * 2.0;
        System.out.println("確率分布の合計は" + sum);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.csv"))) {
            for (int i = 0; i < 1000; i++) {
                bw.write((i - 500) * 0.01 + "," + array_result1[i] / number / 2.0);
                bw.newLine();
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("±1σ:%f%% ±2σ:%f%% ±3σ:%f%%\n", sig1 / number / 2.0 * 100, sig2 / number / 2.0 * 100, sig3 / number / 2.0 * 100);
    }

    private static void calc(double a, double b, double[] array) {
        double x = Math.random();
        double y = Math.random();
        double result1 = Math.sqrt(-2.0 * Math.log(x)) * Math.cos(2.0 * Math.PI * y) * b + a;
        timearray.add(count++, result1);
        int resint = (int) ((result1 + 5) / 0.01);

        if (resint >= 0 && resint < 1000) array[resint]++;
        if (Math.abs(result1) < b) sig1++;
        if (Math.abs(result1) < 2 * b) sig2++;
        if (Math.abs(result1) < 3 * b) sig3++;
        result1 = Math.sqrt(-2.0 * Math.log(x)) * Math.sin(2.0 * Math.PI * y) * b + a;
        timearray.add(count++, result1);
        resint = (int) ((result1 + 5) / 0.01);
        if (resint >= 0 && resint < 1000) array[resint]++;
        if (Math.abs(result1) < b - a) sig1++;
        if (Math.abs(result1) < (2 * (b - a))) sig2++;
        if (Math.abs(result1) < (3 * (b - a))) sig3++;
    }

    private static void setValue(JFrame f) {
        f.setBounds(0, 0, 1000, 1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLayout(null);
    }
}
