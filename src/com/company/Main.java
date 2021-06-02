package com.company;


import com.Linklist.BasicLinkList;
import com.Linklist.CircularSinglyLinklist;
import com.Linklist.DoubleLinklist;
import com.stack.StackFunction;
import com.stack.StackUsingLinklist;

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        // write your code here

        BasicLinkList list=new BasicLinkList();
       // list.controller();

        DoubleLinklist doubleLinklist=new DoubleLinklist();
       // doubleLinklist.doubleLinklistController();

        CircularSinglyLinklist circularSinglyLinklist=new CircularSinglyLinklist();
        //circularSinglyLinklist.circularController();

        StackFunction stackFunction=new StackFunction();
        stackFunction.stackController();

        StackUsingLinklist stackUsingLinklist=new StackUsingLinklist();
       // stackUsingLinklist.listController();
     }


}
