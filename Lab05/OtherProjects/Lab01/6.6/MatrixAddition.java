import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");    int r = sc.nextInt();
        System.out.print("Enter number of columns: "); int c = sc.nextInt();

        int[][] A = new int[r][c];
        int[][] B = new int[r][c];

        System.out.println("Enter matrix A:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                A[i][j] = sc.nextInt();
            }

        System.out.println("Enter matrix B:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                B[i][j] = sc.nextInt();
            }

        System.out.println("Result A + B:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.printf("%6d", A[i][j] + B[i][j]);
            System.out.println();
        }
        sc.close();
    }
}

