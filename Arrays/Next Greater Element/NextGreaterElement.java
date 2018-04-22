// This implementation uses stack to find the next greter element in array
// Else the cheapest solution is to use the brute force to get it done.

import java.util.*;

public class NextGreaterElement{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the value n for array :");
		int n =  s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		Stack<Integer> st = new Stack<Integer>();
		
		st.push(arr[0]);
		
		int next = 0;
		int element = 0;
		
		for(int i = 1;  i < n ; i++)
		{
			next = arr[i];
			
			if(!st.empty())
			{
				element = st.pop();
				
				
				while(element < next)
				{
					System.out.println(next + "\t");
					if(!st.isEmpty())				
						element = st.pop();
					else				
						break;
				}
				
				if(element > next)
					st.push(element);
			}
			st.push(next);
		}
		while(!st.isEmpty())
		{
			System.out.println("-1" + "\t");
			st.pop();
		}
		
	}

}
