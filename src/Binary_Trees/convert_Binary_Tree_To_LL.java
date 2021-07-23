package Binary_Trees;

public class convert_Binary_Tree_To_LL {
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

        Node head = BTtoLL(root);
        printlist(head);
    }

    static Node prev = null;
    static Node head = null;
    private static Node BTtoLL(Node root) {

        // ------------------ 1st --------------------- //

//        if(root == null) return root;
//        Node head = BTtoLL(root.left);
//        if(prev == null) head = root;
//        else{
//            root.left = prev;
//            prev.right = root;
//        }
//        prev = root;
//        BTtoLL(root.right);
//        return head;

        // -------------- 2nd ----------------------- //

//        if(root == null) return null;
//        BTtoLL(root.right);
//        root.right = head;
//        if(head != null) head.left = root;
//        head = root;
//        BTtoLL(root.left);
//        return head;

        // -------------------------- 3 rd -------------------------- //
        if(root == null) return null;
        BTtoLL(root.left);
        if(head == null){
            head = root;
            prev = root;
        }
        else{
            prev.right = root;
            root.left = prev;
            prev = root;
        }
        BTtoLL(root.right);
        return head;
    }

    private static void printlist(Node head) {
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
    }
}
