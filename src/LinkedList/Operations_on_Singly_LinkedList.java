package LinkedList;

public class Operations_on_Singly_LinkedList {
    public static void main(String[] args){
        // creating nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        // traversing LinkedList
        traversing(head);


        // insert at begin //
        head = insertBegin(head, 50);
        head = insertBegin(head, 60);
        head = insertBegin(head, 70);
        // traversing
        System.out.println("\nInsert at begin position then linked list will be");
        traversing(head);



        // insert at last //
        head = insertEnd(head, 900);
        head = insertEnd(head, 600);
        head = insertEnd(head, 300);
        // traversing
        System.out.println("\nInset at end of linked list then linked list will be");
        traversing(head);



        // delete first node //
        head = deleteFirst(head);
        System.out.println("\nAfter delete first node, Remaining List will be");
        traversing(head);



        // delete last node //
        head = deleteLast(head);
        System.out.println("\nAfter delete last node, Remaining List will be");
        traversing(head);


        // searching in linked list //
        System.out.println("Position of element in Linked List"+" "+search(head, 50));

    }

    private static int search(Node head, int x) {
        int pos = 1;
        Node curr = head;
        while(curr != null) {
            if(curr.data == x) return pos;
            else{
                pos++;
                curr = curr.next;
            }
        }
        return -1;
    }

    private static Node deleteLast(Node head) {
        if(head == null) return null;
        if(head.next == null) return null;
        Node curr = head;
        while(curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;

        return head;
    }

    private static Node deleteFirst(Node head) {
        if(head == null) return null;
        else
        return head.next;
    }

    private static Node insertEnd(Node head, int x) {
        Node temp = new Node(x);
        if(head == null) return temp;
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    public static Node insertBegin(Node head, int x){
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }

    private static void traversing(Node head) {
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}
