import java.util.*;

public class GCDinRange {
	static int SegmentTree[];
	
	public GCDinRange(int a[] , int n)
	{
		int height = (int)Math.ceil(Math.log(n)/ Math.log(2));
		
		int size = (int)(2 * Math.pow(2, height)) - 1;
		
		SegmentTree = new int[size];
		
	}
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements :");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		GCDinRange obj = new GCDinRange(arr , n);
		int start = 0 ; 
		int end = n-1;
		int pos = 0;
		obj.CreateSegmentTree(arr , start , end , pos);
		
		System.out.println("Enter the number of queries :");
		int m = s.nextInt();
	
		for(int i = 0 ; i < n ; i++) {
			System.out.println("Enter the range :");
			int l = s.nextInt();
			int r = s.nextInt();
			
			int val = findGCDinRange(0 , n-1 , l , r , 0);
			System.out.println("l = " + l + " r = " + r + " GCD = " + val);
		}
		
	}

	private static int findGCDinRange(int start, int end, int l, int r, int pos) {
		// TODO Auto-generated method stub
		
		//out of range
		int mid = start + (end-start)/2;
		if(l > r || l < 0 || r > SegmentTree.length-1)
			return -1;
		
		if(start >= l && end <= r)
			return SegmentTree[pos];
		
		if(end < l || start > r)
			return 0;
		
		return gcd(findGCDinRange(start , mid , l , r , 2*pos + 1) , findGCDinRange(mid + 1 , end , l , r , 2*pos + 2));
	}

	private int CreateSegmentTree(int[] arr, int start, int end, int pos) {
		// TODO Auto-generated method stub
		
		int mid = start + (end - start)/2;
		
		if(start == end)
		{
			SegmentTree[pos] = arr[start];
			return arr[start];
		}
		
		
		SegmentTree[pos] = (gcd(CreateSegmentTree(arr , start , mid , (2*pos + 1)) , CreateSegmentTree(arr , mid+1 , end , (2*pos + 2))));
		return SegmentTree[pos];
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		
		if(a == 0 && b != 0)
			return b;
		if(a != 0 && b == 0)
			return a;
		
		if(a == b)
			return a;
		
		if(a < b)
			return gcd(b%a , a);
		
		return gcd(a%b , b);
	}
}
