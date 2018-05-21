import java.util.Scanner;

public class RangeSumQuery {
	static int SegmentTree[];
	// this is the constructor to initialize the segment tree or we could say to create a Segement Tree
	public RangeSumQuery(int a[] ,int n) 
	{
		int x = (int)Math.ceil(Math.log(n) / Math.log(2));
		
		int size = (int)(2 * Math.pow(2, x) - 1);
		
		SegmentTree = new int[size];
		
		/*
			1st argument a = input array
			2nd argument start index for segment tree
			3rd argument end index for segment tree
			4th argument is the position in segment tree to enter value
		*/
	}
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements in array : ");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		RangeMinimumQuery obj = new RangeMinimumQuery(arr , n);
		obj.ConstructST(arr , 0 , n-1 , 0); 
		
		System.out.println("Enter the range <a,b> to find the sum :");
		int l = s.nextInt();
		int r = s.nextInt();
		/*
		 * 1st argument Start index of segement tree
		 * 2nd argument end index of segment tree
		 * 3rd argument start index of left value in range
		 * 4th argument end index of right value in range
		 * 5th argument current index of segment tree
		 * 6th argument length of input array
		 * */
		int val = findSuminRange(0 , n-1 , l , r , 0, n);
		System.out.println(val);
//		for(int i = 0 ; i < SegmentTree.length ; i++)
//		{
//			System.out.println(SegmentTree[i]);
//		}
	}
	
	private static int findSuminRange(int i, int j, int l, int r, int k, int n) {
		// TODO Auto-generated method stub
		if(l < 0 || r > n-1 || l > r)
			return -1;
		
		if(l <= i && r >= j)
			return SegmentTree[k];
		
		if(l > j || r < i)
			return 0;
		
		int mid = i + (j-i)/2;
		
		return (findSuminRange(i , mid , l , r , 2*k + 1, n) + findSuminRange(mid+1 , j , l , r , 2*k + 2, n));
		
	}
	public int ConstructST(int arr[] , int start , int end , int pos)
	{
		int mid = start + (end -start ) / 2;
		
		if(start == end)
			{
				SegmentTree[pos] = arr[start];
				return arr[start];
			}
		
		SegmentTree[pos] = (ConstructST(arr , start , mid , 2 * pos + 1) + ConstructST(arr , mid + 1 , end , 2 * pos + 2));
		return SegmentTree[pos];
	}
}
