import java.util.*;

public class kthLargestElement2DMatrix{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of nxn 2D matrix:");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[][] = new int[n][n];
		
		for(int i = 0; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				arr[i][j] = s.nextInt();
			}
		}
		
		System.out.println("Enter the value of k:");
		int k = s.nextInt();
		
		//this make the priority queue which would return the minimum element first
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		
		int K = k;
		int posi = Integer.MIN_VALUE, posj = 0;
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				if( K > 0)
					{
						pq.add(arr[i][j]);
						K--;
					}
				else 
				{
					posi = i;
					posj = j;
					break;
				}
			}
			if(posi == i)
				break;
		}
		
		int temp = 0;
		for(int i = posi; i < n ; i++)
		{
		for(int j = posj ; j < n ; j++)
			{
				temp = pq.peek();
				if(temp > arr[i][j])
					{
						pq.poll();
						pq.add(arr[i][j]);
					}
			}
			posj = 0;
		}
		
		for(int i = 0; i < k ; i++)
		{
			System.out.println(pq.poll() + "\t");
		}
		
	}
}