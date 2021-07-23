package Binary_Trees;

import java.util.Stack;

public class DFS_INORDER_Traversal {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("\nThe Inorder Traversal in Binary Tree Using Recursion =>");
        InorderRecursive(root);

        System.out.println("\nThe Inorder Traversal in Binary Tree Using Iteration =>");
        InorderIteration(root);
    }

    private static void InorderIteration(Node root) {
        if(root == null) return;
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while(!s.isEmpty() || curr != null){
            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            else{
                curr = s.pop();
                System.out.print(curr.data+" ");
                curr = curr.right;
            }
        }
    }

    private static void InorderRecursive(Node root) {
        if(root == null) return;
        InorderRecursive(root.left);
        System.out.print(root.data+" ");
        InorderRecursive(root.right);
    }
}
