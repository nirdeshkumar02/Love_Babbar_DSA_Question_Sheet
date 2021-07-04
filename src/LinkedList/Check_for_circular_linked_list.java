package LinkedList;

public class Check_for_circular_linked_list {
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = head;

        System.out.println("The circular Linked List is ");
        traversing(head);

        System.out.println("\nIs given linked list is circular => "+ isCircularLinkedList(head));
    }

    private static boolean isCircularLinkedList(Node head) {
        if(head == null) return true;
        Node curr = head.next;
        while(curr != null && curr != head){
            curr = curr.next;
        }
        return (curr == head) ;
    }

    private static void traversing(Node head) {
//        if(head == null) return;
//        Node r = head;
//        do {
//            System.out.println(r.data+" ");
//            r = r.next;
//        }
//        while(r != head);

        if(head == null) return;
        System.out.print(head.data+" ");
        for(Node r = head.next; r!=head; r = r.next){
            System.out.print(r.data+" ");
        }
    }
}
