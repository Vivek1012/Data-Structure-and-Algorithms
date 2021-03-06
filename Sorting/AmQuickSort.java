public class AmQuickSort {

    public static void sort(Comparable[] inputArg) {
        int length = inputArg.length;
        int randomInt = (int) Math.floor(Math.random() * length);
        swap(inputArg, 0, randomInt);

        sort(inputArg, 0, length - 1);
    }

    public static void sort(Comparable[] inputArg, int start, int end) {
        if (end <= start) return;

        int j = partition(inputArg, start, end);
        sort(inputArg, start, j - 1);
        sort(inputArg, j + 1, end);
    }

    public static int partition(Comparable[] inputArg, int start, int end) {

        // First element is the partitioning element.
        int i = start;
        int j = end + 1;

        while (true) {

            // Find item on left to swap.
            while (isLessThan(inputArg[++i], inputArg[start])) {
                if (i == end) break;
            }

            // Find item on right to swap.
            while (isLessThan(inputArg[start], inputArg[--j])) {
                if (j == start) break;
            }

            // Check if pointers cross.
            if (i >= j) break;
            swap(inputArg, i, j);
        }

        // Swap with partitioning item.
        swap(inputArg, start, j);

        // Return index of item now known to be in place.
        return j;
    }

    public static boolean isLessThan(Comparable arg1, Comparable arg2) {
        return arg1.compareTo(arg2) < 0;
    }

    public static void swap(Comparable[] inputArg, int arg1, int arg2) {
        Comparable temp = inputArg[arg1];
        inputArg[arg1] = inputArg[arg2];
        inputArg[arg2] = temp;
    }
}