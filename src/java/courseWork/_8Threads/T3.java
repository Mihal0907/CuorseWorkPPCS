package courseWork._8Threads;

import courseWork.utils.Calculations;

public class T3 extends Thread {

    private int N = Main8.N;
    private int H = Main8.H;
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
        Main8.d = 1;
        Main8.e = 1;
        Main8.MK = Calculations.matrixInput(1);
        Main8.monitor.setD(Main8.d);
        Main8.monitor.setE(Main8.e);
        Main8.monitor.setMK(Main8.MK);

        Main8.monitor.signalInput();
        Main8.monitor.waitInput();

        d3 = Main8.monitor.copyd();
        e3 = Main8.monitor.copye();
        C3 = Main8.monitor.copyC();
        MO3 = Main8.monitor.copyMO();
        Calculations.function(start, end, Main8.B, d3, e3, C3, MO3, Main8.MK, Main8.A);

        Main8.monitor.signalCalc();
        Main8.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main8.A);
        Main8.monitor.signalSort();
        Main8.monitor.waitSort();

        Calculations.vectorMerge(4 * H, 6 * H, Main8.A);
        Main8.monitor.signalMerge1();

        System.out.println("T3 stop");
    }
}
