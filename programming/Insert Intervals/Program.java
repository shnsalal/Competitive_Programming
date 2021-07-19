import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        int[][] res = insertInterval(intervals, newInterval);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i]);
            }
            System.out.println();
        }
    }

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }

        int arr[] = newInterval;
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            arr[0] = Math.min(intervals[i][0], newInterval[0]);
            arr[1] = Math.max(intervals[i++][1], newInterval[1]);
        }
        list.add(arr);

        while (i < intervals.length) {
            list.add(intervals[i++]);
        }

        return list.toArray(new int[list.size()][2]);
    }
}