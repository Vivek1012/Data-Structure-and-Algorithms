import java.util.Scanner;

public class SearchSortRotate {

	public SearchSortRotate() {
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
		System.out.println();
		int pivot = findPivot(arr , 0 , n);
		System.out.println(pivot);
		
		
		System.out.println("Enter the key to find in array : ");
		int key = s.nextInt();
		int pos = 0;
		
		if(arr[pivot] < key)
			pos = -1;
		else if(arr[pivot] > key && arr[arr.length-1] < key)
		{
			int temparr[] = new int[pivot+1];
			for(int i = 0 ; i < temparr.length ; i++)
			{
				temparr[i] = arr[i];
			}
			 pos = findKey(temparr , 0 , temparr.length-1 , key);
		}
		else
		{
			int temparr[] = new int[n-pivot-1];
			for(int i = pivot+1 ; i < n ; i++)
			{
				temparr[i-pivot-1] = arr[i];
			}
			pos = findKey(temparr , 0 , temparr.length-1 , key) + pivot+1;
		}
		
		if(pos == -1)
			System.out.println("The given key was not found in array");
		else 
			System.out.println("The given key is present at index : " + pos);
	}
	public static int findKey(int a[] , int low , int high , int key )
	{
		int mid = (low+high)/2;
		
		if(low < high) {
			if(a[mid] == key)
				return mid;
			else if(a[mid] < key)
				return findKey(a , mid+1 , high , key);
			else if(a[mid] > key)
				return findKey(a , low , mid-1 , key);
		}
		return -1;
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
