package LinkedList;

import java.util.HashMap;

public class count_triplet_in_dll_with_given_sum {
    public static void main(String[] args){
        DLL_Node head = new DLL_Node(1);
        head.next = new DLL_Node(2);
        head.next.next = new DLL_Node(4);
        head.next.next.next = new DLL_Node(5);
        head.next.next.next.next = new DLL_Node(6);
        head.next.next.next.next.next = new DLL_Node(8);
        head.next.next.next.next.next.next = new DLL_Node(9);

        int x = 17;
        System.out.println("The given linked list = ");
        traversing(head);

        System.out.println("count triplet using naive =  "+naiveTripletCount(head, x) ); // time complexity = O(n^3)
        System.out.println("count triplet using hashing = "+hashingTripletCount(head, x)); // tc = O(n^2) sc = O(n)
        System.out.println("count triplet using two Pointer = "+twoPointerTripletCount(head, x)); // tc = O(n^2)
    }

    private static int twoPointerTripletCount(DLL_Node head, int x) {
        if(head == null) return 0;
        DLL_Node current, first, last;
        int count = 0;
        // get pointer to the last node of
        // the doubly linked list
        // get pointer to the last node of
        // the doubly linked list
        last = head;
        while (last.next != null)
            last = last.next;

        // traversing the doubly linked list
        for (current = head; current != null; current = current.next) {

            // for each current node
            first = current.next;

            // count pairs with sum(x - current.data) in the range
            // first to last and add it to the 'count' of triplets
            count += countPairs(first, last, x - current.data);
        }

        // required count of triplets
        return count;
    }

    static int countPairs(DLL_Node first, DLL_Node second, int value)
    {
        int count = 0;

        // The loop terminates when either of two pointers
        // become null, or they cross each other (second.next
        // == first), or they become same (first == second)
        while (first != null && second != null &&
                first != second && second.next != first) {

            // pair found
            if ((first.data + second.data) == value) {

                // increment count
                count++;

                // move first in forward direction
                first = first.next;

                // move second in backward direction
                second = second.prev;
            }

            // if sum is greater than 'value'
            // move second in backward direction
            else if ((first.data + second.data) > value)
                second = second.prev;

                // else move first in forward direction
            else
                first = first.next;
        }

        // required count of pairs
        return count;
    }


    private static int hashingTripletCount(DLL_Node head, int x) {
        DLL_Node ptr1, ptr2, ptr3;
        int count = 0;
        HashMap<Integer, DLL_Node> map = new HashMap<Integer, DLL_Node>();

        for(ptr1 = head; ptr1 != null; ptr1 = ptr1.next){
            map.put(ptr1.data, ptr1);
        }

        for(ptr2 = head; ptr2 != null; ptr2 = ptr2.next){
            for(ptr3 = ptr2.next; ptr3 != null; ptr3 = ptr3.next){
                int sum = ptr2.data + ptr3.data;
                if(map.containsKey(x - sum) && map.get(x - sum)!= ptr2 && map.get(x - sum) != ptr3)
                    count++;
            }
        }
        return (count/3);
    }

    private static int naiveTripletCount(DLL_Node head, int x) {
        DLL_Node ptr1, ptr2, ptr3;
        int count = 0;

        for(ptr1 = head; ptr1 != null; ptr1 = ptr1.next){
            for(ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next){
                for(ptr3 = ptr2.next; ptr3 != null; ptr3 = ptr3.next){
                    if(ptr1.data + ptr2.data + ptr3.data == x){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static void traversing(DLL_Node head) {
        DLL_Node curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}
