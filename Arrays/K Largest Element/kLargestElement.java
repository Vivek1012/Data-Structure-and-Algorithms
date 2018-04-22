import java.util.*;

public class kLargestElement{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in array :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		System.out.println("Enter the value of k:");
		int k = s.nextInt();
		
		//this make the priority queue which would return the minimum element first
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//this make the priority queue which would return the maximum element first
		PriorityQueue<Integer> pqmax = new PriorityQueue<Integer>(n , Collections.reverseOrder());
		
		
		for(int i = 0 ; i < n ; i++)
		{
			pq.add(arr[i]);
			pqmax.add(arr[i]);
		}
		
		for(int i = 0; i < k ; i++)
		{
			System.out.println(pq.poll() + "\t");
		}
		
		for(int i = 0; i < k ; i++)
		{
			System.out.println(pqmax.poll() + "\t");
		}
		
	}
}