import java.util.*;
public class QuickSort{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements you want to sort : ");
		int n = s.nextInt();
		
		System.out.println("Enter the elements : ");
		int arr[] = new int[n];
		for(int i = 0; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		quickSort(arr , 0 , n-1);
		
		System.out.println("Sorted Array list : ");
		for(int i = 0; i < n ; i++)
		{
			System.out.print(arr[i] + "\t");
		}
	}
	
	public static void quickSort(int a[] , int l , int r)
	{
		//pivot(a , l , r);
		
		
		for(int i = 0; i < a.length ; i++)
		{
			System.out.print(a[i] + "\t");
		}
		System.out.println();
		if(l<r){
		int p = l;
			int k = partision(a , l , r , p);
			
			quickSort(a , l , k);
			quickSort(a , k+1 , r);
		}
	}
	
	public static int partision(int a[] , int l , int r , int m)
	{
	int i , j , p;
	i=l;
	j=r;
	p=m;
	int x, temp;
		while(i<j){
			System.out.println(l + " " + m + " " + r);
			System.out.println(a[l] + " " + a[m]);
			while(i<r && a[i] <= a[m] ){
			i++;
			}
			while(j>l && a[j] > a[m]){j--;}
		
			if(i<j){
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				
				i++;
				j--;
			}
			else{
				x = a[j];
				a[j] = a[m];
				a[m] = x;
				break;
		}
		}
		return j;
		
	}
	
	public static int pivot(int a[] , int l , int r)
	{
		return l;
	}
	
}