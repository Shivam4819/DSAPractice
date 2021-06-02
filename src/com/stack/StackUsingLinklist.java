package com.stack;

class StackLinklist{
    int data;
    StackLinklist next;
    StackLinklist(int x){
        data=x;
        next=null;
    }

}
public class StackUsingLinklist {
     static StackLinklist head=null;
    static StackLinklist temp=null;
    public void listController(){
        push(10);
        push(20);
        push(30);
        traverse(head);
        pop();
        System.out.println("-----------------------");
        traverse(head);
    }
    public void push(int x){
        if(head==null){
            head=new StackLinklist(x);
            temp=head;
        }
        else{
//            while (temp.next!=null)
//                temp=temp.next;
            StackLinklist newnode=new StackLinklist(x);
            newnode.next=head;
            head=newnode;
        }
    }

    public void pop(){
        head=head.next;
    }
    public void traverse(StackLinklist head){
         temp=head;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }

    }

}
