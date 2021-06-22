package LinkedList;

public class Singly_LinkedList_Implementation {
    public static void main(String[] args){
        // creating nodes of linked list
        Node head = new Node(10);
        Node temp1 = new Node(50);
        Node temp2 = new Node(80);
        // linking nodes to each other
        head.next = temp1;
        temp1.next = temp2;
        // print out them
        System.out.println(head.data + " ===> "+ temp1.data + " ===> "+ temp2.data );


    }
    // implementation of nodes
    public static class Node {
        int data;
        Node next;
        Node(int x){
            data = x;
            next = null;
        }
    }
}
