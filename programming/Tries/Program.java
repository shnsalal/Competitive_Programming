import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");
        trie.insert("mobile");
        trie.insert("abc");
        trie.insert("abcde");
        trie.search("abc");
        trie.search("abcde");
        trie.delete("abc");
        trie.search("abc");
        trie.delete("abcde");
        trie.search("abcde");
        trie.delete("app");
        trie.search("app");

    }
}

class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = current.map.get(ch);
            if(node == null) {
                node = new Node();
                current.map.put(ch, node);
            }
            current = node;
        }
        current.isEnd = true;
        System.out.println(word + " Inserted Successfully");
    }

    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = current.map.get(ch);
            if(node == null) {
               break;
            }
            current = node;
        }
        if(current.isEnd == true) {
            System.out.println(word + " Found");
            return true;
        } else {
            System.out.println(word + " Not Found");
            return false;
        }
        
    }
    
    public void delete(String word) {
        if(search(word) == true) {
            delete(root, word, 0);
        } else {
            System.out.println("Word not found");
        }
    }

    private boolean delete(Node parentNode, String word, int index) {
        Node children = parentNode.map.get(word.charAt(index));

        if(children.map.size() > 1) {
            delete(children, word, index+1);
            return false;
        }

        if(index == word.length() - 1) {
            if(children.map.size() >= 1) {
                children.isEnd = false;
                System.out.println(word + " can not delete it is dependent on other word");
                return false;
            } else {
                return true;
            }
        }

        boolean canThisNodeBeDeleted = delete(children, word, index+1);
        if(canThisNodeBeDeleted == true) {
            parentNode.map.remove(word.charAt(index));
            return true;
        } else {
            return false;
        }
    }
}

class Node {
    HashMap<Character, Node> map;
    boolean isEnd = false;

    public Node() {
        map  = new HashMap<>();
    }
}