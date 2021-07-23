package Binary_Trees;
import java.util.*;

public class Vertical_View_Of_Binary_Tree {
    static class Node{
        int data;
        int height;
        Node left;
        Node right;
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

        System.out.println("\nThe Vertical View of Binary Tree => ");
        VerticalView(root);
        
    }

    private static void VerticalView(Node root) {
        if(root == null) return;
        int hd = 0;
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        getVerticalView(root, hd, m);
        for(Map.Entry<Integer, ArrayList<Integer>> cm : m.entrySet()) {
            System.out.println(cm.getValue());
        }
    }

    private static void getVerticalView(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> m) {
        if(root == null) return;
        if(m.get(hd) == null) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(root.data);
            m.put(hd, al);
        }
        else{
            ArrayList<Integer> al = m.get(hd);
            al.add(root.data);
            m.put(hd, al);
        }

        getVerticalView(root.left, hd-1, m);
        getVerticalView(root.right, hd+1, m);
    }

    private static Node createNode(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.left = newNode.right = null;
        return newNode;
    }
}
