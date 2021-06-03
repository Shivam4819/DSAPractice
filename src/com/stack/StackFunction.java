package com.stack;

import java.util.Stack;

public class StackFunction {
    int top=-1;
    int size=5;
    int[] data= new int[size];
    public void stackController(){
        push(10);
        push(20);
        push(30);
        push(40);
        //insertSorted function
        Stack<Integer> stk=new Stack<>();
        stk.push(10);
        stk.push(6);
        stk.push(30);
        stk.push(20);
       // display(stk);
        System.out.println("--------------------------------");
        insertSorted(stk,50);
       // sortStack(stk);
        display(stk);


    }


    public void sortStack(Stack<Integer> stk){
        int temp;
        if(!stk.empty()){
            temp=stk.pop();
            sortStack(stk);
            stk.push(temp);
        }
    }
    public void display(Stack<Integer> stk){
        Stack<Integer> stack=new Stack<>();

        int i=0;
        int len=stk.size();
        while (i<len){
            System.out.print(stk.pop()+" ");
            i++;
        }
        System.out.println();
    }
    public void insertSorted(Stack<Integer> stk, int x){
        int temp;
        if(stk.empty() || x>stk.peek())
            stk.push(x);
        else {
            temp=stk.pop();
            insertSorted(stk,x);
            stk.push(temp);
        }

    }
    public void push(int x){
        if(top>=(size-1)) {
            System.out.println("overflow");
         //   increaseStackSize();
        }
        else{
            data[++top]=x;
        }

    }
    public int pop(){
        int x=0;
        if (top<0)
            System.out.println("underflow");
        else {
            x=data[top--];
        }
        return x;
    }
}
