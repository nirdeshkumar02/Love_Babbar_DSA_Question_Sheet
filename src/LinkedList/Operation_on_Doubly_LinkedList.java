package LinkedList;

public class Operation_on_Doubly_LinkedList {
    public static void main(String[] args){

        DLL_Node head = new DLL_Node(15);
        DLL_Node temp1 = new DLL_Node(20);
        DLL_Node temp2 = new DLL_Node(25);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;

        System.out.println("Previous Linked List = ");
        traversing(head);

        // insert at beginning //
        head = insertBegin(head, 5);
        System.out.println("After inserting at begin, linked list will be =");
        traversing(head);

        // insert at end //
        head = insertEnd(head, 30);
        System.out.println("After inserting at end, linked list will be =");
        traversing(head);

        // Delete head //
        head = deleteHead(head);
        System.out.println("After delete head, linked list will be =");
        traversing(head);

        // Delete last node //
        head = deleteLast(head);
        System.out.println("After delete last node, linked list will be =");
        traversing(head);

    }

    private static DLL_Node deleteLast(DLL_Node head) {
        if(head == null) return null;
        if(head.next == null) return null;
        DLL_Node curr = head;
        while(curr.next != null) curr = curr.next;
        curr.prev.next = null;
        return head;
    }

    private static DLL_Node deleteHead(DLL_Node head) {
        if(head == null) return null;
        if(head.next == null) return null;
        else head = head.next;
        head.prev = null;
        return head;
    }

    private static DLL_Node insertEnd(DLL_Node head, int x) {
        DLL_Node temp = new DLL_Node(x);
        if(head == null) return temp;
        DLL_Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;
    }

    private static DLL_Node insertBegin(DLL_Node head, int x) {
        DLL_Node curr = new DLL_Node(x);
        curr.next = head;
        if(head != null) {
            head.prev = curr;
        }
        return curr;
    }

    private static void traversing(DLL_Node head) {
        DLL_Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}
