package Binary_Trees;

import java.util.*;

public class Bottom_View_of_Binary_Tree {

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

        System.out.println("\nThe Bottom View of Binary Tree => ");
        BottomView(root);

        System.out.println("\nThe Bottom View of Binary Tree Return Type => "+ BottomViewReturn(root));
    }

    private static ArrayList <Integer> BottomViewReturn(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> m = new TreeMap<>();
        if(root == null) return result;
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            m.put(curr.h, curr.node.data);
            if(curr.node.left != null) q.add(new Pair(curr.h-1, curr.node.left));
            if(curr.node.right != null) q.add(new Pair(curr.h+1, curr.node.right));
        }
        Iterator<Integer> itr = m.values().iterator();
        while(itr.hasNext())
            result.add(itr.next());
        return result;

    }

    private static void BottomView(Node root) {
        if(root == null) return;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            int height = curr.height;
            m.put(height, curr.data);
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

    private static Node createNode(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.left = newNode.right = null;
        return newNode;
    }
}
