package Binary_Trees;
import java.util.*;

public class Top_View_of_a_Binary_Tree {

    static class Node{
        int data;
        int height;
        Node left;
        Node right;
    }

    static class Pair{
        int h;
        Node node;
        Pair(int h, Node n){
            this.h = h;
            this.node = n;
        }
    }

    public static void main(String[] args){
        Node root = createNode(2);
        root.left = createNode(7);
        root.right = createNode(5);
        root.left.right = createNode(6);
        root.left.right.left = createNode(5);
        root.left.right.left.left = createNode(10);
        root.left.right.right = createNode(11);
        root.right.right = createNode(9);

        System.out.println("The Top View of Binary Tree => ");
        topView(root);

        System.out.println("\nThe Top View of Binary Tree Return type => "+ TopView(root));
    }

    private static ArrayList<Integer> TopView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> m = new TreeMap<>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if(!m.containsKey((Integer)curr.h)) m.put(curr.h, curr.node.data);
            if(curr.node.left != null) q.add(new Pair(curr.h-1, curr.node.left));
            if(curr.node.right != null) q.add(new Pair(curr.h+1, curr.node.right));
        }
        Iterator<Integer> itr = m.values().iterator();
        while (itr.hasNext())
            result.add(itr.next());
        return result;
    }

    private static Node createNode(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.left = newNode.right = null;
        return newNode;
    }

    private static void topView(Node root) {
        if(root == null) return;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            int height = curr.height;
            if(!m.containsKey(height)) m.put(height, curr.data);
            if(curr.left != null) {
                curr.left.height = height-1;
                q.add(curr.left);
            }
            if(curr.right != null) {
                curr.right.height = height+1;
                q.add(curr.right);
            }
        }
        System.out.print(m.values());
    }
}
