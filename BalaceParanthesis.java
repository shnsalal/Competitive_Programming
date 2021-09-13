public class BalaceParanthesis {
    public static void main(String[] args) {
        int n = 3;
        printBalanceParanthesis(n);
    }

    private static void printBalanceParanthesis(int n) {
        char[] arr = new char[n * 2];
        int index = 0;
        int openBracket = 0;
        int closingBracket = 0;
        printBalanceParanthesis(arr, n, index, openBracket, closingBracket);
    }

    private static void printBalanceParanthesis(char[] arr, int n, int index, int openBracket, int closingBracket) {
        if (closingBracket == n) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {

            if (closingBracket < openBracket) {
                arr[index] = '}';
                printBalanceParanthesis(arr, n, index + 1, openBracket, closingBracket + 1);
            }
            if (openBracket < n) {
                arr[index] = '{';
                printBalanceParanthesis(arr, n, index + 1, openBracket + 1, closingBracket);
            }
        }
    }

}
