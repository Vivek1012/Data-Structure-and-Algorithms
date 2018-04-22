import java.util.*;

public class kNumbersWithMostOccurrence
{
	public static void main(String args[])
	{
	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array :");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		
		System.out.println("Enter the elements of array :");
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
	
		System.out.println("Enter the value of k :");
		int k = s.nextInt();
		
		HashMap<Integer , Integer> hm = new HashMap<Integer , Integer>();
		
		for(int i = 0 ; i < n ; i++)
		{
			if(!hm.containsKey(arr[i]))
			{
				hm.put(arr[i] , 1);
			}
			else
				hm.put(arr[i] , hm.get(arr[i])+1);
		}
		
		ArrayList<Integer> ar = new ArrayList<Integer>(hm.values());
		
		Collections.sort(ar, Collections.reverseOrder());
		
		for(int i = 0 ; i < ar.size() ; i++)
		{
			System.out.println("Key = " + ar.get(i));
		}
		int i  = 0;
		for(Map.Entry<Integer , Integer> entry : hm.entrySet())
		{
				if(entry.getValue() == ar.get(i))
					{
						System.out.println("value = " + entry.getKey());
						i++;
					}
					
					if(i == k)
						break;
				
		}
	}
}