public class Program {
    public static void main(String[] args)
    {
 
        int arr[] = { 3, 1, 5, 9, 12};
        int n = arr.length;
        
        // Function call
        if (findPartition(arr, n) == true)
            System.out.println("Can be divided into two "
                               + "subsets of equal sum");
        else
            System.out.println(
                "Can not be divided into "
                + "two subsets of equal sum");
    }

    public static boolean findPartition(int[] arr, int  n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if(sum % 2 == 0) {
            return subsetSum(arr, n, sum/2);
        } else {
            return false;
        }
    }

    public static boolean subsetSum(int[] arr, int  n, int sum) {
        if(sum == 0) {
            return true;
        }

        if(n == 0 || sum < 0) {
            return false;
        }

        if(arr[n-1] > sum) {
            return subsetSum(arr, n-1, sum);
        } else {
            return subsetSum(arr, n-1, sum) ||  subsetSum(arr, n-1, sum - arr[n-1]);
        }
    }
}