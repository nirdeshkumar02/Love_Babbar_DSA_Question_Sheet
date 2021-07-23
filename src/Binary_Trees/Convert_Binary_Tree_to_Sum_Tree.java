package Binary_Trees;

public class Convert_Binary_Tree_to_Sum_Tree {
    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(-2);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        toSumTree(root);
        System.out.println("The Sum Tree is => ");
        Inorder(root);
    }

    private static void toSumTree(Node root) {
        solve(root);
    }

    private static int solve(Node root) {
        if(root == null) return 0;
        int oldValue = root.data;
        root.data = solve(root.left) + solve(root.right);
        return root.data + oldValue;
    }

    private static void Inorder(Node root) {
        if(root == null) return;
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }
}
