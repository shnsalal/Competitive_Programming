public class Program {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,5};
        int k = 8;
        System.out.print(findNearestSorted(arr, k));
    }

    public static int findNearestSorted(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        int mid;
        // int res = 0;
        
        while(low <= high) {
            mid = low + (high - low)/2;

            if(arr[mid] == k) {
                return mid;
            }
            if(mid >= 0 && arr[mid - 1] == k) {
                return mid - 1;
            }
            if(mid < arr.length && arr[mid + 1] == k ) {
                return mid + 1;
            }

            if(arr[mid] > k) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }
        return -1;
    }
}