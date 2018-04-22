import java.util.*;

public class SortElementsByFrequency
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements in array :");
		int n = s.nextInt();
		
		System.out.println("Enter the element of array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		HashMap<Integer , Integer> hm = new HashMap<Integer, Integer>();
		
		for(int i = 0 ; i < n ; i++)
		{
			if(!hm.containsKey(arr[i]))
				hm.put(arr[i] , 1);
			else
				hm.put(arr[i] , hm.get(arr[i])+1);
		}
		
		for(Map.Entry<Integer, Integer> entry : hm.entrySet())
		{
			System.out.println(entry.getKey() +"\t"+entry.getValue());
		}
	}
}