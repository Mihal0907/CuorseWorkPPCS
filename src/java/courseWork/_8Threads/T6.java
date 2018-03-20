package courseWork._8Threads;

import courseWork.utils.Calculations;

public class T6 extends Thread {
    private int N = Main8.N;
    private int H = Main8.H;
    private int start = 5 * H;
    private int end = 6 * H;
    public int d6;
    public int e6;
    public int[] C6;
    public int[][] MO6;

    public T6(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T6");

        Main8.monitor.waitInput();

        d6 = Main8.monitor.copyd();
        e6 = Main8.monitor.copye();
        C6 = Main8.monitor.copyC();
        MO6 = Main8.monitor.copyMO();
        Calculations.function(start, end, Main8.B, d6, e6, C6, MO6, Main8.MK, Main8.A);

        Main8.monitor.signalCalc();
        Main8.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main8.A);
        Main8.monitor.signalSort();

        System.out.println("T6 stop");
    }
}