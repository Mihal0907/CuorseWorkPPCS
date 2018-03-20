package courseWork._8Threads;

import courseWork.utils.Calculations;

public class T8 extends Thread {
    private int N = Main8.N;
    private int H = Main8.H;
    private int start = 7 * H;
    private int end = 8 * H;
    public int d8;
    public int e8;
    public int[] C8;
    public int[][] MO8;

    public T8(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T8");
        Main8.C = Calculations.vectorInput(1);
        Main8.MO = Calculations.matrixInput(1);
        Main8.monitor.setC(Main8.C);
        Main8.monitor.setMO(Main8.MO);

        Main8.monitor.signalInput();
        Main8.monitor.waitInput();

        d8 = Main8.monitor.copyd();
        e8 = Main8.monitor.copye();
        C8 = Main8.monitor.copyC();
        MO8 = Main8.monitor.copyMO();
        Calculations.function(start, end, Main8.B, d8, e8, C8, MO8, Main8.MK, Main8.A);

        Main8.monitor.signalCalc();
        Main8.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main8.A);
        Main8.monitor.signalSort();

        System.out.println("T8 stop");
    }
}
