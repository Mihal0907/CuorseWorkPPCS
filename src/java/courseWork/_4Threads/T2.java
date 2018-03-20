package courseWork._4Threads;

import courseWork.utils.Calculations;

public class T2 extends Thread {
    private int N = Main4.N;
    private int H = Main4.H;
    private int start = H;
    private int end = 2*H;
    public int d2;
    public int e2;
    public int[] C2;
    public int[][] MO2;

    public T2(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T2");

        Main4.monitor.waitInput();

        d2 = Main4.monitor.copyd();
        e2 = Main4.monitor.copye();
        C2 = Main4.monitor.copyC();
        MO2 = Main4.monitor.copyMO();
        Calculations.function(start, end, Main4.B, d2, e2, C2, MO2, Main4.MK, Main4.A);

        Main4.monitor.signalCalc();
        Main4.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main4.A);
        Main4.monitor.signalSort();
        Main4.monitor.waitSort();

        Calculations.vectorMerge(2*H, 4 * H, Main4.A);
        Main4.monitor.signalMerge();

        System.out.println("T1 stop");
    }
}
