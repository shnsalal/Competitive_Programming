import java.util.Map;
import java.util.TreeMap;

public class RelativeSorting {
    public static void main(String[] args) {
        int[] first = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        int[] second = { 2, 1, 4, 3, 9, 6 };
        int[] res = sort(first, second);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }

    private static int[] sort(int[] first, int[] second) {
        Map<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            map.put(first[i], map.getOrDefault(first[i], 0) + 1);
        }

        int i = 0;
        int index = 0;
        while (i < second.length) {
            int n = 0;
            if (map.containsKey(second[i])) {
                n = map.get(second[i]);
            } else {
                i++;
                continue;
            }
            while (n-- != 0) {
                res[index] = second[i];
                index++;
            }
            map.remove(second[i]);
            i++;
        }

        for (var entry : map.entrySet()) {
            int n = entry.getValue();
            while (n-- != 0) {
                res[index] = entry.getKey();
                index++;
            }
        }

        return res;
    }
}