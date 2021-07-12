package Binary_Trees;

import java.util.Stack;

public class DFS_POSTORDER_Traversal {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("\nThe PostOrder Traversal in Binary Tree using Recursion =>");
        PostorderRecursive(root);

        System.out.println("\nThe PostOrder Traversal in Binary Tree using Iteration =>");
        PostorderIteration(root);
    }

    private static void PostorderIteration(Node root) {
        if(root == null) return;
        Stack<Node> s = new Stack<>();
        s.push(root);
        Stack<Integer> out = new Stack<>();
        while(!s.isEmpty()){
            Node curr = s.pop();
            out.push(curr.data);
            if(curr.left != null) s.push(curr.left);
            if(curr.right != null) s.push(curr.right);
        }
        while(!out.isEmpty()){
            System.out.print(out.pop()+" ");
        }
    }

    private static void PostorderRecursive(Node root) {
        if(root == null) return;
        PostorderRecursive(root.left);
        PostorderRecursive(root.right);
        System.out.print(root.data+" ");
    }
}
