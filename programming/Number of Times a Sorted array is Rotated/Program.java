public class Program {
    public static void main (String[] args)  
    { 
        int arr[] = {15, 18, 2, 3, 6, 12}; 
        int n = arr.length; 
      
        System.out.println(countRotations(arr, n)); 
    }

    public static int countRotations(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;
        int res = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (n + mid + 1) % n;

            if(arr[prev] > arr[mid] && arr[mid] < arr[next]) {
                res = mid;
            }

            if(arr[high] - arr[mid] < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}