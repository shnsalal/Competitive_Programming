
public class KnapsackProblem {
        
    public static void main(String[] args) {
        int  val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        // int val[] = new int[] { 4, 5, 1, 2, 10 }; 
        // int wt[] = new int[] { 12, 2, 1, 1, 4 }; 
        // int W = 15; 
        int n = val.length; 
        Solution s = new Solution(n,W);
        System.out.println(s.knapSack(W, wt, val, n)); 
    }

    // Recursion
    // public static int knapSack(int W, int[] wt, int[] val, int n) {
    //     if(n == 0 || W == 0) {
    //         return 0;
    //     }
    //     if(wt[n-1] <= W) {
    //         return Math.max(val[n-1] + knapSack(W - wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
    //     } else {
    //         return knapSack(W, wt, val, n-1);
    //     }
    // }

    
}

//Memoization
// class Solution {
//     int[][] dp;

//     public Solution(int n, int W) {
//         dp = new int[n+1][W+1];
//         for (int i = 0; i < dp.length; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//     }

//     public int knapSack(int W, int[] wt, int[] val, int n) {
//         if(n == 0 || W == 0) {
//             return 0;
//         }
//         if(dp[n][W] != -1) {
//             return dp[n][W];
//         }
//         if(wt[n-1] <= W) {
//             return dp[n][W] = Math.max(val[n-1] + knapSack(W - wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
//         } else {
//             return dp[n][W] = knapSack(W, wt, val, n-1);
//         }
//     }
// }


//dp bottom-up
class Solution {
    int[][] dp;

    public Solution(int n, int W) {
        dp = new int[n+1][W+1];
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         if(i == 0) {
        //             dp[i][j] = 0;
        //         }
        //         if(j == 0) {
        //             dp[i][j] = 0;
        //         }
        //     }
        // }
    }

    public int knapSack(int W, int[] wt, int[] val, int n) {
       for (int i = 1; i <= n; i++) {
           for (int j = 1; j <= W; j++) {
                if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
           }
        }
        return dp[n][W];
    }
}