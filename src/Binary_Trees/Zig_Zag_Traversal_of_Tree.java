package Binary_Trees;

import java.util.*;

public class Zig_Zag_Traversal_of_Tree {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // using two stack

        System.out.println("\nThe Zig Zag Traversal of Tree => ");
        zigzagTraversal(root);
        System.out.println("\nThe zig zag traversal of tree return type 1 => "+ zigzagTraversalReturn1(root));
        System.out.println("\nThe zig zag traversal of tree return type 2 => "+ zigzagTraversalReturn2(root));

        // using queue
        System.out.println("\nThe zig zag traversal of tree return type 3 => "+ zigzagTraversalReturn3(root));
    }

    private static List<List<Integer>> zigzagTraversalReturn3(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;

        q.add(root);
        int level = 0;
        while (!q.isEmpty()){
            List<Integer> res = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                res.add(curr.data);
                if(curr.left != null)  q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(level % 2 == 0){
                ans.add(res);
            }
            else{
                Collections.reverse(res);
                ans.add(res);
            }
            level++;
        }
        return ans;
    }

    private static List<List<Integer>> zigzagTraversalReturn2(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;

        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            while (!s1.isEmpty()){
                Node curr = s1.pop();
                result.add(curr.data);
                if(curr.left != null) s2.push(curr.left);
                if(curr.right != null) s2.push(curr.right);
            }
            while (!s2.isEmpty()){
                Node curr = s2.pop();
                result.add(curr.data);
                if(curr.right != null) s1.push(curr.right);
                if(curr.left != null) s1.push(curr.left);
            }
            ans.add(result);
        }
        return ans;
    }

    private static ArrayList<Integer> zigzagTraversalReturn1(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();

        if(root == null) return result;
        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()){
                Node curr = s1.pop();
                result.add(curr.data);
                if(curr.left != null) s2.push(curr.left);
                if(curr.right != null) s2.push(curr.right);
            }
            while (!s2.isEmpty()){
                Node curr = s2.pop();
                result.add(curr.data);
                if(curr.right != null) s1.push(curr.right);
                if(curr.left != null) s1.push(curr.left);
            }
        }
        return result;
    }

    private static void zigzagTraversal(Node root) {
        if(root==null)
            return;
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                Node p= s1.pop();
                System.out.print(p.data+" ");
                if(p.left!=null)
                    s2.push(p.left);
                if(p.right!=null)
                    s2.push(p.right);
            }
            while(!s2.isEmpty())
            {
                Node p=s2.pop();
                System.out.print(p.data+" ");
                if(p.right!=null)
                    s1.push(p.right);
                if(p.left!=null)
                    s1.push(p.left);
            }
        }
    }
}
