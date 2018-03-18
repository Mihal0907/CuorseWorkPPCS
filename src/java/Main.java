

public class Main {
    public static int N = 4;

    public static void main(String[] args) {
        System.out.println("Hello");

        int[] vec1 = Calculations.vectorInput(1);
        int[] vec2 = Calculations.vectorInput(1);
        int[] vec = new int[N];
        Calculations.vectorAddition(0, N, vec1, vec2, vec);
        Calculations.vectorOut(vec);

        int[][] matrix1 = Calculations.matrixInput(1);
        int[][] matrix2 = Calculations.matrixInput(1);
        int[][] matrix = new int[N][N];
        Calculations.matrixMultiplication(0, N, matrix1, matrix2, matrix);
        Calculations.matrixOut(matrix);

        int[] vec3 = new int[N];
        Calculations.vectorNumMultiplication(0, N, 6, vec1, vec3);
        Calculations.vectorOut(vec3);

        int[] vec4 = new int[N];
        Calculations.vectorMatrixMultiplication(0, N, vec1, matrix1, vec4);
        Calculations.vectorOut(vec4);

        int[] B = Calculations.vectorInput(1);
        int[] C = Calculations.vectorInput(1);
        int d = 1;
        int e = 1;
        int[][] MO = Calculations.matrixInput(1);
        int[][] MT = Calculations.matrixInput(1);
        int[] res = new int[N];

        Calculations.function(0, N, B, d, e, C, MO, MT, res);
        Calculations.vectorOut(res);

        int[] vector = {4, 3, 5, 1};
        Calculations.vectorOut(vector);
        Calculations.vectorSort(0, N, vector);
        Calculations.vectorOut(vector);

        int[] vector1 = {2, 4, 1, 3};
        Calculations.vectorMerge(0, N, vector1);
        Calculations.vectorOut(vector1);

    }
}
