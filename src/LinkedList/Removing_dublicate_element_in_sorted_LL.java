package LinkedList;

public class Removing_dublicate_element_in_sorted_LL {
    public static void main(String[] args){
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);

        System.out.println("Linked List before removing element");
        traversing(head);
        System.out.println("\nAfter Removing element = "+ RemovingElement(head));
        traversing(head);
        System.out.println("\nAfter Removing element = "+ RemovingElementIterative(head));
        traversing(head);
    }

    private static Node RemovingElementIterative(Node head) {
        if(head==null){
            return head;
        }
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;
            }
            else{
                curr=curr.next;
            }
        }
        return head;
    }

    private static Node RemovingElement(Node head) {
        Node curr;
        if(head == null) return null;
        if(head.next != null){
            if(head.data == head.next.data){
                curr = head.next;
                head.next = head.next.next;
                RemovingElement(head);
            }
            else{
                RemovingElement(head.next);
            }
        }
        return head;
    }

    private static void traversing(Node head) {
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}
