import java.util.Scanner;
import java.util.Stack;

public class StackImplementation {

	public StackImplementation() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();

		System.out.println("Enter the digits to perform the opertaions : ");
		System.out.println("Enter 1 for push :");
		System.out.println("Enter 2 for pop : ");
		System.out.println("Enter 3 for peek : ");
		System.out.println("Enter 4 to check is stack empty :");

		Scanner s = new Scanner(System.in);
		int op = s.nextInt();

		do {
			switch (op) {
			case 1:
				System.out.println("Enter the element you want to push :");
				int ele = s.nextInt();
				Mypush(stack, ele);
				break;

			case 2:
				Mypop(stack);
				break;

			case 3:
				Mypeek(stack);
				break;

			case 4:
				CheckEmpty(stack);
				break;

			case 0:
				break;

			default:
				System.out.println("Please select the appropriate option :");
				break;

			}
			System.out.println("Enter the digits to perform the opertaions : ");
			System.out.println("Enter 1 for push :");
			System.out.println("Enter 2 for pop : ");
			System.out.println("Enter 3 for peek : ");
			System.out.println("Enter 4 to check is stack empty :");
			System.out.println("Enter 0 to exit :");
			op = s.nextInt();
		} while (op != 0);

	}

	private static void CheckEmpty(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if (stack.isEmpty())
			System.out.println("The stack is empty !");
		else
			System.out.println("The stack is not empty !");
	}

	private static void Mypeek(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		System.out.println("The top of the stack have element = " + stack.peek());

	}

	private static void Mypop(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		System.out.println("The poped out element = " + stack.pop());

	}

	private static void Mypush(Stack<Integer> stack, int ele) {

}
