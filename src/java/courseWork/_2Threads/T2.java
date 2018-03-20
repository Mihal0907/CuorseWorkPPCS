package courseWork._2Threads;

import courseWork.linearAlgo.MainLinear;
import courseWork.utils.Calculations;

public class T2 extends Thread {


    int N = Main2.N;
    int H = Main2.H;
    int start = H;
    int end = H * 2;
    public int d2;
    public int e2;
    public int[] C2;
    public int[][] MO2;

    public T2(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Start T@");
        Main2.C = Calculations.vectorInput(1);
        Main2.MO = Calculations.matrixInput(1);
        Main2.MK = Calculations.matrixInput(1);
        Main2.monitor.setC(Main2.C);
        Main2.monitor.setMO(Main2.MO);
        Main2.monitor.setMK(Main2.MK);

        Main2.monitor.signalInput();
        Main2.monitor.waitInput();

        d2 = Main2.monitor.copyd();
        e2 = Main2.monitor.copye();
        C2 = Main2.monitor.copyC();
        MO2 = Main2.monitor.copyMO();
        Calculations.function(start, end, Main2.B, d2, e2, C2, MO2, Main2.MK, Main2.A);

        Main2.monitor.signalCalc();
        Main2.monitor.waitCalc();

        Calculations.vectorSort(start, end, Main2.A);
        Main2.monitor.signalSort();

        System.out.println("T2 stop");
    }
}
