package courseWork._4Threads;

import courseWork._2Threads.Main2;

public class Monitor {
    private static int F1 = 0;
    private static int F2 = 0;
    private static int F3 = 0;
    private static int F4 = 0;

    private static int N = Main4.N;

    private int d;
    private int e;
    private int[] B = new int[N];
    private int[] C = new int[N];
    private int[][] MK = new int[N][N];
    private int[][] MO = new int[N][N];

    public int copyd() {
        return d;
    }

    public synchronized void setD(int d) {
        this.d = d;
    }

    public int copye() {
        return e;
    }

    public synchronized void setE(int e) {
        this.e = e;
    }

    public int[] copyB() {
        return B;
    }

    public synchronized void setB(int[] b) {
        B = b;
    }

    public int[] copyC() {
        return C;
    }

    public synchronized void setC(int[] c) {
        C = c;
    }

    public int[][] copyMK() {
        return MK;
    }

    public synchronized void setMK(int[][] MK) {
        this.MK = MK;
    }

    public int[][] copyMO() {
        return MO;
    }

    public synchronized void setMO(int[][] MO) {
        this.MO = MO;
    }

    public synchronized void signalInput(){
        F1++;
        if(F1 == 3) notifyAll();
    }

    public synchronized void signalCalc(){
        F2++;
        if (F2 == 4) notifyAll();
    }

    public synchronized void signalSort(){
        F3++;
        if (F3 == 4) notifyAll();
    }

    public synchronized void waitInput(){
        try{
            while (F1 != 3) wait();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public synchronized void waitCalc(){
        try{
            while (F2 != 4) wait();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public synchronized void waitSort(){
        try{
            while (F3 != 4) wait();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public synchronized void signalMerge(){
        F4++;
        if (F4 == 2) notifyAll();
    }

    public synchronized void waitMerge(){
        try{
            while (F4 != 2) wait();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
