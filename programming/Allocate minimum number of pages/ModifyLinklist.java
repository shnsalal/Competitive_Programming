public class ModifyLinklist {
    public static void main(String[] args) {
        process();
    }

    public static void process() {
        int size = 0;
        Node root = createLinklist();
        Node node = root;
        while (node != null) {
            size++;
            node = node.next;
        }

        int[] arr = new int[(size / 2) + 1];
        int arrSize = arr.length - 1;

        node = root;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = node.data;
            node = node.next;
        }

        node = root;
        for (int i = 0; i < size; i++) {
            if (i >= size / 2) {
                node.data = node.data + arr[arrSize];
                arrSize--;
            }
            node = node.next;
        }

        while (root != null) {
            System.out.print(root.data + "\t");
            root = root.next;
        }
    }

    private static Node createLinklist() {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        return root;
    }
}

class Node {
    int data;
    Node next = null;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
