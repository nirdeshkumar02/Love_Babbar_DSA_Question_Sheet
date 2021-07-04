package LinkedList;

public class merge_sort_for_linked_list {
    public static void main(String[] args){
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);

        System.out.println("The Given Linked List is ");
        traversing(head);


        System.out.println("\nAfter Merge sort, The Linked list is ");
        Node Head = MergeSort(head);
        traversing(Head);
    }

    private static Node MergeSort(Node h) {

        // Base condition to check linked list null
        if(h == null || h.next == null) return h;

        // Getting mid point of linked list
        Node middle = getMiddle(h);
        Node middleNext = middle.next;
        middle.next = null;

        // Apply merge sort on left side
        Node left = MergeSort(h);

        // Apply merge sort on right side
        Node right = MergeSort(middleNext);

        // Merge the left and right side
        Node sortedList = sortedMerge(left, right);
        return sortedList;
    }

    private static Node sortedMerge(Node a, Node b) {
        Node result = null;
        // Base case
        if(a == null) return b;
        if(b == null) return a;

        // Pick either a or b and recur
        if(a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else{
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    private static Node getMiddle(Node head) {
        if(head == null) return head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static void traversing(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
}
