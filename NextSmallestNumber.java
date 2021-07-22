// Find next smallest palindrome larger than this given number Asked in: Flipkart, Oracle
public class NextSmallestNumber {
    static boolean isAll9(int array[], int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] != 9) {
                return false;
            }
        }
        return true;
    }

    static void nextPalindromeProblem(int array[], int n) {
        if (isAll9(array, n)) {
            System.out.print("1");
            for (int i = 0; i < n - 1; i++) {
                System.out.print("0");
            }
            System.out.print("1");
        } else {
            findNextPalindrome(array, n);
            printarray(array, n);
        }
    }

    private static void findNextPalindrome(int[] array, int n) {
        // find the index of mid digit
        int mid = n / 2;
        // end of left side is always 'mid -1'
        int i = mid - 1;
        // Beginning of right side depends if n is odd or even
        int j = (n % 2 == 0) ? mid : mid + 1;
        // A bool variable to check if copy of left side to right is sufficient or not
        boolean leftsmaller = false;

        while (i >= 0 && array[i] == array[j]) {
            i--;
            j++;
        }
        // Find if the middle array(s) need to be incremented or not (or copying left
        // side is not sufficient)
        if (i < 0 || array[i] < array[j]) {
            leftsmaller = true;
        }
        // Copy the mirror of left to right
        while (i >= 0) {
            array[j++] = array[i--];
        }
        // Handle the case where middle digit(s) must be incremented.  
        if (leftsmaller) {
            int carry = 1;
            // If there are odd digits, then increment the middle digit and store the carry
            if (n % 2 == 1) {
                array[mid] += 1;
                carry = array[mid] / 10;
                array[mid] %= 10;
            }
            i = mid - 1;
            j = (n % 2 == 0 ? mid : mid + 1);
            // Add 1 to the rightmost digit of the left side, propagate the carry towards
            // MSB digit and simultaneously copying mirror of the left side to the right
            // side
            while (i >= 0 && carry > 0) {
                array[i] = array[i] + carry;
                carry = array[i] / 10;
                array[i] %= 10;
                array[j] = array[i];
                i--;
                j++;
            }

        }
    }

    static void printarray(int array[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(array[i]);
    }

    public static void main(String[] args) {
        int array[] = { 8, 3, 1, 7, 7, 9, 7, 9, 3, 2, 3 };
        // int array[] = { 2, 3, 5, 4, 5 };
        nextPalindromeProblem(array, array.length);
    }
}
