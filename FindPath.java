import java.util.LinkedList;
import java.util.Queue;

public class FindPath {
    public static void main(String[] args) {
        // int matrix[][] = { { 0, 3, 1, 0 }, { 3, 0, 3, 3 }, { 2, 3, 0, 3 }, { 0, 3, 3,
        // 3 } };

        int matrix[][] = { { 0, 3, 0, 1 }, { 3, 0, 3, 3 }, { 2, 3, 3, 3 }, { 0, 3, 3, 3 } };
        System.out.println(isPath(matrix, 4));
    }

    public static boolean isPath(int matrix[][], int n) {
        boolean[][] isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    isVisited[i][j] = true;
                    return dfs(matrix, isVisited, i, j);
                }
            }
        }
        return false;
    }

    static Queue<Pair> queue = new LinkedList<>();

    private static boolean dfs(int[][] matrix, boolean[][] isVisited, int i, int j) {
        if ((isSafe(i + 1, j, matrix.length) && (matrix[i + 1][j] == 2))
                || (isSafe(i, j + 1, matrix.length) && matrix[i][j + 1] == 2)
                || (isSafe(i - 1, j, matrix.length) && matrix[i - 1][j] == 2)
                || (isSafe(i, j - 1, matrix.length) && matrix[i][j - 1] == 2)) {
            for (int j2 = 0; j2 < isVisited.length; j2++) {
                for (int k = 0; k < isVisited.length; k++) {
                    if (isVisited[j2][k]) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(0 + " ");
                    }

                }
                System.out.println();
            }
            return true;
        }

        if (isSafe(i + 1, j, matrix.length) && matrix[i + 1][j] == 3 && !isVisited[i + 1][j]) {
            isVisited[i + 1][j] = true;
            if (dfs(matrix, isVisited, i + 1, j)) {
                return true;
            }
        }

        if (isSafe(i, j + 1, matrix.length) && matrix[i][j + 1] == 3 && !isVisited[i][j + 1]) {
            isVisited[i][j + 1] = true;
            if (dfs(matrix, isVisited, i, j + 1)) {
                return true;
            }
        }

        if (isSafe(i - 1, j, matrix.length) && matrix[i - 1][j] == 3 && !isVisited[i - 1][j]) {
            isVisited[i - 1][j] = true;
            if (dfs(matrix, isVisited, i - 1, j)) {
                return true;
            }
        }

        if (isSafe(i, j - 1, matrix.length) && matrix[i][j - 1] == 3 && !isVisited[i][j - 1]) {
            isVisited[i][j - 1] = true;
            if (dfs(matrix, isVisited, i, j - 1)) {
                return true;
            }
        }

        return false;
    }

    private static void find(int[][] matrix, int i, int j) {
        if (isSafe(i, j, matrix.length) && matrix[i][j] == 2) {
            System.out.println("YES");
            return;
        }

        if (isSafe(i, j, matrix.length) && matrix[i][j] == 3) {
            find(matrix, i + 1, j);
            find(matrix, i, j + 1);
            find(matrix, i - 1, j);
            find(matrix, i, j - 1);
        }
    }

    private static boolean isSafe(int i, int j, int length) {
        return (i >= 0 && j >= 0 && i < length && j < length);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}