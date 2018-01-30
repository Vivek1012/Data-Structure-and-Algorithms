import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackusingSingleQueue {

	public StackusingSingleQueue() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
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
				enqueueAsPush(queue, item);
				break;

			case 2:
				dequeueAsPop(queue);
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
	//after rotation the latest element will always present at the top front of queue, we could easliy remove it
	private static void dequeueAsPop(Queue<Integer> queue) {
		// TODO Auto-generated method stub
		
		System.out.println("The poped out element is  = " + queue.poll());
		
	}

	//The basic approach is to insert the element in queue, after insertion just rotate all the values of queue once
	private static void enqueueAsPush(Queue<Integer> queue, int item) {
		// TODO Auto-generated method stub
	
		queue.add(item);
		for(int i = 1 ; i < queue.size(); i++)
		{
			queue.add(queue.poll());
		}
		
	}
}