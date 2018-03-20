package courseWork._4Threads;

import courseWork.utils.Calculations;

public class T4 extends Thread {
    private int N = Main4.N;
    private int H = Main4.H;
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
        Main4.C = Calculations.vectorInput(1);
        Main4.MO = Calculations.matrixInput(1);
        Main4.monitor.setC(Main4.C);
        Main4.monitor.setMO(Main4.MO);

        Main4.monitor.signalInput();
        Main4.monitor.waitInput();

        d4 = Main4.monitor.copyd();
        e4 = Main4.monitor.copye();
        C4 = Main4.monitor.copyC();
        MO4 = Main4.monitor.copyMO();
        Calculations.function(start, end, Main4.B, d4, e4, C4, MO4, Main4.MK, Main4.A);

        Main4.monitor.signalCalc();
        Main4.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main4.A);
        Main4.monitor.signalSort();

        System.out.println("T4 stop");
    }
}
