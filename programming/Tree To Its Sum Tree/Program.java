
public class Program {
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(-2);
        node.right = new Node(5);
        
        node.left.left = new Node(8);
        node.left.right = new Node(-4);

        node.right.left = new Node(6);
        node.right.right = new Node(7);

        var sTree = new SumTree();
        Node newRoot  = sTree.getNode(node);

        sTree.display(newRoot);

    }
}

class SumTree {

    public Node getNode(Node node) {
        reformTree(node);
        return node;
    }

    // public int reformTree(Node node) {
    //     int nextLeftData;
    //     int nextRightData;

    //     if(node == null) {
    //         return 0;
    //     }

    //     if(node.right != null && node.left == null) {
    //         nextLeftData = 0;
    //         nextRightData = node.right.data;
    //     } else if(node.left != null && node.right == null) {
    //         nextLeftData = node.left.data;
    //         nextRightData = 0;
    //     } else if (node.left == null && node.right == null) {
    //         nextLeftData = 0;
    //         nextRightData = 0;
    //     } else {
    //         nextLeftData = node.left.data;
    //         nextRightData = node.right.data;
    //     } 

    //     int leftData = reformTree(node.left);
    //     int rightData = reformTree(node.right);

    //     // node.data = nextLeftData + nextRightData;
    //     int sum = nextLeftData + nextRightData
    //     + leftData + rightData;
    //     node.data = sum;
    //     return sum;
    // }

    public int reformTree(Node node) {
        if(node == null) {
            return 0;
        }

        int oldValue = node.data;

        node.data = reformTree(node.left) + reformTree(node.right);

        return node.data + oldValue;
    }

    public void display(Node node) {
        if(node == null) {
            return;
        }
        display(node.left);
        System.out.println(node.data);
        display(node.right);
    }
}

class Node {
    public int data;
    public Node left;
    public Node right;

   Node(int data) {
        this.data = data;
        //left = right = null;
    }
}