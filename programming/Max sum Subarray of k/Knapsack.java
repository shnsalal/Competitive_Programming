public class Knapsack {
    public static void main(String[] args) {
        int A[] = new int[] {10, 20, 30, 40}; 
        int B[] = new int[] { 12, 13, 15, 19}; 
        int C = 10; 
        int n = A.length; 
        System.out.println(knapSack(C, B, A, n)); 
    }

    public static int knapSack(int C, int[] B, int[] A, int n) {

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length-i-1; j++) {
                if(A[j] > A[j+1]) {
                    int temp1 = B[j];
                    B[j] = B[j+1];
                    B[j+1] = temp1;

                    int temp2 = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp2;
                }
            }
        }


        int profit = 0;
        for (int i = n-1; i >= 0; i--) {
            if(B[i] <= C && C != 0) {
                C = C - B[i];
                profit += A[i]; 
            }
        }
        return profit;
    }
}
