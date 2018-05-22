import java.util.*;

public class LostElementinDuplicatedArray
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements in array : ");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array1 :");
		int arr1[] = new int[n];
		int arr2[] = new int[n-1];
		int xor1 = 0;
		int xor2 = 0;
		
		for(int i = 0 ; i < n ; i++)
		{
			arr1[i] = s.nextInt();
			xor1 = xor1 ^ arr1[i];
		}
		
		System.out.println("Enter the elements of array2 :");
		for(int i = 0 ; i < n-1 ; i++)
		{
			arr2[i] = s.nextInt();
			xor2 = xor2 ^ arr2[i];
		}
		
		//the best method is to use the XOR of both the array and return the XOR, that will be your answer
		
		System.out.println(xor1 ^ xor2);
		
	}
}
