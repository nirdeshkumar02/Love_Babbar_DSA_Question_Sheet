package Binary_Trees;

import java.util.*;

public class Level_Order_traversal_or_BFS_binary_trees {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        /*
            ==> Traversal in trees ==>
                1. Level Order Traversal -> (Breadth First Search)
                2. Depth First Search -> a. Preorder (Root, Left, Right)
                                         b. Inorder (Left, Root, Right)
                                         c. Postorder (Left, Right, Root)
         */

        System.out.println("The given Binary Tree (in single line void type) using BFS is ");
        BFSinLine(root); // in a single line void type

        System.out.println("\nThe given Binary Tree (in single line return type) using BFS is "+ LOTinLine(root));

        System.out.println("\nThe given Binary Tree (line by line void type) using BFS is ");
        BFSinLevel(root); // in different line void type

        System.out.println("\nThe given Binary Tree (line by line return type) using BFS is "+LOTinLevel(root));

    }

    private static ArrayList <Integer> LOTinLine(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            result.add(curr.data);
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
        return result;
    }

    private static void BFSinLine(Node root) {
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data+" ");
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
    }

    private static ArrayList<ArrayList<Integer>> LOTinLevel(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                currentLevel.add(curr.data);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

    private static void BFSinLevel(Node root) {
        if(root == null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                System.out.print(curr.data+" ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            System.out.println();
        }
    }


}
