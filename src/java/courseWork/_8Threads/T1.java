package courseWork._8Threads;

import courseWork.utils.Calculations;

public class T1 extends Thread {
    private int N = Main8.N;
    private int H = Main8.H;
    private int start = 0;
    private int end = H;
    public int d1;
    public int e1;
    public int[] C1;
    public int[][] MO1;

    public T1(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T1");
        Main8.B = Calculations.vectorInput(1);
        Main8.monitor.setB(Main8.B);

        Main8.monitor.signalInput();
        Main8.monitor.waitInput();

        d1 = Main8.monitor.copyd();
        e1 = Main8.monitor.copye();
        C1 = Main8.monitor.copyC();
        MO1 = Main8.monitor.copyMO();
        Calculations.function(start, end, Main8.B, d1, e1, C1, MO1, Main8.MK, Main8.A);

        Main8.monitor.signalCalc();
        Main8.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main8.A);
        Main8.monitor.signalSort();
        Main8.monitor.waitSort();

        Calculations.vectorMerge(start, 2 * H, Main8.A);
        Main8.monitor.signalMerge1();
        Main8.monitor.waitMerge1();

        Calculations.vectorMerge(start, 4 * H, Main8.A);
        Main8.monitor.waitMerge2();

        Calculations.vectorMerge(start, N, Main8.A);

        if (N < 30) {
            Calculations.vectorOut(Main8.A);
        }
        System.out.println("T1 stop");
    }
}