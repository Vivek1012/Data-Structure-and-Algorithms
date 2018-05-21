import java.util.*;

public class RangeSum {
	public static void main(String args[])
	{
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
		System.out.println(block);
		Arrays.sort(query , new Comparator<Query>() {

			@Override
			public int compare(Query o1, Query o2) {
				if(o1.left/block != o2.left/block)
					return Integer.compare((o1.left/block) , (o2.left/block));
				
				return Integer.compare(o1.right , o2.right);
			}
		});
	
		
		int start = 0; 
		int end = 0;
		int maxsum = 0;
		int L = 0 , R = 0;
		for(int i = 0 ; i < m ; i++)
		{
			L = query[i].left;
			R = query[i].right;
			//if start is not in range of current Left and Right
			
			while(start < L)
			{
				maxsum = maxsum - arr[start];
				start++;
			}
			
			while(start > L)
			{
				maxsum = maxsum + arr[start-1];
				start--;
			}
			
			while(end > R+1)
			{
				maxsum = maxsum - arr[end-1];
				end--;
			}
			while(end <= R)
			{
				maxsum = maxsum + arr[end];
				end++;
			}
			
			System.out.println("for " + L + " and " +  R + " we have greater sum as : " + maxsum);
		}
	}
}
