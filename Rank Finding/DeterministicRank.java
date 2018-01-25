import java.util.*;
public class DeterministicRank{
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
		
		int medarr[] = new int[5];
		int count = 0; 
		for(int i = 0 ; i < n ; i = i+5)
		{
				medarr[count] = insertionSort(arr , i , i+4);
				//System.out.print(medarr[count] + " ");
				count++;
		}
		
		
		
		int median = insertionSort(medarr , 0 , count);
		
		System.out.println("Median = " + median);
		
		System.out.println("Sorted Array list : ");
		for(int i = 0; i < n ; i++)
		{
			System.out.print(arr[i] + "\t");
		}
		
	}
	
	
	public static int insertionSort(int a[] , int s , int e)
	{
	int key, j;
		for(int i = s+1 ; i <= e ; i++)
		{
			j = i-1;
			key = a[i];
				while(j >= s && key < a[j])
				{
					a[j+1] = a[j];
					j--;
				}
				a[j+1] = key;
		}
		return (a[s+2]);
	}
}