package core.sort;

public class TimeSort {
    static final int RUN = 32;

    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i += RUN) {
//            InsertionSort.sort(arr, i, Math.min(i + RUN - 1, n-1));
        }

        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = Math.min(left + size - 1, n - 1);
                int right = Math.min(left + 2 * size - 1, n - 1);
                if (mid < right) {
//                    merge(arr, left, mid, right);
                }
            }
        }
    }
}
