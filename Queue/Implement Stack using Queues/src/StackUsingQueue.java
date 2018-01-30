import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueue {

	public StackUsingQueue() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();

		Scanner s = new Scanner(System.in);

		System.out.println("Press the options to perform the operations : ");
		System.out.println("Enter 1 to insert an element :");
		System.out.println("Enter 2 to delete an element : ");
		System.out.println("Enter 3 to see element at the front of queue :");
		System.out.println("Enter 0 to exit :");

		int op = s.nextInt();

		while (op != 0) {
			switch (op) {
			case 1:
				System.out.println("Enter the item you want to insert : ");
				int item = s.nextInt();
				enqueueAsPush(queue1, queue2, item);
				break;

			case 2:
				dequeueAsPop(queue1, queue2);
				break;

			case 3:
				break;

			case 0:
				break;
			}

			System.out.println("Press the options to perform the operations : ");
			System.out.println("Enter 1 to insert an element :");
			System.out.println("Enter 2 to delete an element : ");
			System.out.println("Enter 3 to see element at the front of queue :");
			System.out.println("Enter 0 to exit :");

			op = s.nextInt();
		}
	}

	/*
	 * Now to pop an element you just need to perform dequeue operation on queue1
	 */
	private static void dequeueAsPop(Queue<Integer> queue1, Queue<Integer> queue2) {
		// TODO Auto-generated method stub
		int delelement = 0;
		if (!queue1.isEmpty()) {
			delelement = queue1.poll();
		}
		System.out.println("The deleted element from top of the stack = " + delelement);
	}

	/*
	 * enqueue new item in queue2, only 1 element at a time Now move all the
	 * elements from queue1 to queue2 swap names of queue1 and queue2
	 * 
	 */
	private static void enqueueAsPush(Queue<Integer> queue1, Queue<Integer> queue2, int item) {
		// TODO Auto-generated method stub
		if (queue2.isEmpty()) {
			queue2.add(item);
		}

		while (!queue1.isEmpty()) {
			queue2.add(queue1.poll());
		}

		SwapQueues(queue1, queue2);
	}

	private static void SwapQueues(Queue<Integer> queue1, Queue<Integer> queue2) {
		// TODO Auto-generated method stub
		while (!queue2.isEmpty()) {
			queue1.add(queue2.poll());
		}

	}

}
