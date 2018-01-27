import java.util.Scanner;

public class PairSum {

	public PairSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		System.out.println("Enter the array elements :");
		
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ;i++)
		{
			arr[i] = s.nextInt();
		}
		
		System.out.println("Enter the number of postition you want to rotate :");
		
		int t = s.nextInt();
		
		for(int i = 0 ; i < t ; i++)
		{
			int temp = arr[0];
			for(int j = 0 ; j < n-1 ; j++)
			{
				arr[j] = arr[j+1];
			}
			arr[n-1] = temp;
		}
		
		for(int i = 0; i < n ; i++ )
		{
			System.out.print(arr[i] + " ");
		}
	
		
		System.out.println("Enter the number to find sum :");
		int x = s.nextInt();
		
		boolean val = findPairSum(arr , n , x);
		System.out.println(val);
		

	}
	
	private static boolean findPairSum(int[] arr, int n, int x) {

		System.out.println();
		int l = findPivot(arr , 0 , n); // here l is the pivot element which has the maximum value
		
		int r = (l+1)%n; // and r is the element next to pivot which is minimum element
		
		while(l!=r)
		{
			if(arr[l] + arr[r] == x)
				return true;
			else if((arr[l] + arr[r]) < x)
				r = (r+1)%n; // this will search in the right half of the array
			else if((arr[l] + arr[r]) > x)
				l = (n+l-1)%n; // this will search in the left half of the array
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	public static int findPivot(int a[] , int low , int high )
	{
		//its a code to find the element just greater than next element
		//Ex. 3 4 5 6 7 1 2 hence 7 become the pivot for this function
		
		int mid = (low + high)/2;
		
		if(low>high)
			return -1;
		if(low == high)
			return low;
		
		if(a[mid] > a[mid + 1])
			return mid;
		if(a[mid] < a[mid - 1])
			return  mid-1;
		if(low <= mid && a[low] <= a[mid])
			return findPivot(a , mid+1 , high);
//		if(mid < high && a[mid] < a[high])
			return findPivot(a , low , mid-1);
	}


}
