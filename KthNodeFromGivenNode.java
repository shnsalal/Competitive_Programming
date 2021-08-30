public class KthNodeFromGivenNode {
    Node root;

    int printNodes(Node node, Node target, int k) {
        if (node == null) {
            return -1;
        }

        if (node == target) {
            printNodes(node, k);
            return 1;
        }

        int dLeft = printNodes(node.left, target, k);
        if (dLeft != -1) {
            if (dLeft + 1 == k) {
                System.out.println(node.data);
            } else {
                printNodes(node.right, k - dLeft - 1);
            }
            return dLeft + 1;
        }

        int dRight = printNodes(node.right, target, k);
        if (dRight != -1) {
            if (dRight + 1 == k) {
                System.out.println(node.data);
            } else {
                printNodes(node.left, k - dRight - 1);
            }
            return dRight + 1;
        }
        return -1;
    }

    private void printNodes(Node node, int k) {
        if (node == null) {
            return;
        }

        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }

        printNodes(node.left, k--);
        printNodes(node.right, k--);
    }

    public static void main(String args[]) {
        KthNodeFromGivenNode tree = new KthNodeFromGivenNode();

        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node target = tree.root.left.right;
        tree.printNodes(tree.root, target, 2);
    }
}
