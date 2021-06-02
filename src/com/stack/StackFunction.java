package com.stack;

public class StackFunction {
    int top=-1;
    int size=3;
    int[] data= new int[size];

    public void stackController(){
        push(10);
        push(20);
        push(30);
        push(40);
        push(50);
        for (int i=0;i<size;i++){
            System.out.println(pop()+" ");
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
