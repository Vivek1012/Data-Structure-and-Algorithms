import java.util.*;
public class MedianofSortedArraysSameSize
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = s.nextInt();
		
		int arr1[] = new int[n];
		int arr2[] = new int[n];
		
		System.out.println("Enter the sorted element for 1st array:");
		for(int i = 0 ; i < n ; i++)
		{
			arr1[i] = s.nextInt();
		}
		
		System.out.println("Enter the sorted element for 2st array:");
		for(int i = 0 ; i < n ; i++)
		{
			arr2[i] = s.nextInt();
		}
		
		int val = getMedian(arr1 , 0 , n-1 , arr2 ,0 ,  n-1);
		System.out.println(val);
	}
	
	public static int getMedian(int[] arr1 ,int s1 ,int e1 , int[] arr2 , int s2 , int e2){
		System.out.println(arr1[s1] + "\t" + arr1[e1]);
		System.out.println(arr2[s2] + "\t" + arr2[e2]);
	
		if((e1 - s1) == 0 && (e2 - s2) == 0)// it means you have only 1 element left
		{
			return (arr1[e1] + arr2[e2])/2;
		}
		if((e1 - s1) == 1 && (e2 - s2) == 1)// it means you have only 2 element left
		{
			return (Math.max(arr1[s1] , arr2[s2]) + Math.min(arr1[e1] , arr2[e2]))/2;
		}
		
		int mid1 = s1 + (e1-s1)/2;
		int mid2 = s2 + (e2-s2)/2;
		
		if(arr1[mid1] < arr2[mid2])
		{
			return getMedian(arr1 , mid1 , e1 , arr2 , s2 ,  mid2);
		}
		
		//if(arr1[mid1] > arr2[mid2])
			return getMedian(arr1 , s1 , mid1 , arr2 , mid2 ,  e2);
		
	}
}