import java.util.*;

public class OnlinealgorithmCheckingPalindrome
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the string :");
		String str = s.next();
		
		Stack<Character> stack = new Stack<Character>();
		ArrayList<Character> templist = new ArrayList<Character>();
		Stack<Character> revstack = new Stack<Character>();
		
		int n = str.length();
		char arr[] = str.toCharArray();
		boolean flag = false;
		
		for(int i = 0 ; i < n ; i++)
		{
			templist.add(arr[i]);
			
			for(int j = 0 ; j <= i ; j++)
			{
				stack.push(templist.get(j));
			}
			
			int a = 0;
			
			for(int j = i ; j >= 0 ; j--)
			{
				revstack.push(templist.get(j));
			}
			while(!stack.empty())
			{
				if(stack.pop() != revstack.pop())
				{
					flag = true;
					break;
				}
			}
			while(!stack.empty())
			{
				stack.pop();
			}
				
			while(!revstack.empty())
			{
				revstack.pop();
			}
			
			if(flag == true)
				System.out.println("No");
			else
				System.out.println("Yes");
			
			flag = false;
			
			
		
		}
		
	}
}