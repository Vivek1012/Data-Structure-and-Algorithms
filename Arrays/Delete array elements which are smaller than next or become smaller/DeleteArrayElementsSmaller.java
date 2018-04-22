import java.util.*;
import java.lang.*;

public class DeleteArrayElementsSmaller
{
	public static void main(String args[])
	{
		Scanner s =  new Scanner(System.in);
		
		System.out.println("Enter the number of elements in array : ");
		int n = s.nextInt();
		
		System.out.println("Enter the value of K: ");
		int k = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(arr[0]);
		int i = 1;
		for(i = 1; i < n ; i++)
		{
			if(!stack.isEmpty())
			{
				while (arr[i] > stack.peek())
				{
					stack.pop();
					k--;
					if(stack.isEmpty() || k == 0)
						break;
				}
			}

			if(k == 0)
				break;			
			stack.push(arr[i]);
				

		}
		
		for(;i < n ; i++)
		{
			stack.push(arr[i]);
		}
		Stack<Integer> stack1 = new Stack<Integer>();
		while(!stack.isEmpty()){
			stack1.push(stack.pop());
		}
		
		while(!stack1.isEmpty())
		{
			System.out.println(stack1.pop());
		}
	}
}