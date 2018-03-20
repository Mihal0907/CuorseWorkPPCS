package courseWork._4Threads;

import courseWork.utils.Calculations;
import sun.applet.Main;

public class T1 extends Thread {
    private int N = Main4.N;
    private int H = Main4.H;
    private int start = 0;
    private int end = H;
    public int d1;
    public int e1;
    public int[] C1;
    public int[][] MO1;

    public T1(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T1");
        Main4.B = Calculations.vectorInput(1);
        Main4.monitor.setB(Main4.B);

        Main4.monitor.signalInput();
        Main4.monitor.waitInput();

        d1 = Main4.monitor.copyd();
        e1 = Main4.monitor.copye();
        C1 = Main4.monitor.copyC();
        MO1 = Main4.monitor.copyMO();
        Calculations.function(start, end, Main4.B, d1, e1, C1, MO1, Main4.MK, Main4.A);

        Main4.monitor.signalCalc();
        Main4.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main4.A);
        Main4.monitor.signalSort();
        Main4.monitor.waitSort();

        Calculations.vectorMerge(start, 2 * H, Main4.A);
        Main4.monitor.signalMerge();

        Calculations.vectorMerge(start, N, Main4.A);

        if (N < 20){
            Calculations.vectorOut(Main4.A);
        }
        System.out.println("T1 stop");
    }
}
