package courseWork._8Threads;

import courseWork.utils.Calculations;

public class T2 extends Thread {
    private int N = Main8.N;
    private int H = Main8.H;
    private int start = H;
    private int end = 2 * H;
    public int d2;
    public int e2;
    public int[] C2;
    public int[][] MO2;

    public T2(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T2");

        Main8.monitor.waitInput();

        d2 = Main8.monitor.copyd();
        e2 = Main8.monitor.copye();
        C2 = Main8.monitor.copyC();
        MO2 = Main8.monitor.copyMO();
        Calculations.function(start, end, Main8.B, d2, e2, C2, MO2, Main8.MK, Main8.A);

        Main8.monitor.signalCalc();
        Main8.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main8.A);
        Main8.monitor.signalSort();
        Main8.monitor.waitSort();

        Calculations.vectorMerge(2 * H, 4 * H, Main8.A);
        Main8.monitor.signalMerge1();
        Main8.monitor.waitMerge1();

        Calculations.vectorMerge(4 * H, N, Main8.A);
        Main8.monitor.signalMerge2();

        System.out.println("T2 stop");
    }
}