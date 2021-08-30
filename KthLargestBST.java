
import java.util.concurrent.atomic.AtomicInteger;

public class KthLargestBST {
    static int count;

    public static void main(String[] args) {
        Node root = null;
        int[] keys = { 13, 14, 22, 25, 23, 32, 26, 28, 40 };

        for (int key : keys) {
            root = insert(root, key);
        }
        // kthLargestBST(root, 3);
        int k = 3;
        int res = kthLargestBST(root, k);

        if (res != Integer.MAX_VALUE) {
            System.out.print(res);
        } else {
            System.out.print("Invalid Input");
        }

        inOrder(root);
    }

    private static Node kthLargest(Node root, int k) {
        if (root == null) {
            return null;
        }

        if (root.right != null) {
            return kthLargest(root.right, k);
        }

        if (++count == k) {
            return root;
        }
        return kthLargest(root.left, k);
    }

    private static int kthLargestBST(Node root, int k) {
        Node node = kthLargest(root, k);
        if (node == null) {
            return Integer.MAX_VALUE;
        } else {
            return node.data;
        }
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        System.out.print(root.data + " ");
        inOrder(root.left);
    }

    private static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (root.data < key) {
            root.right = insert(root.right, key);
        } else {
            root.left = insert(root.left, key);
        }
        return root;
    }
}
