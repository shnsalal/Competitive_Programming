import java.util.HashMap;

public class SlidingWindowProgram {
    public static void main(String[] args) {
       int[] arr = {1,3,-1,-3,5,3,6,7};
       int k = 3;

       findDistinctElement(arr, k);

    }

    public static void findDistinctElement(int[] arr, int k) {
        int start = 0;
        int end = k-1;

        HashMap<Integer, Integer> map = new HashMap<>();
        while(end != arr.length) {
            for (int i = start; i <= end; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            System.out.print(map.size() + "\t");
            map.clear();
            start++;
            end++;
        }
    }

}