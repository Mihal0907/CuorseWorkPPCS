package courseWork._8Threads;

import courseWork.utils.Calculations;

public class T7 extends Thread {
    private int N = Main8.N;
    private int H = Main8.H;
    private int start = 6 * H;
    private int end = 7 * H;
    public int d7;
    public int e7;
    public int[] C7;
    public int[][] MO7;

    public T7(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T7");

        Main8.monitor.waitInput();

        d7 = Main8.monitor.copyd();
        e7 = Main8.monitor.copye();
        C7 = Main8.monitor.copyC();
        MO7 = Main8.monitor.copyMO();
        Calculations.function(start, end, Main8.B, d7, e7, C7, MO7, Main8.MK, Main8.A);

        Main8.monitor.signalCalc();
        Main8.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main8.A);
        Main8.monitor.signalSort();

        System.out.println("T7 stop");
    }
}