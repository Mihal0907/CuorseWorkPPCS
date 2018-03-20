package courseWork._4Threads;

import courseWork.utils.Calculations;
import sun.applet.Main;

public class T3 extends Thread {

    private int N = Main4.N;
    private int H = Main4.H;
    private int start = 2 * H;
    private int end = 3 * H;
    public int d3;
    public int e3;
    public int[] C3;
    public int[][] MO3;

    public T3(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T3");
        Main4.d = 1;
        Main4.e = 1;
        Main4.MK = Calculations.matrixInput(1);
        Main4.monitor.setD(Main4.d);
        Main4.monitor.setE(Main4.e);
        Main4.monitor.setMK(Main4.MK);

        Main4.monitor.signalInput();
        Main4.monitor.waitInput();

        d3 = Main4.monitor.copyd();
        e3 = Main4.monitor.copye();
        C3 = Main4.monitor.copyC();
        MO3 = Main4.monitor.copyMO();
        Calculations.function(start, end, Main4.B, d3, e3, C3, MO3, Main4.MK, Main4.A);

        Main4.monitor.signalCalc();
        Main4.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main4.A);
        Main4.monitor.signalSort();

        System.out.println("T3 stop");
    }
}
