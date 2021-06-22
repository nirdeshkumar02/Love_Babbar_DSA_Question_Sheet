package LinkedList;

public class Detect_Loop_in_Linked_List {
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = head.next.next;

        if(isLoop(head)) System.out.println("Loop Found");
        else System.out.println("No Loop");

    }

    private static boolean isLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
