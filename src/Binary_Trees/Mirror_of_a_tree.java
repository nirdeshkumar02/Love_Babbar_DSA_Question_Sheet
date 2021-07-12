package Binary_Trees;

public class Mirror_of_a_tree {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void main(String[] args){
        Node root = createNode(5);
        root.left = createNode(3);
        root.right = createNode(6);
        root.left.left = createNode(2);
        root.left.right = createNode(4);

        System.out.println("The Original Tree is => ");
        InorderTraversal(root);

        // In case not allowed to change original tree

        Node mirror = mirrorify(root);
        System.out.println("\nThe Mirror Tree is => ");
        InorderTraversal(mirror);

        // In case allowed to change original tree

        System.out.println("\nThe Mirror Tree is using change of original => ");
        InorderTraversal(mirrorTree(root));
    }

    private static Node mirrorTree(Node root) {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null) mirrorTree(root.left);
        if(root.right != null) mirrorTree(root.right);
        return root;
    }

    private static Node mirrorify(Node root) {
        if(root == null) return null;

        Node mirror = createNode(root.data);
        mirror.left = mirrorify(root.right);
        mirror.right = mirrorify(root.left);
        return mirror;
    }

    private static Node createNode(int root) {
        Node newNode = new Node();
        newNode.data = root;
        newNode.left = newNode.right = null;
        return newNode;
    }

    private static void InorderTraversal(Node root) {
        if(root == null) return;
        InorderTraversal(root.left);
        System.out.print(root.data+" ");
        InorderTraversal(root.right);
    }
}
