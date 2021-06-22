package LinkedList;

public class Detect_Remove_Loop {
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = head.next.next;

       DetectRemoveLoop(head);
        System.out.println("Linked List after Removing Loop");
        traversing(head);
    }

    private static void traversing(Node head) {
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    private static void DetectRemoveLoop(Node head) {
        //  if list is empty or has one node
        if(head == null || head.next == null) return;
        Node slow = head;
        Node fast = head;

        // search for loop using slow and fast
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        // if loop exist
        if(slow == fast) {
            slow = head;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            else {
                while (fast.next != slow) {
                    fast = fast.next;
                }
            }
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
    }
}
