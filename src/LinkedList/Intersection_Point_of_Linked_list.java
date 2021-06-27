package LinkedList;
import java.util.HashSet;

public class Intersection_Point_of_Linked_list {
    public static void main(String[] args){
        Node l1 = new Node(3);
        l1.next = new Node(6);
        l1.next.next = new Node(9);
        l1.next.next.next = new Node(15);
        l1.next.next.next.next = new Node(30);

        System.out.println("The first linked list => ");
        traverse(l1);

        Node l2 = new Node(10);
        l2.next = new Node(15);
        l2.next.next = new Node(30);

        System.out.println("\nThe second linked list => ");
        traverse(l2);

        System.out.println("\nIntersection of Linked List = "+intersectPoint(l1, l2));
        System.out.println("\nIntersection of Linked List = "+intersectPoint2(l1, l2));

    }

    private static int intersectPoint2(Node head1, Node head2) {
        if(head1==null || head2==null){
            return 0;
        }
        Node temp1=head1;
        Node temp2=head2;

        int len1=length(temp1);
        int len2=length(temp2);

        int len=Math.abs(len1-len2);

        for(int i=0;i<len;i++){
            if(len1>len2){
                head1=head1.next;
            }
            else{
                head2=head2.next;
            }
        }
        while(head1!=head2 && head1!=null && head2!=null){
            head1=head1.next;
            head2=head2.next;
        }
        if(head1!=head2){
            return 0;
        }
        return head1.data;
    }
    static int length(Node head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }

    private static int intersectPoint(Node head1, Node head2)
    {
        HashSet<Node> s = new HashSet<>();
        Node curr = head1;
        while(curr != null){
            s.add(curr);
            curr = curr.next;
        }
        curr = head2;
        while(curr != null){
            if(s.contains(curr))
                return curr.data;
            curr = curr.next;
        }
        return -1;
    }

    private static void traverse(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
}
