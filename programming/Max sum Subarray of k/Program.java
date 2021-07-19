import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        int arr[] = {4,-2}; 
        int k = 2; 
        int n = arr.length; 
        // System.out.println(maxSum(arr, n, k));
        // System.out.println(maxSlidingWindow(arr,k)); 
        int[] res = maxSlidingWindow(arr,k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    // public static int maxSum(int[] arr, int n, int k) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int sum = 0;
    //     int j = 0;
    //     int max = 0;
    //     for (int i = 0; i < k; i++) {
    //         sum += arr[i];
    //         map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
    //     }

    //     max = Math.max(max, sum);

    //     for (int i = k; i < n; i++) {
    //         int presentInMap = map.getOrDefault(arr[j], 0);

    //         if(presentInMap > 1) {
    //             map.put(arr[j], map.get(arr[j])-1);
    //         } else {
    //             map.remove(arr[j]);
    //         }
    //         map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
    //         sum = sum - arr[j++] + arr[i];
    //         max = Math.max(max, sum);
    //     }

    //     return max;
    // }


    public static int[] maxSlidingWindow(int[] nums, int k) {
       int res[] = new int[nums.length];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();


        for(int i = 0; i < k; i++) {
            list1.add(nums[i]);
        }
        
        res[0] = Collections.max(list1);
        
        for(int i = k; i < nums.length; i++) {
            list1.remove(0);
            list1.add(nums[i]);
            // list2.add(Collections.max(list1));
            res[i-k+1] = Collections.max(list1);
        }
        // return list2.stream().mapToInt(i -> i).toArray();
        return res;
    }
}