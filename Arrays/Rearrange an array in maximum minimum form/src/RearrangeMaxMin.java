//-------------------------------Problem----------------------------
/*Given a sorted array of positive integers,
rearrange the array alternately i.e first element should be the maximum value,
second minimum value, third-second max, fourth-second min and so on.
*/
//-------------------------------Example-------------------------
/*Input  : arr[] = {1, 2, 3, 4, 5, 6, 7} 
Output : arr[] = {7, 1, 6, 2, 5, 3, 4}

Input  : arr[] = {1, 2, 3, 4, 5, 6} 
Output : arr[] = {6, 1, 5, 2, 4, 3}*/

//------------------------------Solution 1-------------------------
//Simply use the additional array and store the values in alternate fashion, taking 2 pointers in account

//-------------------------------Solution 2-------------------------

/*In this post a solution that requires O(n) time and O(1) extra space is discussed. 
 * The idea is to use multiplication and modular trick to store two elements at an index.

even index : remaining maximum element.
odd index  : remaining minimum element.
 
max_index : Index of remaining maximum element
            (Moves from right to left)
max_index : Index of remaining minimum element
            (Moves from left to right)

Initialize: max_index = 'n-1'
            min_index = 0  
            max_element = arr[max_index] + 1 

For i = 0 to n-1            
    If 'i' is even
       arr[i] += arr[max_index] % max_element * max_element 
       max_index--     
    ELSE // if 'i' is odd
       arr[i] +=  arr[min_index] % max_element * max_element
       min_index++
       
How does expression “arr[i] += arr[max_index] % max_element * max_element” work ?
The purpose of this expression is to store two elements at index arr[i]. 
arr[max_index] is stored as multiplier and “arr[i]” is stored as remainder. 
For example in {1 2 3 4 5 6 7 8 9}, max_element is 10 and we store 91 at index 0. 
With 91, we can get original element as 91%10 and new element as 91/10.
*/

import java.util.*;
public class RearrangeMaxMin {

	public RearrangeMaxMin() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("enter the number of elements for array :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements fo array :");
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		Arrays.sort(arr);
		
		RearrangeMax_min(arr , n);
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print(arr[i] + "\t");
		}
	}

	private static void RearrangeMax_min(int[] arr, int n) {
		// TODO Auto-generated method stub
		
		int min_pos = 0;
		int max_pos = n-1;
		
		int max_val = arr[n-1] + 1;
		
		for(int i = 0 ; i < n ; i++)
		{
			if(i%2 == 0)
			{
				arr[i] += (arr[max_pos]%max_val) * max_val;
				max_pos--;
			}
			else
			{
				arr[i] += (arr[min_pos]%max_val) * max_val;
				min_pos++;
			}
		}
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = arr[i]/max_val;
		}
		
		
		//-----------------------------------------
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		a.add(3);
		a.add(2);
		a.add(0);
		a.add(1);
		
		  int m = a.size();
		    for(int i = 0 ; i < a.size() ; i++)
		    {
		        int x = ((a.get(a.get(i)) % m) % m ) * m;
		        x = a.get(i) + (x);
		        
		        a.set(i, x);
		    }
		
	}

}
