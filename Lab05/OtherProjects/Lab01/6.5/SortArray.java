import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        int sum = 0;
        for (int x : arr) sum += x;

        System.out.println("Sum:     " + sum);
        System.out.println("Average: " + (double) sum / n);
        sc.close();
    }
}
