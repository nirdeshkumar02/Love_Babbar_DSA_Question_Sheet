package Binary_Trees;

public class Convert_Binary_Tree_To_String {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);


        str ="";
        treeToString(root);
        System.out.println("The String is => "+str);
    }
        static String str;

    private static void treeToString(Node root) {

        if(root == null) return;

        // adding root data to string
         str += (Character.valueOf((char)(root.data + '0')));

        if(root.left == null && root.right == null) return;

        // left subtree
        str += ('(');
        treeToString(root.left);
        str += (')');

        if(root.right != null){
            str += ('(');
            treeToString(root.right);
            str += (')');
        }
    }
}
