package Binary_Trees;

public class Diameter_of_Binary_Tree {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("\nThe diameter of Binary Tree "+diameter(root));
        System.out.println("\nThe diameter of Binary Tree "+diameter2(root));
    }
    static int dia=0;
    private static int diameter2(Node root) {
        height2(root);
        return dia;
    }
    private static int height2(Node root){
        if(root==null)return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        dia=Math.max(dia,lh+rh+1);
        return Math.max(lh,rh)+1;
    }

    private static int diameter(Node root) {
        if(root == null) return 0;
        int d1 = 1+height(root.left)+height(root.right);
        int d2 = diameter(root.left);
        int d3 = diameter(root.right);
        return Math.max(d1, Math.max(d2, d3));
    }

    private static int height(Node root) {
        if(root == null) return 0;
        else
            return (1+Math.max(height(root.left), height(root.right)));
    }
}
