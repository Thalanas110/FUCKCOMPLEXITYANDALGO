class mergesortnew {
    // merges two subarrays of arr[]
    // first subarray is arr[l...m]
    // second subarray is arr[m+1..r]

   static void merge(int arr[], int l, int m, int r){
        
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Print the subarrays being merged
        System.out.print("Merging: [");
        for (int i = 0; i < n1; i++) {
            System.out.print(L[i]);
            if (i < n1 - 1) System.out.print(", ");
        }
        System.out.print("] and [");
        for (int i = 0; i < n2; i++) {
            System.out.print(R[i]);
            if (i < n2 - 1) System.out.print(", ");
        }
        System.out.println("]");

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        // Print the result after merging
        System.out.print("Result: [");
        for (int idx = l; idx <= r; idx++) {
            System.out.print(arr[idx]);
            if (idx < r) System.out.print(", ");
        }
        System.out.println("]\n");
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int l, int r){
        
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Driver code
    public static void main(String args[]){

        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array: [12, 11, 13, 5, 6, 7]");
        System.out.println("\nStarting Merge Sort...\n");
        
        mergeSort(arr, 0, arr.length - 1);
        
        System.out.println("Final sorted array:");
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}