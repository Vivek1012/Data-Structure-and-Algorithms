import java.util.*;

public class QueriesforGCDExceptRange
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Emter the size of array:");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		System.out.println("Enter the number of queries : ");
		int m = s.nextInt();
		
		int prefix[] = new int[n];
		int suffix[] = new int[n];
		findPrefix(arr , prefix , n);
		findSuffix(arr , suffix , n);
		
		for(int i = 0 ; i < m ; i++)
		{
		System.out.println("Enter the range <l,r> :" );
			int l = s.nextInt();
			int r = s.nextInt();
			
			if(l < 0 || r > n-1)
				{
					System.out.println("Out of range index : ");
					continue;
				}
				
			if(l == 0)
				System.out.println(suffix[r+1]);
			else if(r == n-1)
				System.out.println(prefix[l-1]);
			else if(l >=0 && r <= n-1)
				System.out.println(gcd(prefix[l-1] , suffix[r+1]));
		}
		
	}
	
	public static void  findPrefix(int[] a , int[] pre , int n)
	{
		pre[0] = a[0];
		
		for(int i = 1 ; i < n ; i++)
		{
			pre[i] = gcd(pre[i-1] , a[i]);
		}
	}
	
	
	public static void  findSuffix(int[] a , int[] suf , int n)
	{
		suf[n-1] = a[n-1];
		
		for(int i = n-2 ; i >= 0 ; i--)
		{
			suf[i] = gcd(suf[i+1] , a[i]);
		}
	}
	
	public static int gcd(int a , int b)
	{
		if(a == 0 && b != 0)
			return b;
		if(a != 0 && b == 0)
			return a;
		
		if(a == b)
			return a;
		
		if(a<b)
			return gcd(b%a , a);
			
		return gcd(a%b , b);
	}
	
}