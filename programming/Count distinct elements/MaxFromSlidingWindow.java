import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxFromSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1,-1};
        int k = 1;
 
        int[] res = findDistinctElement(arr, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
 
     public static int[] findDistinctElement(int[] arr, int k) {
         int start = 0;
         int end = k-1;
        
         List<Integer> list = new ArrayList<>();
         HashMap<Integer, Integer> map = new HashMap<>();
         while(end != arr.length) {
             for (int i = start; i <= end; i++) {
                 map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
             }
             list.add(getList(map));
             map.clear();
             start++;
             end++;
         }
         return list.stream().mapToInt(i -> i).toArray();
        
     }

     private static int getList(HashMap<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getKey() - o1.getKey();
            }
        });
        Map.Entry<Integer, Integer> l = list.get(0);
        return l.getKey();
    }
 
}
