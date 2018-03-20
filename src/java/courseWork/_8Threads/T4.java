package courseWork._8Threads;

import courseWork.utils.Calculations;

public class T4 extends Thread {
    private int N = Main8.N;
    private int H = Main8.H;
    private int start = 3 * H;
    private int end = 4 * H;
    public int d4;
    public int e4;
    public int[] C4;
    public int[][] MO4;

    public T4(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T4");

        Main8.monitor.waitInput();

        d4 = Main8.monitor.copyd();
        e4 = Main8.monitor.copye();
        C4 = Main8.monitor.copyC();
        MO4 = Main8.monitor.copyMO();
        Calculations.function(start, end, Main8.B, d4, e4, C4, MO4, Main8.MK, Main8.A);

        Main8.monitor.signalCalc();
        Main8.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main8.A);
        Main8.monitor.signalSort();
        Main8.monitor.waitSort();

        Calculations.vectorMerge(6 * H, 8 * H, Main8.A);
        Main8.monitor.signalMerge1();


        System.out.println("T4 stop");
    }
}