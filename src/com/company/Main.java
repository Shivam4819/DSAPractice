package com.company;


import com.Linklist.BasicLinkList;
import com.Linklist.DoubleLinklist;

import java.util.Scanner;

class CircularLinklist{
    int data;
    CircularLinklist next;

    public CircularLinklist(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here

        BasicLinkList list=new BasicLinkList();
       // list.controller();

        DoubleLinklist doubleLinklist=new DoubleLinklist();
       // doubleLinklist.doubleLinklistController();

        CircularLinklist c=new CircularLinklist(10);
        c.next=new CircularLinklist(20);
        c.next.next=new CircularLinklist(30);
        c.next.next.next=new CircularLinklist(40);
        c.next.next.next.next=c;

        Main m=new Main();
        m.traverse(c);
      //  m.insertAtHead(5,c);
    //    m.insertAtLast(50,c);
      //  m.searchElement(40,c);
    //    m.removeFirstNode(c);
    //    m.removeparticular(40,c);
       // m.copyReversed(c);
        m.copyCircular(c);
    }

    public void copyCircular(CircularLinklist head){
        CircularLinklist temp=head;
        CircularLinklist headtwo=null;
        CircularLinklist newnode;
        CircularLinklist temp2=null;

        while (temp.next!=head){
            if(headtwo==null){
                headtwo=new CircularLinklist(temp.data);
                temp2=headtwo;
            }
            else {
                newnode=new CircularLinklist(temp.data);
                temp2.next=newnode;
                newnode.next=headtwo;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        newnode=new CircularLinklist(temp.data);
        temp2.next=newnode;
        newnode.next=headtwo;
        
        traverse(headtwo);
    }
    public void copyReversed(CircularLinklist head){
        CircularLinklist temp=head;
        CircularLinklist newnode;
        CircularLinklist headtwo=null;

            while (temp.next!=head){
                if(headtwo==null){
                    headtwo=new CircularLinklist(temp.data);
                    //headtwo.next=null;
                }
                else {
                    newnode=new CircularLinklist(temp.data);
                    newnode.next=headtwo;
                 //   headtwo.next=newnode;
                    headtwo=newnode;
                }
                temp=temp.next;
            }
            newnode=new CircularLinklist(temp.data);
            newnode.next=headtwo;
            headtwo=newnode;
            temp=headtwo;
       // System.out.println(temp.data);
            while (temp.next!=null)
               temp=temp.next;
             temp.next=headtwo;

            traverse(headtwo);

    }
    public void removeparticular(int x,CircularLinklist head){
        CircularLinklist temp=head;
        while (temp.next.data!=x && temp.next!=head)
            temp=temp.next;
        temp.next=temp.next.next;
        traverse(head);
    }
    public void removeFirstNode(CircularLinklist head){
        CircularLinklist temp=head;
        while (temp.next!=head)
            temp=temp.next;
        head=head.next;
        temp.next=head;
        traverse(head);
    }
    public void searchElement(int x,CircularLinklist head){
        CircularLinklist temp=head;
        while (temp.next!=head){
            if(temp.data==x){
                System.out.println("found");
                break;
            }
            temp=temp.next;
        }
        if(temp.data==x){
            System.out.println("found");
        }

    }
    public void insertAtLast(int x,CircularLinklist head){
        CircularLinklist temp=head;
        CircularLinklist newnode= new CircularLinklist(50);
        while (temp.next!=head){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.next=head;
        traverse(head);
    }
    public void insertAtHead(int x, CircularLinklist head){
        CircularLinklist temp=head;
        CircularLinklist newnode=new CircularLinklist(x);
       // newnode.next=head;
        while (temp.next!=head){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.next=head;
        head=newnode;

        traverse(head);
    }
    public void traverse(CircularLinklist head){
        CircularLinklist temp=head;
        while (temp.next!=head){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
}
