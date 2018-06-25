import java.awt.*;
import java.util.Random;

public class BoxMullerCanvas extends Canvas implements Runnable{
    private double average, dispersion;
    private int num;
    private static int[] resultarray = new int[400];
    private Random random;
    BoxMullerCanvas(double a, double b, int num) {
        average = a;
        dispersion = b;
        this.num = num;
        random = new Random(System.currentTimeMillis());
    }


    public void paint(Graphics g)
    {
        for (int i = 0;i < 400; i++){
            g.drawLine(i, 400-resultarray[i], i, 400-resultarray[i]);
        }
    }


    @Override
    public void run() {
        double x = random.nextDouble();
        double y = random.nextDouble();
        double result = Math.sqrt(-2.0 * Math.log(x)) * Math.cos(2.0 * Math.PI * y) * dispersion + average;
        System.out.println(result);
        int resint = (int)Math.floor((result + 1) / (0.0025));

        synchronized (resultarray){
            try{
            resultarray[resint]++;} catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
    }
}
