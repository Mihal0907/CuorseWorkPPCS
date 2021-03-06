package courseWork._2Threads;

public class Monitor {
    private static int F1 = 0;
    private static int F2 = 0;
    private static int F3 = 0;

    private static int N = Main2.N;

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
        if(F1 == 2) notifyAll();
    }

    public synchronized void signalCalc(){
        F2++;
        if (F2 == 2) notifyAll();
    }

    public synchronized void signalSort(){
        F3++;
        if (F3 == 1) notifyAll();
    }

    public synchronized void waitInput(){
        try{
            while (F1 != 2) wait();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public synchronized void waitCalc(){
        try{
            while (F2 != 2) wait();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public synchronized void waitSort(){
        try{
            while (F3 != 1) wait();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

}
