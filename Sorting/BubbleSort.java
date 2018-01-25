import java.util.*;
public class BubbleSort{
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
		
		bubbleSort(arr);
		
		
		for(int i = 0; i < n ; i++)
		{
			System.out.print(arr[i] + "\t");
		}
		
	}
	
	public static void bubbleSort(int a[])
	{
	int temp;
		for(int i = 0 ; i < a.length ; i++)
		{
			for(int j = i+1 ; j < a.length ; j++)
			{
				if(a[i] > a[j])
				{
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}