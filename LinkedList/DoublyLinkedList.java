package LinkedList;

public class DoublyLinkedList {
    static Node head;
    static Node tail;

    static class Node{
        int data;
        Node prev;
        Node next;
        Node(int val){
            data = val;
            prev = null;
            next = null;
        }
    }

    DoublyLinkedList(){
        head = null;
        tail = null;
    }

    public static void insertAtBeginning(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            head.prev = newNode;
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
            if(temp == null){
                throw new IndexOutOfBoundsException("Invalid position");
            }
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if(temp == tail){
            tail = newNode;
        }else{
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

    public static void deleteAtPos(int pos){
        if(head == null){
            throw new IndexOutOfBoundsException("List is empty");
        }

        if(pos == 0){
            head = head.next;
            if(head == null){
                tail = null;
            }
            else{
                head.prev = null;
            }
            return;
        }

        Node temp = head;
        Node prev = null;
        for(int i=1 ; i<=pos ; i++){
            prev = temp;
            temp = temp.next;
            if(temp == null){
                throw new IndexOutOfBoundsException("Invalid position");
            }
        }
        prev.next = temp.next;
        if(temp.next == null){
            tail = prev;
        }
        else{
            temp.next.prev = prev;
        }
    }

    public static void deleteAtBeginning(){
        if(head == null){
            throw new IndexOutOfBoundsException("List is empty");
        }
        head = head.next;
    }

    public static void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void displayRev(){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        insertAtBeginning(3);
        insertAtBeginning(4);
        insertAtBeginning(7);
        insertAtBeginning(9);
        display();
        System.out.println();
        displayRev();
        System.out.println();
        System.out.println("After inserting at position: ");
        insertAtPos(10, 4);
        display();
        System.out.println();
        displayRev();
        System.out.println();
        System.out.println("After deleting");
        deleteAtPos(4);
        display();
        System.out.println();
        displayRev();
    }
}
