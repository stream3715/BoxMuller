import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String args[]){
        double average = Double.valueOf(args[0]);
        double dispersion = Double.valueOf(args[1]);
        int number = Integer.valueOf(args[2]);

        JFrame frame = new JFrame();

        frame.setTitle("BoxMuller");
        frame.setBounds(0,0,400,400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        JPanel cp = new JPanel();

        cp.setLayout(null);
        frame.add(cp);

        //コンテントペインの貼り付け位置・大きさを設定
        cp.setBounds(0,0,400,400);


        //============================================================================
        //キャンバスの作成
        BoxMullerCanvas canvas = new BoxMullerCanvas(average, dispersion, number);
        Thread th[] = new Thread[number];
        for (int i = 0; i < number; i++) {
            th[i] = new Thread(canvas);
            th[i].start();
        }
        canvas.repaint();
        //キャンバスをコンテント・ペインに登録
        cp.add(canvas);

        //キャンパスの位置はコンテントペインに合わせる。
        //キャンバスのサイズはコンテントペインと同じにする。
        canvas.setBounds(0,0,400,400);
        frame.setVisible(true);
    }
}
