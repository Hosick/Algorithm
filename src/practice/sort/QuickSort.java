package practice.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 0, 9, 1, 2, 4, 7, 8, 3};

        quickSort(arr, 0, 9);

        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left < right) {
            while (arr[left] < pivot && left < right) {
                left++;
            }
            while (arr[right] > pivot && left < right) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);

            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }
}
