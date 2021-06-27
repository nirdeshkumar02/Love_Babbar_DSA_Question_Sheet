package LinkedList;

import java.util.HashSet;

public class Removing_element_from_unsorted_LinkedList {
    public static void main(String[] args){
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(4);

        System.out.println("LinkedList before removing element");
        traversing(head);
        System.out.println("\nLinked List after removing element"+removing(head));
        traversing(head);
    }

    private static Node removing(Node head) {
        HashSet<Integer> hs = new HashSet<>();

        /* Pick elements one by one */
        Node current = head;
        Node prev = null;
        while (current != null)
        {
            int curval = current.data;

            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
        return head;

    }

    private static void traversing(Node head) {
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}
