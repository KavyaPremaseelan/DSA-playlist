package LinkedList;

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

    public static void insertAtPos(int val,int pos){
        Node newNode = new Node(val);
        if(pos == 0){
            insertAtBeginning(val);
            return;
        }
        Node temp = head;
        for(int i=1 ; i<pos ; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
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
        System.out.println("After inserting at position: ");
        insertAtPos(7, 1);
        display();
    }
}
