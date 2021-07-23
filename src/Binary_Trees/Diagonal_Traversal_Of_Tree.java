package Binary_Trees;

import java.util.*;


public class Diagonal_Traversal_Of_Tree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The Diagonal Traversal of Tree => ");
        DiagonalTraversal(root);

        System.out.println("\nThe Diagonal Traversal of tree return type => "+ diagonalTraversal(root));
    }

    private static ArrayList<Integer> diagonalTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> q = new LinkedList<>();
        Node curr = root;
        while(!q.isEmpty() || curr != null) {
            if(curr != null){
                result.add(curr.data);
                if(curr.left != null) q.add(curr.left);
                curr = curr.right;
            }
            else{
                curr = q.remove();
            }
        }
        return result;
    }

    private static void DiagonalTraversal(Node root) {
        if (root == null) return;
        Node curr = root;
        Queue<Node> q = new LinkedList<>();
        while (!q.isEmpty() || curr != null) {
            if (curr != null) {
                System.out.print(curr.data + " ");
                if (curr.left != null) q.add(curr.left);
                curr = curr.right;
            }
            else{
                curr = q.remove();
            }
        }
    }
}
