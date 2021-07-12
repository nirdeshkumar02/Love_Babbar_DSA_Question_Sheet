package Binary_Trees;
import java.util.*;

public class Left_View_of_a_tree {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The View of a Binary Tree is => ");
        InorderTraversal(root);

        System.out.println("\nThe Left View of a Binary Tree is => ");
        LeftViewVoid(root); // void type

        System.out.println("\nThe Left View of a Binary Tree is => "+LeftViewReturn(root));

        System.out.println("\nThe Left View of a Binary Tree is => "+LeftViewRecursive(root));

    }
        static int max = 0;
    private static ArrayList<Integer> LeftViewRecursive(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        View(result, root, 1);
        return result;
    }

    private static void View(ArrayList<Integer> result, Node root, int level) {
        if(root == null) return;
        if(max < level){
            result.add(root.data);
            max = level;
        }
        View(result, root.left, level+1);
        View(result, root.right, level+1);
    }

    private static ArrayList<Integer> LeftViewReturn(Node root) {
        ArrayList<Integer>result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++){
                Node curr = q.poll();
                if(i==0) result.add(curr.data);
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }

    private static void LeftViewVoid(Node root) {
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                if(i==0) System.out.print(curr.data+" ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
    }

    private static void InorderTraversal(Node root) {
        if(root == null) return;
        InorderTraversal(root.left);
        System.out.print(root.data+" ");
        InorderTraversal(root.right);
    }
}
