package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class sort_k_sorted_linked_list {
    public static void main(String[] args){
        DLL_Node head = new DLL_Node(3);
        head.next = new DLL_Node(6);
        head.next.next = new DLL_Node(2);
        head.next.next.next = new DLL_Node(15);
        head.next.next.next.next = new DLL_Node(56);
        head.next.next.next.next.next = new DLL_Node(8);
//        head.next.next.next.next.next.next = new DLL_Node(79);

        int k = 2;

        System.out.println("The given doubly linked list = ");
        traversing(head);

        System.out.println("K sorted linked list =");
        traversing(sortKSortedLinkedList(head, k));
    }

    static class compareNode implements Comparator<DLL_Node>
    {
        public int compare(DLL_Node n1, DLL_Node n2){
            return n1.data-n2.data;
        }
    }
        // using min heap implement by priority queue
    private static DLL_Node sortKSortedLinkedList(DLL_Node head, int k) {
        if(head == null) return null;
        PriorityQueue<DLL_Node> pq = new PriorityQueue<DLL_Node>( new compareNode());
        DLL_Node newHead = null;
        DLL_Node last = null;

        // Create a Min Heap of first (k+1) elements from
        // input doubly linked list
        for(int i = 0; head != null && i<=k; i++){
            pq.add(head);
            head = head.next;
        }

        while(!pq.isEmpty()){
            if(newHead == null) {
                newHead = pq.peek();
                newHead.prev = null;
                last = newHead;
            }
            else{
                last.next = pq.peek();
                pq.peek().prev = last;
                last = pq.peek();
            }
            pq.poll();
            if(head != null){
                pq.add(head);
                head = head.next;
            }
        }
        last.next = null;
        return newHead;
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

