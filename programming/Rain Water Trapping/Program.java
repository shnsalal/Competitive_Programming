public class Program {
    public static void main(String[] args) 
    { 
        int[] arr = {3, 0, 2, 0, 4}; 
        int n = arr.length; 
        System.out.println(maxWater(arr,n)); 
    }

    public static int maxWater(int[] arr, int n) {
        int[] maxFromLeft = getMaxFromLeft(arr);
        int[] minFromRight = getMaxFromRight(arr);
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            res += Math.min(maxFromLeft[i], minFromRight[i]) - arr[i];
        }
        return res;
    }

    public static int[] getMaxFromLeft(int[] arr) {
        int[] max = new int[arr.length];
        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(max[i-1], arr[i]);
        }
        return max;
    }

    public static int[] getMaxFromRight(int[] arr) {
        int[] max = new int[arr.length];
        max[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            max[i] = Math.max(max[i+1], arr[i]);
        }
        return max;
    } 
}