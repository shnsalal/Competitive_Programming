public class Program {
    public static void main(String[] args)  
    { 
        int arr[] = {1,2,7}; 
        int n = arr.length; 
        System.out.print("The minimum difference"+ 
                        " between two sets is " +  
                         findMin(arr, n)); 
    }

    public static int findMin(int[] arr, int n) {
        int sumCalculated = 0;
        int totalSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        return findMinSubsetSum(arr,n,sumCalculated,totalSum);
    }

    public static int findMinSubsetSum(int[] arr, int n, int sumCalculated, int totalSum) {
        if(n == 0) {
            return Math.abs((totalSum - sumCalculated) - sumCalculated);
        }
        return Math.min(findMinSubsetSum(arr, n-1, sumCalculated, totalSum), 
                        findMinSubsetSum(arr, n-1, sumCalculated + arr[n-1], totalSum));
    }
}