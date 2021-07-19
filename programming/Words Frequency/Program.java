import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {
    public static void main(String[] args) throws IOException {


        InputStream is = new FileInputStream("input.txt"); 
        BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 
        String line = buf.readLine(); 
        StringBuilder sb = new StringBuilder();

        while(line != null){ 
            sb.append(line).append("\n"); 
            line = buf.readLine(); 
        } 
        String input = sb.toString();


        // Path fileName = Path.of("input.txt");
        // String input = Files.readString(fileName);

        int n = 3;
        findWordFrequency(input, n);
    }

    public static void findWordFrequency(String input, int n) {
        String[] words = input.toLowerCase().replaceAll("[^a-z]", " ")
        .replaceAll("\\s+", " ")
        .split(" ");
        HashMap<String, Integer>  map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);    
        }

        List<Map.Entry<String, Integer>> list = getList(map);
        System.out.println("Most Frequent");
        int i = 0;
        for (Map.Entry<String, Integer> l : list) {
            if(i < 3) {
                System.out.println(l.getKey()+ " : " +l.getValue());
            }
            i++;
        }

        System.out.println("Least Frequent");
        int j = list.size();
        for (Map.Entry<String, Integer> l : list) {
            if(j <= 3) {
                System.out.println(l.getKey()+ " : " +l.getValue());
            }
            j--;
        }
    }

    private static List<Map.Entry<String, Integer>> getList(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue() == o1.getValue()) {
                    return o2.getKey().compareTo(o1.getKey());
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        return list;
    }
}