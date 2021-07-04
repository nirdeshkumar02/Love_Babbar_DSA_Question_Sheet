package LinkedList;

public class Find_Pair_Given_Sum_In_DLL {
    public static void main(String[] args){
        DLL_Node head = new DLL_Node(1);
        head.next = new DLL_Node(2);
        head.next.next = new DLL_Node(4);
        head.next.next.next = new DLL_Node(5);
        head.next.next.next.next = new DLL_Node(6);
        head.next.next.next.next.next = new DLL_Node(8);
        head.next.next.next.next.next.next = new DLL_Node(9);

        int x = 17;
        System.out.println("The given doubly linked list = ");
        traversing(head);
        pairSum(head, x);
        System.out.println("count pairSum = "+countPairs(head, x));
    }

    public static int countPairs(DLL_Node head, int x) {
        DLL_Node first = head;
        DLL_Node second = head;
        int count = 0;

        while(second.next != null ){
            second = second.next;
        }

        while (first != null && second != null &&
                first != second && second.next != first) {

            // pair found
            if ((first.data + second.data) == x) {

                // increment count
                count++;

                // move first in forward direction
                first = first.next;

                // move second in backward direction
                second = second.prev;
            }

            // if sum is greater than 'value'
            // move second in backward direction
            else if ((first.data + second.data) > x)
                second = second.prev;

                // else move first in forward direction
            else
                first = first.next;
        }

        // required count of pairs
        return count;
    }

    private static void pairSum(DLL_Node head, int x) {
        DLL_Node first = head;
        DLL_Node second = head;
        while(second.next != null ){
            second = second.next;
        }
        boolean found = false;

        while ( first != second && second.next != first)
        {
            // pair found
            if ((first.data + second.data) == x)
            {
                found = true;
                System.out.println( "(" + first.data +
                        ", "+ second.data + ")" );

                // move first in forward direction
                first = first.next;

                // move second in backward direction
                second = second.prev;
            }
            else
            {
                if ((first.data + second.data) < x)
                    first = first.next;
                else
                    second = second.prev;
            }
        }

        // if pair is not present
        if (found == false)
            System.out.println("No pair found");
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
