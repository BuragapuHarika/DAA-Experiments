import java.util.Scanner;

public class MatrixOperations {
    // Method to multiply two 3x3 matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] C = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                C[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    // Method to find the adjoint of a 3x3 matrix
    public static int[][] adjoint(int[][] A) {
        int[][] adj = new int[3][3];

        // Cofactor matrix calculation
        adj[0][0] = (A[1][1] * A[2][2] - A[1][2] * A[2][1]);
        adj[0][1] = -(A[1][0] * A[2][2] - A[1][2] * A[2][0]);
        adj[0][2] = (A[1][0] * A[2][1] - A[1][1] * A[2][0]);

        adj[1][0] = -(A[0][1] * A[2][2] - A[0][2] * A[2][1]);
        adj[1][1] = (A[0][0] * A[2][2] - A[0][2] * A[2][0]);
        adj[1][2] = -(A[0][0] * A[2][1] - A[0][1] * A[2][0]);

        adj[2][0] = (A[0][1] * A[1][2] - A[0][2] * A[1][1]);
        adj[2][1] = -(A[0][0] * A[1][2] - A[0][2] * A[1][0]);
        adj[2][2] = (A[0][0] * A[1][1] - A[0][1] * A[1][0]);

        return adj;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] A = new int[3][3];
        int[][] B = new int[3][3];

        // Input for Matrix A
        System.out.println("Enter elements of 3x3 Matrix A:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                A[i][j] = scanner.nextInt();

        // Input for Matrix B
        System.out.println("Enter elements of 3x3 Matrix B:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                B[i][j] = scanner.nextInt();

        // Matrix Multiplication
        System.out.println("Result of Matrix Multiplication (A * B):");
        int[][] C = multiplyMatrices(A, B);
        printMatrix(C);

        // Adjoint Calculation
        System.out.println("Adjoint of Matrix A:");
        int[][] adj = adjoint(A);
        printMatrix(adj);

        scanner.close();
    }
}
