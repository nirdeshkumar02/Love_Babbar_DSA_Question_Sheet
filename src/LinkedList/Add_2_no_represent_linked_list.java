package LinkedList;
import java.util.*;

public class Add_2_no_represent_linked_list {
    public static void main(String[] args){
        Node l1 = new Node(3);
        l1.next = new Node(4);
        l1.next.next = new Node(5);

        System.out.println("The first linked list => ");
        traverse(l1);

        Node l2 = new Node(5);
        l2.next = new Node(8);
        l2.next.next = new Node(5);

        System.out.println("\nThe second linked list => ");
        traverse(l2);

        Node head = addTwoLists(l1, l2);
        System.out.println("\nAfter adding, Linked List will be");
        traverse(head);

    }

    private static void traverse(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
    }

    static Node addTwoLists(Node l1, Node l2){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null)
        {
            stack1.add(l1.data);
            l1 = l1.next;
        }

        while (l2 != null)
        {
            stack2.add(l2.data);
            l2 = l2.next;
        }

        int carry = 0;
        Node result = null;

        while (!stack1.isEmpty() ||
                !stack2.isEmpty())
        {
            int a = 0, b = 0;

            if (!stack1.isEmpty())
            {
                a = stack1.pop();
            }

            if (!stack2.isEmpty())
            {
                b = stack2.pop();
            }

            int total = a + b + carry;

            Node temp = new Node(total % 10);
            carry = total / 10;

            if (result == null)
            {
                result = temp;
            }
            else
            {
                temp.next = result;
                result = temp;
            }
        }

        if (carry != 0)
        {
            Node temp = new Node(carry);
            temp.next = result;
            result = temp;
        }
        return result;
    }
}
