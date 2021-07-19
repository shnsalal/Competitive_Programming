

public class Student {
    public final static void main(String[] args) {
        int arr[] = {0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int key = 14;

        int low = 0;
        int high = 1;
        while(!(0 == arr[low] && 1 == arr[high])) {
            low = high;
            high = high * 2;
        }
        int result = binarySearch(low, high, key, arr);
        if(result == -1) {
            System.out.println("Not found");
        } else {
            System.out.println(result);
        }
    }

    public static int binarySearch(int low, int high, int key, int[] arr) {
        int l = low;
        int h = high;
        int mid;
        while(l <= h) {
            mid = (l + h)/2;
            
            if(1 == arr[mid]) {
               h = mid-1;
            } else {
                l = mid+1;
            }
           
        }
        return h+1;
    } 
}