package courseWork._2Threads;



public class Main2 {

    public static int N = 8;
    static int P = 2;
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

        t1.start();
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            t1.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        long end = System.nanoTime();
        System.out.format("For N = %s and P = %s, time = %s(ns).", N, P, (end - start));

    }


}
