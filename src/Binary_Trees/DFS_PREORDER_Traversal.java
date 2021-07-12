package Binary_Trees;

import java.util.Stack;

public class DFS_PREORDER_Traversal {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("\nThe Preorder Traversal in Binary Tree =>");
        PreorderRecursion(root);

        System.out.println("\nThe Preorder Traversal in Binary Tree using Iteration => ");
        PreorderIteration(root);
    }

    private static void PreorderIteration(Node root) {
        if(root == null) return;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node curr = s.pop();
            System.out.print(curr.data+" ");
            if(curr.right != null){
                s.push(curr.right);
            }
            if(curr.left != null){
                s.push(curr.left);
            }
        }
    }

    private static void PreorderRecursion(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        PreorderRecursion(root.left);
        PreorderRecursion(root.right);
    }
}
