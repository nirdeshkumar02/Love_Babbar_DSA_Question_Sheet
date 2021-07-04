package LinkedList;

public class Quick_Sort_FOR_Linked_list {
    public static void main(String[] args){
        Node head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);

        System.out.println("The Given Linked List is ");
        traversing(head);


        System.out.println("\nAfter Quick sort, The Linked list is ");
        Node Head = QuickSort(head);
        traversing(Head);
    }

    public static Node QuickSort(Node head)
    {
        Node temp=new Node(0);
        temp.next=head;
        if(head!=null){
            qsort(temp,null);
        }
        return temp.next;


    }
    static void qsort(Node temp, Node tail) {
        Node pivot = partition(temp,tail);
        if(temp.next!=pivot){
            qsort(temp,pivot);
        }
        if(pivot.next!=tail){
            qsort(pivot,tail);
        }
    }

    static Node partition(Node dummyNode, Node tail) {
        Node pivot = dummyNode.next;
        Node fastPre = dummyNode.next;

        while(fastPre.next != tail){
            if(fastPre.next.data<pivot.data){
                Node tmp = fastPre.next;
                fastPre.next = tmp.next;

                tmp.next = dummyNode.next;
                dummyNode.next=tmp;
            }else{
                fastPre=fastPre.next;
            }
        }
        return pivot;
    }

    private static void traversing(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
}
