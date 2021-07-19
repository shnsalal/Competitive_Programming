import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Program {
  public static void main(String[] args) {
    int[] price = { 100, 80, 60, 70, 60, 75, 85}; 
    calculateSpan(price); 
  }

  public static void calculateSpan(int[] price) {
    Stack<pair> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < price.length; i++) {
        if(stack.isEmpty()) {
            list.add(-1);
        } else if(!stack.isEmpty() && stack.peek().value > price[i]) {
            list.add(stack.peek().index);
        } else if(!stack.isEmpty() && stack.peek().value <= price[i]) {
            while(!stack.isEmpty() && stack.peek().value <= price[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                list.add(-1);
            } else if(!stack.isEmpty() && stack.peek().value > price[i]) {
                list.add(stack.peek().index);
            }
        }
        stack.push(new pair(price[i], i));
    }
    getSpan(price, list.stream().mapToInt(i -> i).toArray());
  }

  public static void getSpan(int[] price, int[] list) {
    List<Integer> resultList = new ArrayList<>();
    for (int i = 0; i < price.length; i++) {
        resultList.add(i - list[i]);
    }
    System.out.println(resultList);
  }
}

class pair {
    int value;
    int index;
    public pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}





// import java.util.ArrayList;
// import java.util.Stack;

// public class Program {
//     public static void main(String[] args) {
//       int[] stock = { 1, 4, 5, 2, 20}; 
//       System.out.println(maxProfit(stock)); 
//     }

    // public static int maxProfit(int[] A) {
    //     int[] stock = A;
    //     int max = 0;
    //     int res = 0;
    //     for (int i = 0; i < stock.length; i++) {
    //         max = stock[i];
    //         for (int j = i; j < stock.length-1; j++) {
    //             if(stock[j] > stock[j+1]) {
    //                 break;
    //             }
    //             max = stock[j+1];
    //         }
    //         res = Math.max(res, max-stock[i]);
    //     }
    //     return res;
    // }

//     public static int maxProfit(int[] A) {
//         int[] stock = A;
//         Stack<Pair> stack = new Stack<>(); 
//         ArrayList<Integer> list = new ArrayList<>();
//         for (int i = 0; i < stock.length; i++) {
//             if(stack.isEmpty()) {
//                 list.add(0);
//             } else if(!stack.isEmpty() && stack.peek().value < stock[i]) {
//                 list.add(stack.peek().index);
//             } else if(!stack.isEmpty() && stack.peek().value >= stock[i]) {
//                 while(!stack.isEmpty() && stack.peek().value >= stock[i]) {
//                     stack.pop();
//                 }
//                 if(stack.isEmpty()) {
//                     list.add(0);
//                 } else if(!stack.isEmpty() && stack.peek().value < stock[i]) {
//                     list.add(stack.peek().index);
//                 }
//             }
//             stack.push(new Pair(stock[i], i));
//         }

//         return profit(stock, list.stream().mapToInt(i -> i).toArray());
//     }

//     public static int profit(int[] stock, int[] list) {
//         int res = 0;
//         for (int i = 0; i < stock.length; i++) {
//             res = Math.max(res, stock[i]-stock[list[i]]);
//         }
//         return res;
//     }
// }

// class Pair {
//     int value;
//     int index;

//     public Pair(int value, int index) {
//         this.value = value;
//         this.index = index;
//     }
// }