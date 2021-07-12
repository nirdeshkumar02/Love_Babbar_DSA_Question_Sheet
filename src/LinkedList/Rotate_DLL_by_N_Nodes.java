package LinkedList;

public class Rotate_DLL_by_N_Nodes {
    public static void main(String[] args){
        DLL_Node head = new DLL_Node(1);
        head.next = new DLL_Node(2);
        head.next.next = new DLL_Node(4);
        head.next.next.next = new DLL_Node(5);
        head.next.next.next.next = new DLL_Node(6);
        head.next.next.next.next.next = new DLL_Node(8);
        head.next.next.next.next.next.next = new DLL_Node(9);

        int n = 5;
        System.out.println("The given linked list = ");
        traversing(head);

        System.out.println("Linked List after Roatation n nodes = ");
        rotateDLL( n);
        traversing(head);
    }
    static DLL_Node head = null;
    private static void rotateDLL(int n) {
        if(n == 0) return;
        DLL_Node curr = head;
        int count = 1;

        while(count < n && curr != null){
            curr = curr.next;
            count++;
        }
        if(curr == null) return;
        DLL_Node NthNode = curr;

        while(curr.next != null)
            curr = curr.next;

            curr.next = head;
            head.prev = curr;
            head = NthNode.next;
            head.prev = null;
            NthNode.next = null;
    }

    private static void traversing(DLL_Node head) {
        DLL_Node curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}
