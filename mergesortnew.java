class mergesortnew {
// Merges two subarrays of arr[].
    // First subarray is arr[l...m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            // Note: (l+r)/2 is used here instead of l + (r-l)/2
            int m = (l + r) / 2;

            System.out.println("\nDividing array from index " + l + " to " + r + " (middle: " + m + ")");
            printSubArray(arr, l, r);

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            System.out.println("\nMerging subarrays:");
            System.out.print("  Left part [" + l + ".." + m + "]: ");
            printSubArray(arr, l, m);
            System.out.print("  Right part [" + (m+1) + ".." + r + "]: ");
            printSubArray(arr, m + 1, r);
            
            merge(arr, l, m, r);
            
            System.out.print("  Result [" + l + ".." + r + "]: ");
            printSubArray(arr, l, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /* A utility function to print a subarray */
    void printSubArray(int arr[], int l, int r) {
        for (int i = l; i <= r; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        // Create an object to call the non-static sort method
        mergesortnew ob = new mergesortnew();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}