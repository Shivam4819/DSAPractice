package com.Linklist;

import com.company.Main;

class Linklist{
    int data;
    Linklist next;
    Linklist(int x){
        data=x;
        next=null;
    }
}
public class BasicLinkList {
        public void controller(){
            Linklist l = new Linklist(5);
            l.next = new Linklist(10);
            l.next.next = new Linklist(20);
            l.next.next.next = new Linklist(30);
            l.next.next.next.next = new Linklist(50);
            //   l.next.next.next.next.next=l.next;
            traverse(l);
            //   insertStart(40,l);
            //   insertlast(400,l);
            //   searchLinklist(10,l);
            //   deleteFirst(l);
            //   delSpecific(50,l);
            //   revlist(l);
            //   remduplicate(l);
            //   copyrev(l);
            //   otherCopy(l);
            //   nthNodeFromBegining(1,l);
            //   nthNodeFromLast(5,l);
            findLoop(l);
        }
    public void findLoop(Linklist head){
        Linklist fast=head;
        Linklist slow=head;
        int count=-1;
        //  fast=fast.next.next;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                count=1;
                break;
            }
            else if(fast.next==head){
                count=2;
                break;
            }
        }
        if(count==-1)
            System.out.println("no loop");
        else if(count==1)
            System.out.println("loop");
        else if(count==2)
            System.out.println("circular");
    }
    public void nthNodeFromLast(int n, Linklist head){
        Linklist fast=head;
        Linklist slow=head;
        while (fast!=null && n>0){
            n--;
            fast=fast.next;
        }
        // System.out.println(fast.data);
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        System.out.println(slow.data);
    }
    public void nthNodeFromBegining(int x, Linklist head){
       Linklist temp=head;
        while (temp!=null){
            if(x>1){
                x--;
            }
            else{
                System.out.println("nth node="+temp.data);
                break;
            }
            temp=temp.next;
        }

    }
    public void otherCopy(Linklist head){
        Linklist head2=null;
        Linklist temp=head;
        Linklist temp2=head2;
        while (temp!=null){
            if (head2==null){
                head2=new Linklist(temp.data);
                // temp2=head2;
            }
            else {
                temp2=head2;
                System.out.println("temp2.data="+temp2.data);
                while (temp2.next!=null){
                    temp2=temp2.next;
                }
                Linklist node=new Linklist(temp.data);
                temp2=node;
            }
            temp=temp.next;
        }
        traverse(head2);
    }
    public void copyrev(Linklist head){
        Linklist temp=head;
        Linklist head2=null;
        Linklist node=null;
        while (temp!=null){
            if(head2==null)
                head2=new Linklist(temp.data);
            else {
                node=new Linklist(temp.data);
                node.next=head2;
                head2=node;
            }
            temp=temp.next;
        }
        traverse(head2);
    }
    public void remduplicate(Linklist head){
        Linklist temp=head;
        Linklist temp1=head;
        while (temp!=null){
            if(temp.next!=null &&temp.data==temp.next.data){
                temp.next=temp.next.next;
            }
            else {
                temp=temp.next;
            }
        }
        traverse(head);
    }
    public void revlist(Linklist head){
        Linklist curr=head;
        Linklist prev=null;
        Linklist future=null;
        while (curr!=null){
            future=curr.next;
            curr.next=prev;
            prev=curr;
            curr=future;
        }
        head=prev;
        traverse(head);
    }
    public void delSpecific(int d, Linklist head){
        Linklist temp=head;
        Linklist temp1=head;


        while (temp.data!=d){
            temp1=temp;
            temp=temp.next;
        }
        System.out.println(temp.data);
        System.out.println(temp1.data);
        temp1.next=temp.next;
        traverse(head);

    }
    public  void deleteFirst(Linklist head){
        head=head.next;
        traverse(head);

    }

    public void searchLinklist(int da, Linklist head){
        Linklist temp=head;
        while (temp!=null){
            if(temp.data==da){
                System.out.println("found");
                break;
            }
            temp= temp.next;
        }
    }
    public void insertStart(int data, Linklist head){
        Linklist newnode=new Linklist(data);
        newnode.next=head;
        head=newnode;
        traverse(head);
    }

    public void insertlast(int d, Linklist head){
        Linklist temp=head;
        while (temp.next!=null)
            temp=temp.next;
        Linklist las=new Linklist(d);
        temp.next=las;
        traverse(head);
    }
    public void traverse(Linklist l){
        while (l!=null){
            System.out.print(l.data+" ");
            l=l.next;
        }
        System.out.println();
    }
}

