package Binary_Trees;

import java.util.Stack;

public class Convert_String_To_Binary_Tree {
    public static void main(String[] args){
        String s = "4(2(3)(1))(6(5))";

        System.out.println("\nThe Tree from string case 1 => ");
        Node root = constructTree(s);
        printTree(root);
    }

    // ----------------------------------------------------------------------------------- //

    static int start = 0;
    private static Node constructTree(String s) {
        if(s.length() == 0 || s == null) return null;
        if(start >= s.length()) return null;
        boolean negative = false;
        // check for negative integer
        if(s.charAt(start) == '-'){
            negative = true;
            start++;
        }
        int num = 0;
        while(start < s.length() && Character.isDigit(s.charAt(start))){
            int digit = Character.getNumericValue(s.charAt(start));
            num = num * 10 + digit;
            start++;
        }

        if(negative) num = -num;

        Node node = new Node(num);
        if(start >= s.length()) return node;
        if(start < s.length() && s.charAt(start) == '('){
            start++;
            node.left = constructTree(s);
        }
        if(start < s.length() && s.charAt(start) == ')'){
            start++;
            return node;
        }
        // Check for open bracket and add the data
        // to the right subtree recursively
        if (start < s.length() && s.charAt(start) == '(')
        {
            start++;
            node.right = constructTree(s);
        }

        if (start < s.length() && s.charAt(start) == ')')
        {
            start++;
            return node;
        }
        return node;
    }

    private static void printTree(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
