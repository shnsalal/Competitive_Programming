// Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum. 
// Example : 

// Input : pages[] = {12, 34, 67, 90}
//         m = 2
// Output : 113
// Explanation:
// There are 2 number of students. Books can be distributed 
// in following fashion : 
//   1) [12] and [34, 67, 90]
//       Max number of pages is allocated to student 
//       2 with 34 + 67 + 90 = 191 pages
//   2) [12, 34] and [67, 90]
//       Max number of pages is allocated to student
//       2 with 67 + 90 = 157 pages 
//   3) [12, 34, 67] and [90]
//       Max number of pages is allocated to student 
//       1 with 12 + 34 + 67 = 113 pages

// Of the 3 cases, Option 3 has the minimum pages = 113. 

public class BookAllocation {
    public static void main(String[] args) {
        // Number of pages in books
        int arr[] = { 12, 34, 67, 90 };

        int m = 2; // No. of students

        System.out.println("Minimum number of pages = " + findPages(arr, arr.length, m));
    }

    private static int findPages(int[] arr, int n, int m) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int start = 0;
        int end = sum;
        int result = -1;

        if (m > n) {
            return result;
        }

        while (start < end) {
            int mid = (start + end) / 2;
            if (isValid(arr, n, m, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean isValid(int[] arr, int n, int m, int mid) {
        int curr_sum = 0;
        int student = 1;
        for (int i = 0; i < n; i++) {
            curr_sum += arr[i];
            if (curr_sum > mid) {
                student++;
                curr_sum = arr[i];
            }

            if (student > m) {
                return false;
            }
        }
        return true;
    }
}