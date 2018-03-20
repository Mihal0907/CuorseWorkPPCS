package courseWork.linearAlgo;

import courseWork.utils.Calculations;

public class MainLinear {
    public static int N = 1000;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] B;
        B = Calculations.vectorInput(1);
        int[] C;
        C = Calculations.vectorInput(1);
        int d = 1;
        int e = 1;
        int[][] MO;
        MO = Calculations.matrixInput(1);
        int[][] MK;
        MK = Calculations.matrixInput(1);

        int[] A = new int[N];

        Calculations.function(0, N, B, d, e, C, MO, MK, A);

        Calculations.vectorSort(0, N, A);

        if (N < 10){
            Calculations.vectorOut(A);
        }

        long endTime = System.nanoTime();

        System.out.format("For N = %s, time = %s (ns).", N, (endTime - startTime));

    }
}
