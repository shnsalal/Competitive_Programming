import java.util.HashSet;

// Maximize count of non-overlapping subarrays with sum K

public class Program {
    public static void main(String[] args) 
    { 
        int arr[] = {-2, 6, 6, 3,  
                     5, 4, 1, 2, 8}; 
        int n = arr.length; 
        int k = 10; 
        System.out.println(subArray(arr, n, k)); 
    }
    
    public static int subArray(int arr[], int n, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }

        int[] newArray = hashSet.stream().mapToInt(i -> i).toArray();

        for (int i = 0; i < newArray.length; i++) {
            if(isSumEqualToK(newArray, newArray.length-i, k)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isSumEqualToK(int[] arr, int n, int k) {
        if(n == 0 || k < 0) {
            return false;
        }
        if(k == 0 || arr[n-1] == k) {
            return true;
        }
        if(arr[n-1] > k) {
            return isSumEqualToK(arr, n-1, k);
        } else {
            return isSumEqualToK(arr, n-1, k) || isSumEqualToK(arr, n-1, k - arr[n-1]);
        }
    }
}