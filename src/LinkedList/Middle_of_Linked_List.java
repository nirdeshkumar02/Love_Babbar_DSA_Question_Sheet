package LinkedList;

public class Middle_of_Linked_List {
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("The linked list is ");
        traversing(head);
        System.out.println("\nmiddle element in linked list is");
        middleLinkedList(head);
    }

    private static void middleLinkedList(Node head) {
        if(head == null) return;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.print(slow.data+" ");
    }

    private static void traversing(Node head) {
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}
