import java.util.*;
public class MaxSumSequence{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements you want : ");
		int  n = s.nextInt();
		
		int a[] = new int[n+1];
		int p[] = new int[n+1];
				
		a[0] = 0;
		p[0] = 0;
		
		for(int i = 1 ; i <= n ; i++ )
		{
			a[i] = s.nextInt();
		}
		
		for(int i = 1 ; i <= n ; i++)
		{
			p[i] = p[i-1] + a[i];
		}
		
		int i = 0; 
		int j = 1; 
		int m = a[j] - a[i];
		j++;
		
		while(j<=n)
		{
		
			if(p[i] > p[j-1])
				i = j-1;
			if(m < (p[j] - a[i]))
				m = (p[j] - p[i]);
		j++;
		
		}
		
		System.out.println(m);
		
	}
}