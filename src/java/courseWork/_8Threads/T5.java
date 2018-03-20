package courseWork._8Threads;

import courseWork.utils.Calculations;

public class T5 extends Thread {
    private int N = Main8.N;
    private int H = Main8.H;
    private int start = 4 * H;
    private int end = 5 * H;
    public int d5;
    public int e5;
    public int[] C5;
    public int[][] MO5;

    public T5(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T5");

        Main8.monitor.waitInput();

        d5 = Main8.monitor.copyd();
        e5 = Main8.monitor.copye();
        C5 = Main8.monitor.copyC();
        MO5 = Main8.monitor.copyMO();
        Calculations.function(start, end, Main8.B, d5, e5, C5, MO5, Main8.MK, Main8.A);

        Main8.monitor.signalCalc();
        Main8.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main8.A);
        Main8.monitor.signalSort();

        System.out.println("T5 stop");
    }
}