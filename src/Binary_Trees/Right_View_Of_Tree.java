package Binary_Trees;
import java.util.*;

public class Right_View_Of_Tree {
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

        System.out.println("\nThe Right View of a Binary Tree is => ");
        RightViewVoid(root); // void type

        System.out.println("\nThe Right View of a Binary Tree is => "+RightViewReturn(root));

        System.out.println("\nThe Right View of a Binary Tree is => "+RightViewRecursive(root));

    }
        static  int max = 0;
    private static ArrayList<Integer> RightViewRecursive(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        View(result, root, 1);
        return result;
    }

    private static void View(ArrayList<Integer> result, Node root, int level) {
        if(root == null) return;
        if(max<level){
            result.add(root.data);
            max = level;
        }
        View(result, root.right, level+1);
        View(result, root.left, level+1);
    }

    private static ArrayList<Integer> RightViewReturn(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null) return result;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                Node curr = q.poll();
                if(i == size-1) result.add(curr.data);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }

    private static void RightViewVoid(Node root) {
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                if(i == size-1) System.out.print(curr.data+" ");
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
