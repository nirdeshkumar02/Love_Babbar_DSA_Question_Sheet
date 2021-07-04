package LinkedList;

import java.util.PriorityQueue;

public class sort_linked_list_using_priority_queue {
    public static void main(String[] args){
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);

        System.out.println("The Given Linked List is ");
        traversing(head);


        System.out.println("\nAfter using Priority queue for sorting linked list, The Linked list is ");
        Node Head = PriorityQueueSort(head);
        traversing(Head);
    }

    private static Node PriorityQueueSort(Node head) {
        PriorityQueue<Integer>pq = new PriorityQueue<Integer>();
        while(head != null){
            pq.add(head.data);
            head = head.next;
        }
        Node n = new Node(0);
        Node temp = n;
        while(!pq.isEmpty()){
            temp.next = new Node(pq.remove());
            temp = temp.next;
        }
        return n.next;
    }

    private static void traversing(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
}
