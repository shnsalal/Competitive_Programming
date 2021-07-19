import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TaskProcessing {
    public static void main(String[] args) {
        System.out.println(solution(Arrays.asList(4, 3), Arrays.asList(6, 5), Arrays.asList(8, 8)));
    }

    private static long solution(List<Integer> batchSize, List<Integer> processingTime, List<Integer> task) {
        Stack<Integer> batchQueue = new Stack<>();
        Queue<Integer> index = new LinkedList<>();
        long res = 0;
        int time = 0;
        for (int i = 0; i < batchSize.size(); i++) {
            batchQueue.push(batchSize.get(batchSize.size() - i - 1));
            index.add(i);
        }

        while (!batchQueue.isEmpty()) {
            int b = batchQueue.pop();
            int i = index.peek();
            int t = processingTime.get(i);
            time = Math.max(t, time);
            if (b < task.get(i)) {
                time = Math.max(time, time + t);
                res = Math.max(res, time);
                batchQueue.push(b + batchSize.get(i));
            } else {
                index.poll();
                time = 0;
            }
        }
        return res;
    }
}