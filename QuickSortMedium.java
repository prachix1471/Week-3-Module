import java.util.*;

public class QuickSortMedium {

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        quickSort(arr, 0, n - 1);

        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        long sum = 0;
        System.out.print("Top 5: ");

        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }

        double topAvg = (double) sum / 5;
        double avg = (double) total / n;

        int count = 0;
        for (int x : arr)
            if (x > avg)
                count++;

        System.out.println();
        System.out.println("Average of Top 5: " + topAvg);
        System.out.println("Values Above Overall Average: " + count);
        sc.close();
    }
}