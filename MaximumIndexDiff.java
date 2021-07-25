// Given an array A[] of N positive integers. 
// The task is to find the maximum of j - i with the constraint of A[i] <= A[j]. 
// Time Complexity : O(n) Space Complexity : O(n)

public class MaximumIndexDiff {
    int findDiff(int arr[], int n) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = 0;
        right[n - 1] = n - 1;

        for (int i = 1; i < left.length; i++) {
            left[i] = arr[left[i - 1]] > arr[i] ? i : left[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = arr[right[i + 1]] < arr[i] ? i : right[i + 1];
        }

        int i = 0;
        int j = 0;
        int diff = 0;
        while (i < n && j < n) {
            if (arr[right[i]] > arr[left[j]]) {
                diff = Math.max(diff, right[i] - left[j]);
                i++;
            } else {
                j++;
            }

        }
        return diff;
    }

    public static void main(String[] args) {
        MaximumIndexDiff assign = new MaximumIndexDiff();
        int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
        int n = arr.length;
        int maxDiff = assign.findDiff(arr, n);
        System.out.println(maxDiff);

    }
}