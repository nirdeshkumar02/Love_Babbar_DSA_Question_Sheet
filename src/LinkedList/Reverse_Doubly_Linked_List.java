package LinkedList;

import java.util.Stack;

public class Reverse_Doubly_Linked_List {
    public static void main(String[] args){
        DLL_Node head = new DLL_Node(15);
        DLL_Node temp1 = new DLL_Node(20);
        DLL_Node temp2 = new DLL_Node(25);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;

        System.out.println("Doubly Linked List = ");
        traversing(head);

        head = reverseDoublyLinkedList(head);
        System.out.println("\nThe Reverse Doubly Linked List ");
        traversing(head);

        head = reverseDoublyLinkedListIteraive(head);
        System.out.println("\nThe Reverse Doubly Linked List ");
        traversing(head);

    }

    private static DLL_Node reverseDoublyLinkedListIteraive(DLL_Node head) {
        DLL_Node current = head;
        DLL_Node temp = null;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        /* Before changing head, check for the cases like
         empty list and list with only one node */
        if (temp != null) {
            head = temp.prev;
        }
        return head;
    }

    private static DLL_Node reverseDoublyLinkedList(DLL_Node head) {
        Stack<Integer> stack = new Stack<Integer>();
        DLL_Node temp = head;

        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    private static void traversing(DLL_Node head) {
        DLL_Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}
