public class Program {
    public static void main(String[] args)
    {
 
        int arr[] = {  3, 1, 5, 9, 8, 10};
        int sum = 10;
        int n = arr.length;
        int count = 0;
        System.out.println(subsetSum(arr, n, sum, count));
    }

    public static int subsetSum(int[] arr, int  n, int sum, int count) {
        if(sum == 0) {
            return count+1;
        }

        if(n == 0 || sum < 0) {
            return 0;
        }

        if(arr[n-1] > sum) {
            return subsetSum(arr, n-1, sum, count);
        } else {
            return subsetSum(arr, n-1, sum, count) + subsetSum(arr, n-1, sum - arr[n-1], count);
        }
    }
}