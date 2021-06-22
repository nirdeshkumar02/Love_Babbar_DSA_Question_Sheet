package LinkedList;
import java.util.*;

public class Find_First_Node_of_Loop {
    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = head.next.next.next;

        Node res = StartingNode(head);
        if (res == null)
            System.out.print("Loop does not exist");
        else
            System.out.print("Loop starting node using floyd's is " +  res.data);

        Node result = StartingNodeHashing(head);
        if (result == null)
            System.out.print("\nLoop does not exist");
        else
            System.out.print("\nLoop starting node using hashing is " +  result.data);
    }

    private static Node StartingNodeHashing(Node head) {
        Set<Node>set = new HashSet<>();
        Node curr = head;
        while(curr != null){
            if(set.contains(curr)){
                return curr;
            }
            else{
                set.add(curr);
            }
            curr = curr.next;
        }
        return null;
    }

    // using floyd's cycle
    private static Node StartingNode(Node head) {
        if(head == null || head.next == null) return null;
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(slow != fast) return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
