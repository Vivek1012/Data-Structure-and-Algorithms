// Problem to find the position of i and j such that a[i] + a[j] = x;
// where x is any random number
import java.util.*;

public class Problem1_1 {

	public Problem1_1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner s =  new Scanner(System.in);
		
		System.out.println("Enter the nubmer x : ");
		int x = s.nextInt();
		
		System.out.println("Enter the number of elements in Array : ");
		int n = s.nextInt();
		
		int a[] = new int[n];
		System.out.println("Enter the elements of Array :");
		
		for(int i=0 ; i< n ; i++)
		{
			a[i] = s.nextInt();
		}
		
		boolean find = false;
		// Algo having the O(n^2)
		/*
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = i+1 ; j < n ; j++)
			{
				if((a[i] + a[j]) == x)
				{
					find  = true;
				}
			}
		}*/
		
		//Algo 2
		//Algo having the O(nlogn)
		//sort the array first
		
		int foundIndex = 0 ;
		
		Arrays.sort(a);
		/*
		for(int i = 0 ; i < a.length ; i++)
		{
			foundIndex = Arrays.binarySearch(a, (x-a[i]));
			if(foundIndex != -1 )
			{
				find  = true;
				break;
			}
		}
		*/
		
		//Algo 3
		//Algo having the O(n)
		//Given that the array is already sorted
		
		int l = 0;
		int r = a.length-1;
			
		while(l <= r)
		{
			if(a[l] == a[r]) {
				find = true;
				foundIndex = l;
				break;
			}
			else if((a[l]+a[r]) > x)
				r--;
			else 
				l++;
		}
		
		
		System.out.println("The Index = " + foundIndex);
		if(find)
			System.out.println("The sum of 2 number's is equivalent to x : " + find);
		else
			System.out.println("The sum of 2 number's is equivalent to x : " + find);
	}

}
