package courseWork._2Threads;

import courseWork.linearAlgo.MainLinear;
import courseWork.utils.Calculations;

public class T1 extends Thread {

    private int N = Main2.N;
    private int H = Main2.H;
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
        Main2.B = Calculations.vectorInput(1);
        Main2.d = 1;
        Main2.e = 1;
        Main2.monitor.setB(Main2.B);
        Main2.monitor.setD(Main2.d);
        Main2.monitor.setE(Main2.e);

        Main2.monitor.signalInput();
        Main2.monitor.waitInput();

        d1 = Main2.monitor.copyd();
        e1 = Main2.monitor.copye();
        C1 = Main2.monitor.copyC();
        MO1 = Main2.monitor.copyMO();
        Calculations.function(start, end, Main2.B, d1, e1, C1, MO1, Main2.MK, Main2.A);

        Main2.monitor.signalCalc();
        Main2.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main2.A);
        Main2.monitor.waitSort();

        Calculations.vectorMerge(start, N, Main2.A);

        if (N < 20){
            Calculations.vectorOut(Main2.A);
        }
        System.out.println("T1 stop");
    }
}
