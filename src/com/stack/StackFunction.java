package com.stack;

import java.util.ArrayDeque;
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
        stk.push(5);
        stk.push(20);
        //display(stk);
        System.out.println("--------------------------------");
       // insertSorted(stk,50);
       // sortStack(stk);
       // display(stk);
       // bottomInsert(60,stk);
       // reversestack(stk);
        // reverseKElement(2,stk);
         // reverseQueue();
       // reverseKElementQueue();
        //minStack(stk);
      //  balancedParanthesis("({})");
         // maxDepth("((()))()");
      //  balancedPranthesisSubString("()())");
        //findDuplicateParanthessis("(a)");
        //countParanthessis("((a+b))");
        infixToPostfix("(a+b)*c");
    }

    public void infixToPostfix(String exp){
        Stack<Character> stack=new Stack<>();
        char[] ch=exp.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='+'||ch[i]=='-'||ch[i]=='/'||ch[i]=='*'){
                stack.push(ch[i]);
            }
            else if(ch[i]!='('&& ch[i]!=')'){
                System.out.print(ch[i]);
            }
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
    }
    public void countParanthessis(String exp){
        Stack<Integer> count=new Stack<>();
        String out=new String();
        int counter=1;
        char[] ch=exp.toCharArray();

        for(int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                count.push(counter);
                out +=counter;
                counter++;
            }
            else if(ch[i]==')'){
                out+=count.pop();
            }
        }
        System.out.println(out);

    }
    public void findDuplicateParanthessis(String exp){
        Stack<Character> stack=new Stack<>();
        char[] ch=exp.toCharArray();
        int count=0;
        for(int i=0;i<ch.length;i++){
         if(ch[i]!=')'){
             stack.push(ch[i]);
         }
         else{
             while (stack.size()!=0 && stack.peek()!='('){
                 stack.pop();
                 count++;
             }
         }
        }
        if(count==0||count==1){
            System.out.println("duplicate");
        }
        else {
            System.out.println("not duplicate");
        }

    }
    public void balancedPranthesisSubString(String exp){
        Stack<Character> stack=new Stack<>();
        char[] ch= exp.toCharArray();
        int num=0;
        for (int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                stack.push(ch[i]);
            }
            else if(ch[i]==')'  && !stack.empty()){
                if(stack.pop()=='(')
                    num++;
            }
            else {
                break;
            }
        }
        System.out.println(num);
    }
    public void maxDepth(String exp){
       // Stack<Character> stack=new Stack<>();
        int max=0;
        int depth=0;
        char[] ch=exp.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='(') {
       //         stack.push(ch[i]);
                depth++;
            }
            else if(ch[i]==')'){
                depth--;
            }
            if(depth>max)
                max=depth;
        }
        System.out.println(max);
    }
    public void balancedParanthesis(String exp){
        Stack<Character> stack=new Stack<>();
        //char c;
        for(char ch:exp.toCharArray()){
           switch (ch){
               case '(':
               case '{':
                   stack.push(ch);
                        break;
               case '}':
                        if(!stack.empty()&&stack.pop()!='{')
                            System.out.println("unbalanced{");
                        break;

               case ')': if(!stack.empty()&&stack.pop()!=')')
                              System.out.println("unbalanced(");
                        break;

           }
        }
    }
    public void minStack(Stack<Integer>stack){
       // Stack<Integer>stack=new Stack<>();
        Stack<Integer>stack1=new Stack<>();
        stack1.push(stack.pop());
        while (!stack.empty()){
            int num1=stack.pop();
            int num2=stack1.pop();
            if(num1<num2){
                stack1.push(num1);
            }
            else {
                stack1.push(num2);
            }
        }
        System.out.println(stack1.pop());


    }
    public void reverseKElementQueue(){
        ArrayDeque<Integer> que=new ArrayDeque<>();
        que.add(10);
        que.add(20);
        que.add(30);
        que.add(40);

        Stack<Integer> stack=new Stack<>();
        int count=2,i=0;
        while (i<count){
            stack.push(que.remove());
            i++;
        }
        while (!stack.empty())
            que.add(stack.pop());

        if(que.size()%2==0){
            int k=count;
            i=0;
            while (i<k){
                int x=que.remove();
                que.add(x);
                i++;
            }
        }else{
            int k=count-1;
            i=0;
            while (i<k){
                int x=que.remove();
                que.add(x);
                i++;
            }
        }

        while (!que.isEmpty()){
            System.out.print(que.remove()+" ");
        }

    }
    public void reverseQueue(){
        ArrayDeque<Integer> que=new ArrayDeque<>();
        que.add(10);
        que.add(20);
        que.add(30);
        que.add(40);

        Stack<Integer> stack=new Stack<>();
        while (!que.isEmpty()){
            stack.push(que.remove());
        }
        display(stack);
    }
    public void reverseKElement(int count,Stack<Integer> stk){
        ArrayDeque<Integer> que=new ArrayDeque<>();
        int i=0;
        while (!stk.empty() && i<count){
            que.add(stk.pop());
            i++;
        }
        while (!que.isEmpty()){
            stk.push(que.remove());

        }
        display(stk);
    }
    public void reversestack(Stack<Integer> stk){
        Stack<Integer>stack=new Stack<>();
        while (!stk.empty()){
            stack.push(stk.pop());
        }
        display(stack);
    }

    public void bottomInsert(int x, Stack<Integer> stk){
        Stack<Integer>stack=new Stack<>();
        while (!stk.empty()){
            stack.push(stk.pop());
        }
        stk.push(x);
        while (!stack.empty()){
            stk.push(stack.pop());
        }
        display(stk);
        //return stk;
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
        int i=0;
        int len=stk.size();
      //  System.out.println(len);
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
