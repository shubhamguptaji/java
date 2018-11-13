package BST;

public class BinarySearchTree{
    class Node { 
        int data;
        int key; 
        Node left, right; 
  
        public Node(int k) { 
            data = 1;
            key = k;
            left = right = null; 
        } 
    }
    Node root;
    public BinarySearchTree() {
        root = null;
    }

    public void insert(int k)   {
        root = insert(root, k);
    }

    private Node insert(Node root, int k) {
        if(root==null)
            return new Node(k);
        if(k==root.key) 
            root.data = data;
        else if(k<root.key)
            root.left = insert(root.left, k);
        else
            root.right = insert(root.right, k);
        return root;
    }

    public boolean isEmpty() {
        if(root == null)
            return true;
        return false;
    }

    public boolean search(int k) {
        int temp = search(root, k);
        if(temp == -1)
            return false;
        return true;
    }

    private int search(Node root, int k) {
        if(root==null) return -1;
        if(k==root.key) return root.data;
        else if(k<root.key) return search(root.left, k);
        else return search(root.right, k);
    }
    
    public void delete(int k) {
        root = delete(root, k);
        // if(root == null) System.out.println("Value does not exists!");
    }

    private Node findmin(Node root) {
        while(root.left!=null) root = root.left;
        return root;
    }

    private Node delete(Node root, int k) {
        if(isEmpty()) System.out.println("Tree is already empty!");
        if(root==null) return root;
        if(k<root.key) root.left = delete(root.left, k);
        else if(root.key<k) root.right = delete(root.right, k);
        else {
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else {
                Node temp = findmin(root.right);
                root.data = temp.data;
                root.key = temp.key;
                root.right = delete(root.right, root.key);
            }
        }
        return root;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // public static void main(String[] args) {
    //     BinarySearchTree tree = new BinarySearchTree();
    //     // tree.isEmpty();
    //     // System.out.println(tree.isEmpty());
    //     tree.insert(4,50);
    //     tree.delete(5);
    //     tree.insert(5,30); 
    //     System.out.println(tree.search(5));
    //     tree.insert(1,20); 
    //     tree.insert(3,40); 
    //     tree.insert(6,70); 
    //     tree.insert(2,60); 
    //     tree.insert(8,80);
    //     System.out.println(tree.isEmpty());
    //     System.out.print("Inorder : ");
    //     tree.inorder();
    //     System.out.println();
    //     System.out.print("Preorder : ");
    //     tree.preOrder();
    //     System.out.println();
    //     System.out.print("Postorder : ");
    //     tree.postOrder();
    // }


}