package jp.wcas;

import javax.swing.*;

public class Main {
    static double[] array_result1 = new double[1000];
    static double[] array_result2 = new double[1000];

    public static void main(String args[]) {
        double average = Double.valueOf(args[0]);
        double dispersion = Double.valueOf(args[1]);
        int number = Integer.valueOf(args[2]);


        JFrame frame1 = new JFrame();

        frame1.setTitle("確率分布関数");
        setValue(frame1);
        JPanel cp1 = new JPanel();

        cp1.setLayout(null);
        frame1.add(cp1);

        cp1.setBounds(0, 0, 1000, 1000);

        for (int i = 0; i < number; i++) {
            calc(average, dispersion, array_result1);
            calc(average, dispersion, array_result2);
        }

        BoxMullerCanvas1 canvas1 = new BoxMullerCanvas1(number);
        cp1.add(canvas1);

        canvas1.setBounds(0, 0, 1000, 1000);
        frame1.setVisible(true);

        JFrame frame2 = new JFrame();

        frame2.setTitle("確率密度関数");
        setValue(frame2);

        JPanel cp2 = new JPanel();

        cp2.setLayout(null);
        frame2.add(cp2);

        cp2.setBounds(0, 0, 1000, 1000);

        BoxMullerCanvas2 canvas2 = new BoxMullerCanvas2(number);
        cp2.add(canvas2);

        canvas2.setBounds(0, 0, 1000, 1000);
        frame2.setVisible(true);
    }

    private static void calc(double a, double b, double[] array) {
        double x = Math.random();
        double y = Math.random();
        double result = Math.sqrt(-2.0 * Math.log(x)) * Math.cos(2.0 * Math.PI * y) * b + a;
        int resint = (int) ((result + 5) / 0.01);
        if (resint >= 0 && resint < 1000) array[resint]++;
    }

    private static void setValue(JFrame f) {
        f.setBounds(0, 0, 1000, 1000);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLayout(null);
    }
}
