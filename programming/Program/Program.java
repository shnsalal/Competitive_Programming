
public class Program {
    // static int[][] dp = new int[1000][1000];

    public Program() {

    }

    public static void main(String[] args) {
        String str = "abc d";
        int n = str.length();

        System.out.println("Minimum number of multiplications is " + MatrixChainOrderDp(str, 0, n - 1));
        // System.out.println("Minimum number of multiplications is " +
        // isPalindrome(str, 0, n - 1));
    }

    public static int MatrixChainOrder(String str, int i, int j) {
        int count = Integer.MAX_VALUE;

        if (i >= j) {
            return 0;
        }

        if (isPalindrome(str, i, j)) {
            return 0;
        }

        for (int k = i; k < j; k++) {
            // count = Math.min(count, MatrixChainOrder(str, i, k) + MatrixChainOrder(str, k
            // + 1, j) + 1);
            int temp = MatrixChainOrder(str, i, k) + MatrixChainOrder(str, k + 1, j) + 1;
            if (temp < count) {
                count = temp;
            }
        }

        return count;
    }

    public static int MatrixChainOrderDp(String str, int i, int j) {
        int[][] dp = new int[1000][1000];

        // for (int x = 0; x < dp.length; x++) {
        // for (int y = 0; y < dp.length; y++) {
        // if (i == j) {
        // dp[i][j] = 0;
        // }
        // }
        // }

        if (i >= j) {
            return 0;
        }

        // if (dp[i][j] != -1) {
        // return dp[i][j];
        // }

        if (isPalindrome(str, i, j)) {
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for (int n = 1; n < dp.length; n++) {
            for (int m = 1; m < dp.length; m++) {
                for (int k = n; k < m; k++) {
                    dp[n][m] = Math.max(count, dp[i][k] + dp[k + 1][j] + 1);
                }
            }
        }

        return dp[i][j];
    }

    public static Boolean isPalindrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
