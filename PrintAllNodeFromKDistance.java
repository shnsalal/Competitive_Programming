public class PrintAllNodeFromKDistance {
    Node root;

    void findNode_DistanceDown(Node node, int k) {
        if (node == null) {
            return;
        }

        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }

        findNode_DistanceDown(node.left, k - 1);
        findNode_DistanceDown(node.right, k - 1);
    }

    public static void main(String args[]) {
        PrintAllNodeFromKDistance tree = new PrintAllNodeFromKDistance();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(8);

        tree.findNode_DistanceDown(tree.root, 0);
    }
}