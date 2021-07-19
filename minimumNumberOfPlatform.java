import java.util.Arrays;

// List of arrival and departure time is given, 
// Find the minimum number of platforms are required
// for the railway as no train waits

public class minimumNumberOfPlatform {
    static int minimumNumberOfPlatform(int array[], int departure[], int n) {
        int count = 0;
        int i = 0;
        int j = 0;
        int max = 0;
        Arrays.sort(departure);
        while (i < n && j < n) {
            if (array[i] < departure[j]) {
                count++;
                i++;
                max = Math.max(count, max);
            } else {
                count--;
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arrival = { 100, 140, 150, 200, 215, 400 };
        int[] departure = { 110, 300, 220, 230, 315, 600 };
        int n = arrival.length;

        System.out.print("Minimum platforms required is " + minimumNumberOfPlatform(arrival, departure, n));
    }
}
