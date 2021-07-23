package Binary_Trees;

public class Check_isBalanced_binary_tree {


    static class Height{
        int height = 0;
    }

    public static void main(String[] args) {

        Height height = new Height();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The balanced tree is => "+ isBalanced(root));


        if (isBalancedBoolean(root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");

    }

        private static boolean isBalancedBoolean(Node root, Height height)
    {
        /* If tree is empty then return true */
        if (root == null) {
            height.height = 0;
            return true;
        }

        /* Get heights of left and right sub trees */
        Height lheight = new Height(), rheight = new Height();
        boolean l = isBalancedBoolean(root.left, lheight);
        boolean r = isBalancedBoolean(root.right, rheight);
        int lh = lheight.height, rh = rheight.height;

        /* Height of current node is max of heights of
           left and right subtrees plus 1*/
        height.height = (lh > rh ? lh : rh) + 1;

        /* If difference between heights of left and right
           subtrees is more than 2 then this node is not balanced
           so return 0 */
        if (Math.abs(lh - rh) >= 2)
            return false;

        /* If this node is balanced and left and right subtrees
           are balanced then return true */
        else
            return l && r;
    }

    private static int isBalanced(Node root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int lh = isBalanced(root.left);
        if(lh == -1) return -1;
        int rh = isBalanced(root.right);
        if(rh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }
}

