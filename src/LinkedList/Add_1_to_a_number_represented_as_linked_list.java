package LinkedList;

public class Add_1_to_a_number_represented_as_linked_list {
    public static void main(String[] args){
        Node head = new Node(5);
        head.next = new Node(6);
        head.next.next = new Node(8);

        System.out.println("The given linked list");
        traversing(head);

        System.out.println("\nThe new linked list is"+ addOne(head));
        traversing(head);
    }

    private static Node addOne(Node head) {
        head = reverse(head);
        Node current = head;
        int carry = 1;
        while(carry != 0){
            current.data += 1;
            if(current.data < 10)return reverse(head);
            else current.data = 0;
            if(current.next == null) break;
            else current = current.next;
        }
        current.next = new Node(1);
        return reverse(head);
    }

    private static Node reverse(Node head) {
        Node current = head;
        Node next = null;
        Node prev = null;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
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
