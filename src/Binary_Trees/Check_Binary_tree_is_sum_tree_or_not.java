package Binary_Trees;

public class Check_Binary_tree_is_sum_tree_or_not {
    public static void main(String[] args){
        Node root = new Node(120);
        root.left = new Node(40);
        root.right = new Node(20);
        root.left.left = new Node(15);
        root.left.right = new Node(25);
        root.right.right = new Node(20);

        if(isSumTree(root)) System.out.println("yes, Its a sum tree");
        else System.out.println("No, Its not a sum tree");
    }

    private static boolean isSumTree(Node root) {
        if(root == null || leafNode(root)) return true;
        int leftsum;
        int rightsum;
        if(isSumTree(root.left) && isSumTree(root.right)){
            // for left tree
            if(root.left == null) leftsum = 0;
            else if(leafNode(root.left)) leftsum = root.left.data;
            else leftsum = 2 * (root.left.data);

            // for right tree
            if(root.right == null) rightsum = 0;
            else if(leafNode(root.right)) rightsum = root.right.data;
            else rightsum = 2 * (root.right.data);

            // check for root data is equal to sum of leaf node or right node
            if(root.data == leftsum + rightsum) return true;
            else return false;
        }
        return false;
    }

    private static boolean leafNode(Node root) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return true;
        return false;
    }
}
