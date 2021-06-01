package com.Linklist;

class DoublyLinkList{

    DoublyLinkList prev;
    int data;
    DoublyLinkList next;
    DoublyLinkList(int d){
        prev=null;
        data=d;
        next=null;
    }

}
public class DoubleLinklist {

    public void doubleLinklistController(){
        DoublyLinkList d=new DoublyLinkList(10);
        d.next=new DoublyLinkList(20);
        //   d.next.prev=d;
        d.next.next=new DoublyLinkList(30);
        // d.next.next.prev=d.next;
        d.next.next.next=new DoublyLinkList(40);
        d.next.next.next.next=new DoublyLinkList(50);
        d.next.prev=d;
        d.next.next.prev=d.next;
        d.next.next.next.prev=d.next.next;
        d.next.next.next.next.prev=d.next.next.next;

        traverse(d);
        //  backtraverse(d);
        //  inserthead(5,d);
        //  insertSorted(35,d);
        //  removehead(d);
        //  deletenode(30,d);
        copyListReversed(d);
    }

    public void copyListReversed(DoublyLinkList head){
        DoublyLinkList temp=head;
        DoublyLinkList headtwo=null;
        while (temp!=null){
            if(headtwo==null){
                headtwo=new DoublyLinkList(temp.data);

            }
            else {
                DoublyLinkList newnode=new DoublyLinkList(temp.data);
                newnode.next=headtwo;
                headtwo.prev=newnode;
                headtwo=newnode;
            }
            temp=temp.next;
        }
        System.out.println(".................");
        traverse(headtwo);
    }
    public void deletenode(int x,DoublyLinkList head){
        DoublyLinkList temp=head;
        while (temp.next!=null && temp.next.data!=x){
            temp=temp.next;
        }
        System.out.println(temp.data);
        temp.next=temp.next.next;
        temp.next.prev=temp;
        traverse(head);
        //  backtraverse(head);
    }
    public void removehead(DoublyLinkList head){
        head=head.next;
        head.prev=null;
        traverse(head);
    }
    public void insertSorted(int x,DoublyLinkList head){
        DoublyLinkList temp=head;
        while (temp.next.data<x && temp.next!=null)
            temp=temp.next;
        System.out.println(temp.data);
        DoublyLinkList newnode=new DoublyLinkList(x);
        newnode.next=temp.next;
        newnode.prev=temp;
        temp.next=newnode;
        newnode.next.prev=newnode;

        traverse(head);

    }

    public void traverse(DoublyLinkList head){
        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }

    public void backtraverse(DoublyLinkList head){
        DoublyLinkList temp=head;
        while (temp.next!=null)
            temp=temp.next;
        System.out.println(temp.data);
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
    }

    public void inserthead(int x,DoublyLinkList head){
        DoublyLinkList newnode=new DoublyLinkList(x);
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
        traverse(head);
    }


}

