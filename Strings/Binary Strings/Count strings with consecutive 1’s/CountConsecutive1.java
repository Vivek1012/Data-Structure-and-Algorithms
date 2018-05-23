import java.util.*;

public class CountConsecutive1
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number n for binary bits :");
		int n = s.nextInt();
		
		int a[] = new int[n];
		int b[] = new int[n];
		
		a[0] = 1;
		b[0] = 1;
		
		for(int i = 1 ; i < n ; i++)
		{
			a[i] = a[i-1] + b[i-1];
			b[i] = a[i-1];
		}
		
		System.out.println((int)Math.pow(2 , n) - a[n-1] - b[n-1]);
		
	}
}