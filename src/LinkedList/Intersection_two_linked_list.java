package LinkedList;
import java.util.*;

public class Intersection_two_linked_list {
    public static void main(String[] args){
        Node l1 = new Node(3);
        l1.next = new Node(5);
        l1.next.next = new Node(7);

        System.out.println("The first linked list => ");
        traverse(l1);

        Node l2 = new Node(4);
        l2.next = new Node(7);
        l2.next.next = new Node(9);

        System.out.println("\nThe second linked list => ");
        traverse(l2);

        Node head = intersection(l1, l2);
        System.out.println("\nIntersection of Linked List = ");
        traverse(head);
    }

    private static Node intersection(Node l1, Node l2) {
        Set<Integer> set= new HashSet<>();
        while (l1 != null){
            set.add(l1.data);
            l1 = l1.next;
        }
        Node temp = new Node(0);
        Node prevNode = temp;

        Set<Integer> ansSet= new HashSet<>();
        while (l2 != null){
            if(set.contains(l2.data) && !ansSet.contains(l2.data)){
                temp.next = new Node(l2.data);
                ansSet.add(l2.data);
                temp = temp.next;
            }
            l2 = l2.next;
        }
        return prevNode.next;
    }


    private static void traverse(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
}
