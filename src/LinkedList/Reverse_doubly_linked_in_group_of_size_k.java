package LinkedList;

public class Reverse_doubly_linked_in_group_of_size_k {
    public static void main(String args[])
    {
        // Start with the empty list
        Node head = null;

        // Create doubly linked: 10<->8<->4<->2
        head = push(head, getNode(2));
        head = push(head, getNode(4));
        head = push(head, getNode(8));
        head = push(head, getNode(10));

        int k = 2;

        System.out.print("Original list: ");
        printList(head);

        // Reverse doubly linked list in groups of
        // size 'k'
        head = revListInGroupOfGivenSize(head, k);

        System.out.print("\nModified list: ");
        printList(head);
    }

    private static Node revListInGroupOfGivenSize(Node head, int k) {
        Node curr = head;
        Node next = null;
        Node newHead = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            newHead = push(newHead, curr);
            curr = next;
            count++;
        }
        if(next != null) {
            head.next = revListInGroupOfGivenSize(next , k);
            head.next.prev = head;
        }
        return newHead;
    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }

    private static Node push(Node head, Node new_node) {
        new_node.prev = null;
        new_node.next = head;
        if(head != null) head.prev = new_node;
        head = new_node;
        return head;
    }

    private static Node getNode(int data) {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = new_node.prev = null;
        return new_node;
    }
    static class Node
    {
        int data;
        Node next, prev;
    }
}
