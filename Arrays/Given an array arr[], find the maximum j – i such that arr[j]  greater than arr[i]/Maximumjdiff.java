import java.util.*;

public class Maximumjdiff{

	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int ltr[] = new int[n];
		int rtl[] = new int[n];
		
		ltr[0] = arr[0];
		for(int i = 1 ; i < n ; i++)
		{
			ltr[i] = min(arr[i] , ltr[i-1]);
		}
		rtl[n-1] = arr[n-1];
		
		for(int i = n-2 ; i >= 0 ; i--)
		{
			rtl[i] = max(arr[i] , rtl[i+1]);
		}
		
		int i = 0;
		int j = 0;
		int maxval = 0;
		while(i < n && j < n)
		{
			if(ltr[i] < rtl[j])
			{
				maxval = max(maxval , (j-i));
				j = j + 1;
			}
			else
				i = i + 1;
		}
		
		System.out.println(maxval);
	}
	
	
	public static int max(int a, int b)
	{
		return ((a>b) ? a : b);
	}
	
	public static int min(int a, int b)
	{
		return ((a<b) ? a : b);
	}

}
