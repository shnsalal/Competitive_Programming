public class Program {
    public static void main(String[] args) 
    { 
        int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 }; 
        int x = 8; 
        System.out.println("first : " + findFirst(arr, x));
        System.out.println("last : " + findLast(arr, x));
    }

    public static int findFirst(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        int res = -1;

        while(low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] == x) {
                res = mid;
                high = mid - 1;
            } else if (x > arr[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return res;
    }

    public static int findLast(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        int res = -1;

        while(low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] == x) {
                res = mid;
                low = mid + 1;
            } else if (x > arr[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return res;
    }
}