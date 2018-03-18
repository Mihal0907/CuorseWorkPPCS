import java.util.Arrays;

public class Calculations {

    private static int n = Main.N;

    public static int[] vectorInput(int num) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = num;
        }
        return res;
    }

    public static void vectorOut(int[] vector) {
        System.out.println(Arrays.toString(vector) + "\n");
    }

    public static int[][] matrixInput(int num) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = num;
            }
        }
        return res;
    }

    public static void matrixOut(int[][] matrix) {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
    }

    public static void matrixMultiplication(int start, int end, int[][] matrix1, int[][] martix2, int[][] rezMatrix) {
        int buf;

        for (int i = 0; i < n; i++) {
            for (int j = start; j < end; j++) {
                buf = 0;
                for (int k = 0; k < n; k++) {
                    buf += matrix1[i][k] * martix2[k][j];
                }
                rezMatrix[i][j] = buf;
            }
        }
    }

    public static void vectorNumMultiplication(int start, int end, int num, int[] vector, int[] resVector) {
        for (int i = start; i < end; i++) {
            resVector[i] = vector[i] * num;
        }
    }

    public static void vectorMatrixMultiplication(int start, int end, int[] vector, int[][] martix, int[] resVector) {
        int buf;
        for (int i = start; i < end; i++) {
            buf = 0;
            for (int j = 0; j < n; j++) {
                buf += vector[j] * martix[j][i];
            }
            resVector[i] = buf;
        }
    }

    public static void vectorAddition(int start, int end, int[] vector1, int[] vector2, int[] resVector) {
        for (int i = start; i < end; i++) {
            resVector[i] = vector1[i] + vector2[i];
        }
    }

    public static void vectorSort(int start, int end, int[] vector) {
        int k;
        int buf;

        for (int i = start; i < end; i++) {
            k = i;
            for (int j = i + 1; j < end; j++) {
                if (vector[k] > vector[j]) {
                    k = j;
                }
            }
            buf = vector[k];
            vector[k] = vector[i];
            vector[i] = buf;
        }
    }

    public static void vectorMerge(int start, int end, int[] vector) {
        int size = end - start;
        int index1 = start;
        int index2 = size / 2;
        int i = 0;
        int[] bufVec = new int[n];

        while (index1 <= size/2 - 1 && index2 <= size - 1) {
            if (vector[index1] < vector[index2]) {
                bufVec[i] = vector[index1];
                index1++;
            } else {
                bufVec[i] = vector[index2];
                index2++;
            }
            i++;
        }

        while (index1 <= size / 2 - 1) {
            bufVec[i] = vector[index1];
            index1++;
            i++;
        }
        while (index2 <= size - 1) {
            bufVec[i] = vector[index2];
            index2++;
            i++;
        }

        System.arraycopy(bufVec, 0, vector, 0, size);
    }

    public static void function(int start, int end, int[] B, int d, int e, int[] C, int[][] MO, int[][] MT, int[] result) {
//        int size = end - start;
        int[][] MK = new int[n][n];
        int[] D = new int[n];
        int[] E = new int[n];
        int[] F = new int[n];

        matrixMultiplication(start, end, MO, MT, MK);
        vectorNumMultiplication(start, end, e, C, D);
        vectorNumMultiplication(start, end, d, B, E);
        vectorMatrixMultiplication(start, end, D, MK, F);
        vectorAddition(start, end, E, F, result);
    }
}