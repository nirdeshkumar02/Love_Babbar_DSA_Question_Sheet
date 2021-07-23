package Binary_Trees;

public class lowest_common_ancestor {
    public static void main(String[] args){
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(8);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(10);
        root.right.right = new Node(20);
        root.right.right.right = new Node(25);


        int n1 = 3;
        int n2 = 25;

        Node lca = lca(root, n1, n2);
        System.out.println("The lowest common ancestor is => ");
        System.out.println(lca);
    }

    private static Node lca(Node root, int n1, int n2) {
        if(root == null) return null;
        if(root.data == n1 || root.data == n2) return root;
        Node lcaLeft = lca(root.left, n1, n2);
        Node lcaRight = lca(root.right, n1, n2);

        if(lcaLeft != null && lcaRight != null) return root;
        if(lcaLeft != null) return lcaLeft;
        else return lcaRight;
    }
}
