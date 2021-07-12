package Binary_Trees;

public class Height_of_tree {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("\nThe height of Binary Tree is "+height(root));
    }

    private static int height(Node root) {
        if(root == null) return 0;
        else
            return (1+Math.max(height(root.left), height(root.right)));
    }
}
