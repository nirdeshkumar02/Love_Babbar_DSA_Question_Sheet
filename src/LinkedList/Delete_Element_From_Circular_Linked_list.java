package LinkedList;

public class Delete_Element_From_Circular_Linked_list {
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = head;

        System.out.print("List Before Deletion: ");
        traversing(head);

        head = deleteElement(head, 10);

        System.out.print("\nList After Deletion: ");
        traversing(head);
    }

    private static Node deleteElement(Node head, int key) {
        if (head == null)
            return null;

        // Find the required node
        Node curr = head, prev = new Node(0);
        while (curr.data != key) {
            if (curr.next == head) {
                System.out.printf("\nGiven node is not found"
                        + " in the list!!!");
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        // Check if node is only node
        if (curr == head && curr.next == head) {
            head = null;
            return head;
        }

        // If more than one node, check if
        // it is first node
        if (curr == head) {
            prev = head;
            while (prev.next != head)
                prev = prev.next;
            head = curr.next;
            prev.next = head;
        }

        // check if node is last node
        else if (curr.next == head) {
            prev.next = head;
        }
        else {
            prev.next = curr.next;
        }
        return head;
        }

    private static void traversing(Node head) {
        if(head == null) return;
        System.out.print(head.data+" ");
        for(Node r = head.next; r!=head; r = r.next){
            System.out.print(r.data+" ");
        }
    }
}
