import java.util.*;

public class ArrayContainsDuplicateWithin_K_Distance
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter the value of k :");
		int k = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i< n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		HashMap<Integer , Integer> hm = new HashMap<Integer , Integer>();
		
		int i = 0;
		boolean flag = false;
		for(i = 0 ; i < n ; i++)
		{
			if(!hm.containsKey(arr[i]))
			{
				hm.put(arr[i] , i);
			}
			else
				{
					if((i - hm.get(arr[i])) <= k)
						flag = true;
					else
						hm.put(arr[i] , i);
				}
		}
		
		System.out.println(flag);
	}
}
