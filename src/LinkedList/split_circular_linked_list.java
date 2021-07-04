package LinkedList;

public class split_circular_linked_list {

    /*
        1. Split Circular Linked List in two -------------

    void splitList(circular_LinkedList list)
    {
        Node head = list.head;
        Node s = list.head;

        Node f = list.head;

        while( f.next != head && f.next.next != head){

            s = s.next;
            f = f.next.next;
        }
        list.head1 = list.head;

        list.head2 = s.next;

        s.next = list.head1;

        while( f.next != head ){
            f = f.next;
        }

        f.next = list.head2;

    }
     */


/*
      2. Split Circular Linked List in two -------------

    public void split() {
        Node l1 = head;
        Node l2 = head;
        for (int i=0 ; l2.next != head && l2.next.next != head ; i++) {
            l2 = l2.next.next;
            l1 = l1.next;
        }
        if (l2.next.next == head) {
            l2 = l2.next;
        }
        list1 = head;

        if (head.next != head) {
            list2 = l1.next;
        }
        l2.next = l1.next;
        l1.next = head;
    }
}

 */



/*

    3rd method

void splitList(circular_LinkedList list)
        {
              Node curr=list.head;
             Node root=curr;
             int num=0;
             while(curr.next!=root){
                 num=num+1;
                 curr=curr.next;
             }
             num+=1;
             Node lip=list.head;
             int mid=(num+1)/2;
             while(mid>1){
                 root=root.next;
                 mid=mid-1;
             }
             Node temp=root.next;
             curr.next=temp;
             root.next=lip;
             list.head1=lip;
             list.head2=temp;
	 }
 */
}