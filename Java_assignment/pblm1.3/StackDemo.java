import java.util.*;
import java.io.*;
public class StackDemo
{
  public static void main (String args[])
  {
    Stack stack=new Stack();
    stack.push(new Integer(10));
    stack.push("a");
    System.out.println("The contents of Stack is " + stack);
    System.out.println("The size of the stack is " + stack.size());
    System.out.println("The number popped out is " + stack.pop());
    System.out.println("The number popped out is " + stack.pop());
    //System.out.println("The number popped out is " + stack.pop());
    System.out.println("The contents of Stack is " + stack);
    System.out.println("The size of the stack is " + stack.size());
  }
}
 