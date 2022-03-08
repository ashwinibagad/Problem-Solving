package com.example.linkedlist;

public class LinkedList {
    Node head;
    private int size=0;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
            size++;
        }
    }

    //Insertion

    //Insert At Beginning
    public void insertAtBeginning(int newData){
        Node newNode=new Node(newData);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    //Insert At End
    public void insertAtEnd(int newData){
        Node newNode=new Node(newData);
        Node currentNode=head;
        while(currentNode.next!=null){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
    }

    //Insert In Between at a given position
    public void insertInBetween(int position, int newData){
        Node temp=head;
        Node newNode=new Node(newData);
        for(int i=1;temp!=null && i<position-1;i++){
            temp=temp.next;
        }

        //unable to find given position
        if(temp==null || temp.next==null){
            return;
        }

        newNode.next=temp.next;
        temp.next=newNode;
    }

    //Insert After the given node
    public void insertAfterGivenNode(Node prev_node, int newData){
        Node newNode=new Node(newData);
        Node currentNode=head;
        if(prev_node==null){
            System.out.println("Previous Node can't be NULL");
            return;
        }
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        while(currentNode.next!=null){
            if(currentNode.data == prev_node.data){
                newNode.next=currentNode.next;
                currentNode.next=newNode;
                return;
            }
            currentNode=currentNode.next;
        }
    }

    //Insert At the Mid of the list
    public void insertAtMid(int newData){
        Node newNode=new Node(newData);
        Node tortoise=head;
        Node hare=head;

        while(hare.next!=null && hare.next.next!=null){
            tortoise=tortoise.next;
            hare=hare.next.next;
        }

        newNode.next=tortoise.next;
        tortoise.next=newNode;
    }

    //Deletion

    //Remove First Node
    public void removeFirst(){
        Node currentNode=head;
        size--;
        if(head==null || head.next==null){
            return;
        }
        head=currentNode.next;
    }

    //Remove Last Node
    public void removeLast(){
        Node secondLastNode=head;
        Node lastNode=head.next;

        size--;
        if(head==null || head.next==null){
            return;
        }
        while(lastNode.next!=null){
            lastNode=lastNode.next;
            secondLastNode=secondLastNode.next;
        }
        secondLastNode.next=null;
    }

    //Remove Middle Node
    public void removeMid(){
        Node tortoise=head;
        Node hare=head;
        Node prev=null;
        size--;

        if(head==null || head.next==null){
            return;
        }

        while(hare.next!=null && hare.next.next!=null){
            hare=hare.next.next;
            prev=tortoise;
            tortoise=tortoise.next;
        }

        prev.next=tortoise.next;
    }

    //Remove Element after given node
    public void removeAfterNode(Node prev_node){
        Node currentNode=head;
        if(prev_node==null){
            System.out.println("prev_node can't be null");
        }
        size--;
        if(head==null || head.next==null){
            return;
        }
        while(currentNode.next!=null){
            if(currentNode.data==prev_node.data){
                currentNode.next=prev_node.next.next;
                return;
            }
            currentNode=currentNode.next;
        }
    }

    //Remove Element of a given position
    public void removeInBetween(int position){
        Node temp=head;
        size--;
        for(int i=1;temp!=null && i<position-1;i++){
            temp=temp.next;
        }
        if(temp==null || temp.next==null){
            System.out.println("Incorrect Position");
            return;
        }

        temp.next=temp.next.next;
    }

    //Traversing
    public void printLinkedList(){
        Node currentNode=head;
        while(currentNode!=null){
            System.out.print(currentNode.data+"->");
            currentNode=currentNode.next;
        }
        System.out.println("null");
    }

    //Middle Element of Linked List
    public Node getMidNode(){
        Node tortoise=head;
        Node hare=head;

        while(hare.next!=null && hare.next.next!=null){
            hare=hare.next.next;
            tortoise=tortoise.next;
        }
        return tortoise;
    }

    //Searching
    boolean searchElement(int element){
        Node currentNode=head;
        if(head==null){
            System.out.println("Empty list");
        }
        while(currentNode!=null){
            if(currentNode.data==element){
                return true;
            }
            currentNode=currentNode.next;
        }
        return false;
    }

    //Sorting
    public void sortLinkedList(){
        Node currentNode=head;
        Node nextNode=null;

        //Bubble Sort Technique
        while(currentNode!=null){
            nextNode=currentNode.next;
            while(nextNode!=null){
                if(currentNode.data > nextNode.data){
                    int temp=currentNode.data;
                    currentNode.data=nextNode.data;
                    nextNode.data=temp;
                }
                nextNode=nextNode.next;
            }
            currentNode=currentNode.next;
        }
    }

    //Size
    public void getSize(){
        System.out.println("Size: "+size);
    }

    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.insertAtBeginning(2);
        list.insertAtBeginning(1);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.printLinkedList();
        list.insertAfterGivenNode(list.head.next, 3);
        list.printLinkedList();
        list.insertAfterGivenNode(list.head.next.next, 4);
        list.printLinkedList();
        list.insertAtEnd(7);
        list.printLinkedList();
        list.insertInBetween(4,8);
        list.printLinkedList();
        list.getSize();
        Node middleNode=list.getMidNode();
        System.out.println("Middle Node is: "+middleNode.data);
        list.insertAtMid(10);
        list.printLinkedList();
        middleNode=list.getMidNode();
        System.out.println("Middle Node is: "+middleNode.data);
        int element=5;
        if(list.searchElement(element)){
            System.out.println(element+" is found");
        }
        else{
            System.out.println(element+" is not found");
        }
        list.sortLinkedList();
        list.printLinkedList();
        list.removeFirst();
        list.printLinkedList();
        list.getSize();
        list.removeLast();
        list.printLinkedList();
        list.getSize();
        list.removeMid();
        list.printLinkedList();
        list.getSize();
        list.removeAfterNode(list.head.next.next.next);
        list.printLinkedList();
        list.getSize();
        list.removeInBetween(15);
        list.printLinkedList();
        list.getSize();
    }
}
