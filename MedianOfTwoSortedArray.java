/* Try more Inputs
case 1: 
actual = find([1,3],[2],0,0,1,0)
expected = 2

case2: 
 actual = find([0,0],[0,0],0,0,1,1)
 expected = 0
 
case3: 
actual = find([2,7],[11,16],0,0,1,1)
expected = 9

case4: 
actual = find([1,2,3,6],[4,6,8,10],0,0,4,4)
expected = 5
*/

import java.util.*;

public class MedianOfTwoSortedArray {

    static int find(int[] first, int[] second, int start_f, int start_s, int end_f, int end_s) {
        int mid1 = (start_f + end_f) / 2;
        int mid2 = (start_s + end_s) / 2;

        int m1 = median(first, start_f, end_f);
        int m2 = median(second, start_s, end_s);

        if ((end_f - start_f) + 1 == 2 && (end_s - start_s + 1) == 2) {
            return (Math.max(first[start_f], second[start_s]) + Math.min(first[end_f], second[end_s])) / 2;
        }

        if (m1 == m2) {
            return m1;
        } else if (m1 > m2) {
            return find(first, second, start_f, mid2, mid1, end_s);
        } else {
            return find(first, second, mid1, start_s, end_f, mid2);
        }

        // if(first[m1] < second[m2])
    }

    static int median(int[] array, int start, int end) {
        int n = end - start + 1;
        if (n % 2 == 0) {
            return (array[start + (n / 2)] + array[start + (n / 2 - 1)]) / 2;
        } else {
            return array[start + n / 2];
        }
    }

    public static void main(String[] args) {
        // int first[] = { 1, 6, 8, 10, 12 };
        // int second[] = { 2, 3, 4, 9, 11 };
        int first[] = { 1, 2, 3, 6 };
        int second[] = { 4, 6, 8, 10 };
        int n1 = first.length;
        int n2 = second.length;
        if (n1 != n2) {
            System.out.println("size not equal");
        } else if (n1 == 0) {
            System.out.println("Arrays are empty.");
        } else if (n1 == 1) {
            System.out.println((first[0] + second[0]) / 2);
        } else {
            System.out.println("Median is " + find(first, second, 0, 0, first.length - 1, second.length - 1));
        }
    }
}
