package courseWork.test;


import courseWork.utils.Calculations;

public class TestClass {
    public static int N = 4;
    public static int P = 2;
    public static int H = N / P;

    public static void main(String[] args) {
       /* System.out.println("Hello");

        int[] vec1 = courseWork.utils.Calculations.vectorInput(1);
        int[] vec2 = courseWork.utils.Calculations.vectorInput(1);
        int[] vec = new int[N];
        courseWork.utils.Calculations.vectorAddition(0, N, vec1, vec2, vec);
        courseWork.utils.Calculations.vectorOut(vec);

        int[][] matrix1 = courseWork.utils.Calculations.matrixInput(1);
        int[][] matrix2 = courseWork.utils.Calculations.matrixInput(1);
        int[][] matrix = new int[N][N];
        courseWork.utils.Calculations.matrixMultiplication(0, N, matrix1, matrix2, matrix);
        courseWork.utils.Calculations.matrixOut(matrix);

        int[] vec3 = new int[N];
        courseWork.utils.Calculations.vectorNumMultiplication(0, N, 6, vec1);
        courseWork.utils.Calculations.vectorOut(vec1);

        int[] vec4 = new int[N];
        courseWork.utils.Calculations.vectorMatrixMultiplication(0, N, vec1, matrix1);
        courseWork.utils.Calculations.vectorOut(vec1);*/

/*        int[] B = courseWork.utils.Calculations.vectorInput(1);
        int[] C = courseWork.utils.Calculations.vectorInput(1);
        int d = 1;
        int e = 1;
        int[][] MO = courseWork.utils.Calculations.matrixInput(1);
        int[][] MT = courseWork.utils.Calculations.matrixInput(1);
        int[] res = new int[N];
        int P = 8;
        int H = N / P;

        courseWork.utils.Calculations.function(0, 1*H, B, d, e, C, MO, MT, res);
        courseWork.utils.Calculations.function(1*H, 2*H, B, d, e, C, MO, MT, res);
        courseWork.utils.Calculations.function(2*H, 3*H, B, d, e, C, MO, MT, res);
        courseWork.utils.Calculations.function(3*H, 4*H, B, d, e, C, MO, MT, res);
        courseWork.utils.Calculations.function(4*H, 5*H, B, d, e, C, MO, MT, res);
        courseWork.utils.Calculations.function(5*H, 6*H, B, d, e, C, MO, MT, res);
        courseWork.utils.Calculations.function(6*H, 7*H, B, d, e, C, MO, MT, res);
        courseWork.utils.Calculations.function(7*H, 8*H, B, d, e, C, MO, MT, res);
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        courseWork.utils.Calculations.vectorOut(res);*/

/*        int[] vector = {4, 3, 5, 1};
        courseWork.utils.Calculations.vectorOut(vector);
        courseWork.utils.Calculations.vectorSort(0, N, vector);
        courseWork.utils.Calculations.vectorOut(vector);*/

        System.out.println("--------------------");


        int[] vector1 = {2, 1, 4, 3};
        Calculations.vectorOut(vector1);
        Calculations.vectorMerge(0, H, vector1);
        Calculations.vectorOut(vector1);
        Calculations.vectorMerge(H, 2*H, vector1);
        Calculations.vectorOut(vector1);
        Calculations.vectorMerge(0, 2*H, vector1);
        Calculations.vectorOut(vector1);




    }
}
