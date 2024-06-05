package LinkedList;

public class CircularLinkedList {

    public static Node last;

    public static class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
            next = null;
        }
    }

    CircularLinkedList(){
        last = null;
    }

    public static void insertAtBeginning(int val){
        Node newNode = new Node(val);
        if(last == null){
            newNode.next = newNode;
            last = newNode;
        }
        else{
            newNode.next = last.next;
            last.next = newNode;
        }
    }

    public static void insertAtEnd(int val){
        Node newNode = new Node(val);
        if(last == null){
            newNode.next = newNode;
            last = newNode;
        }
        else{
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    public static void deleteAtBeginning(){
        if(last == null){
            throw new IndexOutOfBoundsException("List is empty");
        }

        if(last.next == last){
            last = null;
        }

        else{
            last.next = last.next.next;
        }
    }

    public static void deleteAtEnd(){
        if(last == null){
            throw new IndexOutOfBoundsException("List is empty");
        }

        if(last.next == last){
            last = null;
        }

        else{
            Node temp = last.next;
            while(temp.next!=last)
            {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp;
        }
    }

    public static void display(){
        if (last == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = last.next;
        do{
            System.out.print(temp.data + " ");
            temp = temp.next;
        }while(temp!=last.next);
    }

    public static void main(String[] args) {
        insertAtBeginning(9);
        insertAtBeginning(10);
        insertAtBeginning(199);
        insertAtEnd(12);
        insertAtEnd(14);
        display();
        System.out.println();
        deleteAtBeginning();
        display();
        System.out.println();
        deleteAtEnd();
        deleteAtEnd();
        deleteAtEnd();
        display();
    }
}
