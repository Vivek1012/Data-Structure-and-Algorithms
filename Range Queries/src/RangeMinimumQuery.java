import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RangeMinimumQuery {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of queries : ");
		int m = s.nextInt();
		
		System.out.println("Enter the value of <l,r> and press enter for m values :");
		Query query[] = new Query[m];
		
		for(int i = 0 ; i < m ; i++)
		{
			query[i] = new Query(s.nextInt() , s.nextInt());
		}
		
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		int block = (int)Math.sqrt(n);
		Arrays.sort(query , new Comparator<Query>() {
	
			@Override
			public int compare(Query o1, Query o2) {
				if(o1.left/block != o2.left/block)
					return Integer.compare((o1.left/block) , (o2.left/block));
				
				return Integer.compare(o1.right , o2.right);
			}
		});
		
		int start = 0 , end = 0 ;
		int min = Integer.MAX_VALUE;
		int L = 0 , R = 0;
		
		for(int i = 0 ; i < m ; i++)
		{
			L = query[i].left;
			R = query[i].right;
			//min = Integer.MAX_VALUE;
			
			System.out.println("L = " + L + " R = " + R);
			
			while(start < L)
			{
				//System.out.println("1");
				if(min == arr[start])
					min = arr[start+1];
				
				if(min > arr[start])
					min = arr[start];
				
				start++;
			}
			
			while(start > L)
			{
				//System.out.println("2");
				if(min == arr[start])
					min = arr[start-1];
				
				if(min > arr[start])
					min = arr[start];
				
				start--;
			}
			
			while(end > R+1)
			{
				//System.out.println("3");
				if(min == arr[end])
					min = arr[end-1];
				
				if(min >= arr[end-1])
					min = arr[end-1];
				
				end--;
			}
			while(end <= R)
			{
				//System.out.println("4");
				if(min == arr[end])
					min = arr[end+1];
				
				if(min > arr[end])
					min = arr[end];
				
				end++;
			}
			
			System.out.println(min);
		}
	}
}
