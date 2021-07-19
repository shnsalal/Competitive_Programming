public class Program {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int x = 1;
        System.out.println(findsubetOfx(arr, x));
    }

    public static int findsubetOfx(int[] arr, int x) {
        int subset;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        subset = (x + sum) / 2;
        return NoOfsubset(arr, arr.length, subset);
    }

    public static int NoOfsubset(int[] arr, int n, int s) {
        if(s == 0) {
            return 1;
        }
        if(n == 0 || s < 0) {
            return 0;
        }
        if(arr[n-1] > s) {
            return NoOfsubset(arr, n-1, s);
        } else {
            return NoOfsubset(arr, n-1, s) +  NoOfsubset(arr, n-1, s - arr[n-1]);
        }
    }
}