package Binary_Trees;

public class Boundary_Traversal_Of_Tree {
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

        System.out.println("The Boundary Traversal of Tree => ");
        BoundaryTraversal(root);
    }

    private static void BoundaryTraversal(Node root) {
        if(root == null) return;
        if(root != null) System.out.print(root.data+" ");
        LeftBoundaryTraversal(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        RightBoundaryTraversal(root.right);
    }

    private static void printLeaves(Node root) {
        if(root == null) return;
        printLeaves(root.left);
        if(root.left == null && root.right == null)
            System.out.print(root.data+" ");
        printLeaves(root.right);
    }

    private static void RightBoundaryTraversal(Node root) {
        if(root == null) return;
        if(root.right != null){
            RightBoundaryTraversal(root.right);
            System.out.print(root.data+" ");
        }
        if(root.left != null){
            RightBoundaryTraversal(root.left);
            System.out.print(root.data+" ");
        }
    }

    private static void LeftBoundaryTraversal(Node root) {
        if(root == null) return;
        if(root.left != null) {
            System.out.print(root.data+" ");
            LeftBoundaryTraversal(root.left);
        }
        else if(root.right != null) {
            System.out.print(root.data+" ");
            LeftBoundaryTraversal(root.right);
        }
    }
}
