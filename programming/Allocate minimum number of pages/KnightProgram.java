import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KnightProgram {
    public static void main(String[] args) {
        int N = 30;
        int[] knightPos = { 1, 1 };
        int[] targetPos = { 4, 5 };
        System.out.println(minStepToReachTarget(knightPos, targetPos, N));
    }

    private static int minStepToReachTarget(int[] knightPos, int[] targetPos, int n) {
        boolean[][] isVisited = new boolean[n + 1][n + 1];
        int[][] count = new int[n + 1][n + 1];

        // for (int i = 0; i < count.length; i++) {
        // count[i][i] = Integer.MAX_VALUE;
        // }

        var list = directions();
        var queue = new LinkedList<Axis>();
        int previousCount;

        queue.add(new Axis(knightPos[0], knightPos[1]));
        while (!queue.isEmpty()) {
            Axis currentCell = queue.poll();
            for (Axis axis : list) {
                if (currentCell.x - axis.x >= 0 && currentCell.y - axis.y >= 0 && currentCell.x - axis.x <= n
                        && currentCell.y - axis.y <= n && !isVisited[currentCell.x - axis.x][currentCell.y - axis.y]) {
                    queue.add(new Axis(currentCell.x - axis.x, currentCell.y - axis.y));
                    int[] res = new int[] { currentCell.x - axis.x, currentCell.y - axis.y };
                    previousCount = count[currentCell.x][currentCell.y];
                    isVisited[currentCell.x - axis.x][currentCell.y - axis.y] = true;

                    if (res[0] == targetPos[0] && res[1] == targetPos[1]) {
                        count[currentCell.x - axis.x][currentCell.y - axis.y] = previousCount + 1;
                        return count[targetPos[0]][targetPos[1]];
                    } else {
                        count[currentCell.x - axis.x][currentCell.y - axis.y] = previousCount + 1;
                    }

                    // count[currentCell.x - axis.x][currentCell.y - axis.y]
                    // = Math.min(count[currentCell.x - axis.x][currentCell.x - axis.x] + 1,
                    // count[currentCell.x - axis.x][currentCell.x - axis.x]);

                }
            }
        }
        return count[targetPos[0]][targetPos[1]];
    }

    private static List<Axis> directions() {
        var list = new ArrayList<Axis>();
        list.add(new Axis(-2, 1));
        list.add(new Axis(-2, -1));
        list.add(new Axis(-1, 2));
        list.add(new Axis(-1, -2));
        list.add(new Axis(1, 2));
        list.add(new Axis(1, -2));
        list.add(new Axis(2, 1));
        list.add(new Axis(2, -1));
        return list;
    }
}

class Axis {
    int x;
    int y;

    public Axis() {
    }

    public Axis(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
