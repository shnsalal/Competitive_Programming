public class TwoDArray {
    public static void main(String[] args) {
        char[][] arr = { { 'a', 'b', 'a', 'b' }, { 'c', 'd', 'a' } };
        int len = arr.length;
        char[][] res = new char[len][len * len];
        System.out.println(arr.length * arr.length);

        // for (int i = 0; i < res[1].length; i++) {
        // System.out.println(arr[i]);
        // }

        System.out.println(arr.length);
    }
}
