import java.util.*;
public class DeterministicRank{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements for array : ");
		int n = s.nextInt();
		System.out.println("Enter the elements : ");		
		int arr[] = new int[n];
		for(int i = 0; i < n ; i++)
		{
			arr[i] = s.nextInt(); 
		}
		
		System.out.println("Enter the rank to find number:");
			int r = s.nextInt();
		
		int num = rank(a, 0 , n-1 , r);
		System.out.println("The Number whose Rank is " + r + "  = " + num);
	}
	
	public static int rank(int a[] , int i , int j , int r)
	{
		int p = pivot(arr , i , j-i+1);
		int k = partision(a, i , j-i+1 , p);
		
		if(r == j-k+1)
			return k;
		else if(r < j-k+1)
			return rank(arr , k+1 , j , r);
		else if(r > j-k+1)
			return rank(arr , i , k-1 , r-(j-k+1));
	}
	public static int partision(int a[] , int i , int j, int k)
	{
		//swapping the random pivot with a[0] then applying the basic quicksort algo.
		int temp = a[p];
		a[p] = a[i];
		a[i] = temp;
		
		//now form here apply the partision algo of quick sort only.
		int l = i;
		int r = j;
		
		while(i<j)
		{
			while(a[l])
		}
	}
	
	public static int pivot(int a[] , int l , int r)
	{
		//code to give the random number between l and r.
		Random rand = new Random();
		int ran = rand.nextInt((r - l) + 1) + l;
		return ran;
	}
}