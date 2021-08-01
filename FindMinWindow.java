/*
case 1: 
actual = findMinWindow("a","a")
expected = Smallest window is : a

case2: 
 actual = findMinWindow("zaaskzaa", "zsk")
 expected = Smallest window is : skz
 
case3: 
actual = findMinWindow("tutorial","oti")
expected = Smallest window is : tori


*/

public class FindMinWindow {
    static final int no_of_chars = 256;

    static String findMinWindow(String str, String pat) {
        int[] ascii_str = new int[no_of_chars];
        int[] ascii_ptr = new int[no_of_chars];
        int min = Integer.MAX_VALUE;
        int start_index = 0;

        int count = 0;

        for (int i = 0; i < pat.length(); i++) {
            ascii_ptr[pat.charAt(i)]++;
        }

        int i = 0;
        int j = 0;
        while (i < str.length()) {
            ascii_str[str.charAt(i)]++;

            if (ascii_ptr[str.charAt(i)] != 0 && ascii_str[str.charAt(i)] <= ascii_ptr[str.charAt(i)]) {
                count++;
            }

            if (count == pat.length()) {
                while (ascii_str[str.charAt(j)] > ascii_ptr[str.charAt(j)] || ascii_ptr[str.charAt(j)] == 0) {
                    if (ascii_str[str.charAt(j)] > ascii_ptr[str.charAt(j)]) {
                        ascii_str[str.charAt(j)]--;
                        j++;
                    }
                }

                if (min > i - j + 1) {
                    min = i - j + 1;
                    start_index = j;
                }
            }
            i++;
        }

        return str.substring(start_index, start_index + min);
    }

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String pat = "ABC";

        System.out.print("Smallest window is :\n " + findMinWindow(str, pat));
    }
}