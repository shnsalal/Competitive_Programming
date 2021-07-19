
public class Program {
    public static void main(String[] args) {
        int  arr[] = new int[] {2, 3, 7,8,10};
        int target = 16;
        int n = arr.length;
        Solution s = new Solution(n, target);
        System.out.println(s.findSum(arr, arr.length, target)); 
    }

    // //Recursion
    

    
}

//Recursion
// class Solution {
//     public static boolean findSum(int[] arr, int target, int n) {
//         if(n == 0 || target < 0) {
//             return false;
//         }
//         if(target == 0 || arr[n-1] == target) {
//             return true;
//         }
//         if(arr[n-1] > target) {
//             return findSum(arr, target, n-1);
//         } else {
//             return findSum(arr, target, n-1) || findSum(arr, target - arr[n-1], n-1);
//         }
//     }
// }


//Memoization
// class Solution {
//     boolean[][] dp;

//     public Solution(int n, int target) {
//         dp = new boolean[n+1][target+1];
//         for (int i = 0; i < dp.length; i++) {
//             for (int j = 0; j < dp[0].length; j++) {
//                 if(j == 0) {
//                     dp[i][j] = true;
//                 }
//             }
//         }
//     }

//     public boolean findSum(int[] arr, int n, int target) {
//         if(target == 0) {
//             return true;
//         }
//         if(n == 0 || target < 0) {
//             return false;
//         }
//         if(dp[n][target] != false) {
//             return dp[n][target];
//         }
//         if(arr[n-1] > target) {
//             return dp[n][target] = findSum(arr, n-1, target);
//         } else {
//             return dp[n][target] = findSum(arr, n-1, target - arr[n-1]) || findSum(arr, n-1, target);
//         }
//     }
// }


//dp bottom-up
class Solution {
    boolean[][] dp;

    public Solution(int n, int target) {
        dp = new boolean[n+1][target+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j == 0) {
                    dp[i][j] = true;
                }
            }
        }
    }

       public boolean findSum(int[] arr, int n, int target) {
       for (int i = 1; i <= n; i++) {
           for (int j = 1; j <= target; j++) {
            if(arr[i-1] > j) {
                dp[i][j] = dp[i-1][j];
            } else {
                dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
            }
           }
        }
        return dp[n][target];
    }
}