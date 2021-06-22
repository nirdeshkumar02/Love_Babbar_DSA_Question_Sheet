package LinkedList;

public class Reverse_Linked_List {
    public static void main(String[] args){
        Node head = new Node(85);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);

        // traversing LinkedList //
        System.out.println("Normal Linked List = ");
        traversing(head);

        // reverse Linked List - iterative //
        head = reverseList(head);
        System.out.println("\nReverse Linked List through iterative is = ");
        traversing(head);
    }

    private static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void traversing(Node head) {
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}
