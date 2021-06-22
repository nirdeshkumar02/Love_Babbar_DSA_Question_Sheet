package LinkedList;

public class Reverse_Linked_List_in_groups_of_size_K {
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        // traversing linked list //
        System.out.println("Normal Linked List = ");
        traversing(head);

        // recursive reverse in group of size k //
        head = reverseGroupRecursive(head, 2);
        System.out.println("\nreverse in group of size k Linked List = ");
        traversing(head);

        // iterative reverse in group of size k //
        head = reverseGroupIterative(head, 3);
        System.out.println("\nreverse in group of size k Linked List = ");
        traversing(head);

    }

    private static Node reverseGroupIterative(Node head, int k) {
        Node curr = head;
        Node prevFirst = null;
        boolean isFirstPass = true;
        while (curr != null){
            Node First = curr;
            Node prev = null;
            int count = 0;
            while(curr != null && count < k){
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if(isFirstPass){
                head = prev;
                isFirstPass = false;
            }
            else{
                prevFirst.next = prev;

            }
            prevFirst = First;
        }
        return head;
    }

    private static Node reverseGroupRecursive(Node head, int k) {
        Node curr = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        while (curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next != null){
            Node res_head = reverseGroupRecursive(next , k);
            head.next = res_head;
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
