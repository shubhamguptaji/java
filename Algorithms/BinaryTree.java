public class BinaryTree {
    public class Node {
        int data, r;
        Node left, right;

        public Node(int d) {
            data = d;
            r = 1;
            left = right = null;
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int d) {
        root = insertNode(root, d);
    }

    public Node insertNode(Node root, int d) {
        if (root == null)
            return new Node(d);
        else if (d < root.data) {
            root.r = root.r + 1;
            root.left = insertNode(root.left, d);
        } else if (root.data < d) {
            root.right = insertNode(root.right, d);
        }
        return root;
    }

    public void rank(int k) {
        System.out.println(rank(root, k));
    }

    public int rank(Node root, int k) {
        if (root == null)
            return 0;
        if (root.data == k)
            return root.r;
        else if (k < root.data) {
            return rank(root.left, k);
        } else
            return (root.r + rank(root.right, k));
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree();
        root.insert(10);
        root.insert(8);
        root.insert(9);
        root.insert(6);
        root.insert(15);
        root.insert(20);
        root.rank(20);
    }
}