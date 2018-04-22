import java.util.*;

public class SlidingWindowMaximum
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int maxval = arr[0];
		
		System.out.println("Enter the value of k :");
		int k = s.nextInt();
		
		int i = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k , Collections.reverseOrder());
		
		while(i < k)
		{
			pq.add(arr[i]);
			i++;
		}
		
		while(i < n)
		{
			System.out.println(pq.poll());
			pq.add(arr[i]);
			i++;
		}
		
	}
}