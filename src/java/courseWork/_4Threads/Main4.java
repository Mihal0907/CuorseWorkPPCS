package courseWork._4Threads;

public class Main4 {

    public static int N = 2000;
    static int P = 4;
    static int H = N / P;

    static int[] B = new int[N];
    static int d;
    static int e;
    static int[] C = new int[N];
    static int[] A = new int[N];
    static int[][] MO = new int[N][N];
    static int[][] MK = new int[N][N];

    static Monitor monitor = new Monitor();

    public static void main(String[] args) {

        long start = System.nanoTime();
        T1 t1 = new T1("task 1");
        T2 t2 = new T2("task 2");
        T3 t3 = new T3("task 1");
        T4 t4 = new T4("task 2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t2.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            t3.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            t4.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            t1.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        long end = System.nanoTime();
        System.out.println("Time = " + (end - start));

    }
}
