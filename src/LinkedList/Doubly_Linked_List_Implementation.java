package LinkedList;

public class Doubly_Linked_List_Implementation {
    public static void main(String[] args){
        DLL_Node head = new DLL_Node(10);
        DLL_Node temp1 = new DLL_Node(20);
        DLL_Node temp2 = new DLL_Node(30);
         head.next = temp1;
         temp1.prev = head;
         temp1.next = temp2;
         temp2.prev = temp1;
         printList(head);
    }

    private static void printList(DLL_Node head) {
        DLL_Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}
