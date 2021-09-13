
public class Program {
    public static final int N = 5;

    private static void checkQueen(int board[][], int column) {
        if (column == board.length) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, column)) {
                board[row][column] = 1;
                checkQueen(board, column + 1);
                board[row][column] = 0;
            }

        }
    }

    private static boolean isSafe(int[][] board, int row, int column) {
        int i = row;
        int j = column;

        if (row >= board.length || column >= board.length) {
            return false;
        }

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            j--;
        }

        j = column;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = column;
        while (i >= 0 && j >= 0 && i < board.length) {
            if (board[i][j] == 1) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = new int[N][N];
        checkQueen(mat, 0);

    }

}
