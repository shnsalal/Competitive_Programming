public class ConvertbtToDLL {
    public Node root;
    Node head, tail = null;
    Node parent;
    int flag = 0;

    public static void main(String[] args) {
        ConvertbtToDLL bt = new ConvertbtToDLL();
        // Add nodes to the binary tree
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.left = new Node(6);
        bt.root.right.right = new Node(7);

        bt.convertbtToDLL(bt.root);
        bt.display(bt.head);
    }

    private void display(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        display(head.right);
    }

    private void convertbtToDLL(Node rNode) {
        if (rNode == null) {
            return;
        }

        convertbtToDLL(rNode.left);

        if (flag == 0) {
            parent = rNode;
            head = rNode;
            flag = 1;
        } else {
            parent.right = rNode;
            rNode.left = parent;
            parent = rNode;
        }
        convertbtToDLL(rNode.right);
    }

}
