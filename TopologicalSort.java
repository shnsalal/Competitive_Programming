import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {

        Topological t = new Topological();
        t.insert(4, 12);
        t.insert(12, 34);
        t.insert(6, 4);
        t.insert(6, 8);
        t.insert(10, 8);
        t.insert(10, 34);
        t.topologicalSort();
        t.display();
    }
}

class Topological {
    Map<Integer, List<Integer>> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();

    Topological() {

    }

    public void topologicalSort() {
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println(entry.getKey());
                topologicalSort(entry.getKey());
            }
        }
    }

    private void topologicalSort(Integer key) {
        //
        // int size = map1.get(key).size();
        if (map1.get(key) != null) {
            List<Integer> list = map1.get(key);
            for (Integer l : list) {
                map2.put(l, map2.get(l) - 1);
                if (map2.get(l) == 0) {
                    System.out.println(l);
                    topologicalSort(l);
                }
            }
        }
        map2.put(key, map2.get(key) - 1);

    }

    public void insert(int v, int e) {
        map1.putIfAbsent(v, new ArrayList<>());
        map1.get(v).add(e);

        map2.putIfAbsent(v, 0);
        map2.putIfAbsent(e, 0);
        map2.put(e, map2.get(e) + 1);
    }

    void display() {
        for (Map.Entry<Integer, List<Integer>> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
