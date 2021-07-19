public class Program {
    public static void main(String[] args) {
        int[] arr = {2,-30,3,-10, 0 ,6, -3, -10};
        System.out.println(findMaxProduct(arr));
    }

    public static int findMaxProduct(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int overall = max;
        for (int i = 1; i < arr.length; i++) {
            int temp = max;
            max = Math.max(arr[i], Math.max(arr[i]*max, arr[i]*min));
            min = Math.min(arr[i], Math.min(arr[i]*temp, arr[i]*min));
            overall = Math.max(overall, max);
        }
        return overall;
    }
}