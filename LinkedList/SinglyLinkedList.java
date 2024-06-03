package LinkedList;

import javax.naming.LinkException;

public class SinglyLinkedList {
    static Node head;

    static class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
            next = null;
        }
    }

    public static void insertAtBeginning(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    } 

    public static void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        insertAtBeginning(5);
        insertAtBeginning(9);
        display();
    }
}
