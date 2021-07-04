package LinkedList;

public class Merge_two_sorted_linked_list {
    public static void main(String[] args){
        Node a = new Node(10);
        a.next = new Node(20);
        a.next.next = new Node(30);

        System.out.println("The given linked list a = ");
        traversing(a);

        Node b = new Node(5);
        b.next = new Node(15);
        b.next.next = new Node(25);
        System.out.println("\nThe given linked list b = ");
        traversing(b);

        System.out.println("\nThe merge linked list of a and b = ");
        traversing(merge(a,b));

    }

    private static Node merge(Node a, Node b) {
        Node result = null;
        // Base case
        if(a == null) return b;
        if(b == null) return a;

        // Pick either a or b and recur
        if(a.data <= b.data) {
            result = a;
            result.next = merge(a.next, b);
        }
        else{
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }

    private static void traversing(Node head) {
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}
