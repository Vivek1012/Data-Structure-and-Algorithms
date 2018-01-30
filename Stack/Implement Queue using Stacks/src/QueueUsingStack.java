import java.util.*;

public class QueueUsingStack {

	public QueueUsingStack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		System.out.println("Enter the digits to perform the opertaions : ");
		System.out.println("Enter 1 for Insert in Queue :");
		System.out.println("Enter 2 to Delement element from Queue : ");
		System.out.println("Enter 0 to exit :");

		Scanner s = new Scanner(System.in);
		int op = s.nextInt();

		while (op != 0) {
			if (op == 1) {
				System.out.println("Enter the item to insert in Queue :");
				int item = s.nextInt();

				Mypush(stack1, stack2, item);
			}
			if (op == 2) {
				DeleteItem(stack1, stack2);
			}
			System.out.println("Enter the digits to perform the opertaions : ");
			System.out.println("Enter 1 for Insert in Queue :");
			System.out.println("Enter 2 to Delement element from Queue : ");
			System.out.println("Enter 0 to exit :");
			op = s.nextInt();
		}

	}

	private static void DeleteItem(Stack<Integer> stack1, Stack<Integer> stack2) {
		// TODO Auto-generated method stub
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
		if(!stack2.isEmpty())
			System.out.println("The element deleted is = " + stack2.pop());
		else
			System.out.println("The queue is already empty !");
	}

	private static void Mypush(Stack<Integer> stack1, Stack<Integer> stack2, int item) {
		// TODO Auto-generated method stub
		stack1.push(item);
	}

}
