package Binary_Trees;
import java.util.*;

public class reverse_Level_Order_Traversal {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The reverse level order traversal (left to right)"+ reverseLOT(root));
        System.out.println("\nThe reverse level order traversal (left to right)"+ reverseLOTdiffer(root));
}

    private static List<List<Integer>> reverseLOTdiffer(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                currentLevel.add(curr.data);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(0, currentLevel);
        }
        return result;
    }

    private static ArrayList<Integer> reverseLOT(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                stack.push(curr.data);

                if(curr.right != null) q.add(curr.right);
                if(curr.left != null) q.add(curr.left);
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}
