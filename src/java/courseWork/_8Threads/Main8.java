package courseWork._8Threads;

public class Main8 {
    public static int N = 4000;
    static int P = 8;
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
        T3 t3 = new T3("task 3");
        T4 t4 = new T4("task 4");
        T5 t5 = new T5("task 5");
        T6 t6 = new T6("task 6");
        T7 t7 = new T7("task 7");
        T8 t8 = new T8("task 8");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

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
            t5.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            t6.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            t7.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            t8.join();
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
