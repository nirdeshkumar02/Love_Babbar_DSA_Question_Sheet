package LinkedList;

public class Check_Linked_List_is_Palindrome {
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);

        System.out.println("Given Linked List is ");
        traverse(head);

        if(isPalindrome(head)) System.out.println("\nYes, Linked List is Palindrome");
        else System.out.println("\nNo, Linked List isn't Palindrome");
    }

    private static boolean isPalindrome(Node head) {
        if(head == null) return true;
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node rev = reverseList(slow.next);
        Node curr = head;
        while(rev != null){
            if(rev.data != curr.data) return false;
            rev = rev.next;
            curr = curr.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void traverse(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
}
