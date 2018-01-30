import java.util.Scanner;
import java.util.Stack;

public class MinStack {

	public MinStack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> minStack = new Stack<Integer>();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the options to perform the operations :");
		System.out.println("Enter 1 to push in array :");
		System.out.println("Enter 2 to pop from array :");
		System.out.println("Enter 3 to get minimum element form array :");
		System.out.println("Enter 0 to exit :");
		
		int op = s.nextInt();
		
		while(op != 0)
		{
			switch(op)
			{
				case 1: System.out.println("Enter the item you want to push :");
						int item = s.nextInt();
						if(stack.isEmpty())
						{
							stack.push(item);
							minStack.push(item);
						}
						else
						{
							MyPush(stack , minStack , item);
						}
						break;
						
				case 2 : MyPop(stack , minStack);
						 break;
				
				case 3 : GetMin(stack , minStack);
						 break;
						 
				case 0 : break;
			}
			
			System.out.println("Enter the options to perform the operations :");
			System.out.println("Enter 1 to push in array :");
			System.out.println("Enter 2 to pop from array :");
			System.out.println("Enter 3 to get minimum element form array :");
			System.out.println("Enter 0 to exit :");
			
			op = s.nextInt();
		}
		
	}

	private static void GetMin(Stack<Integer> stack, Stack<Integer> minStack) {
		// TODO Auto-generated method stub
		if(!minStack.isEmpty())
		{
			System.out.println("The minimum element is = " + minStack.peek());
		}
	}

	private static void MyPush(Stack<Integer> stack, Stack<Integer> minStack , int item) {
		// TODO Auto-generated method stub
		
		if(minStack.peek() > item) {
			minStack.push(item);
		}
		stack.push(item);
	}

	private static void MyPop(Stack<Integer> stack, Stack<Integer> minStack) {
		// TODO Auto-generated method stub
		
		if(stack.peek() == minStack.peek())
		{
			System.out.println("This is the minimum element " + minStack.peek());
			minStack.pop();
		}
		stack.pop();
	}
}
