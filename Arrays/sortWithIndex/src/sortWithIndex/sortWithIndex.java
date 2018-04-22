package sortWithIndex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class sortWithIndex {

	public sortWithIndex() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class item{
			int element;
			int index;
			
			public item(int ele , int id)
			{
				element = ele;
				index = id;
			}
		}
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements for Array :");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		item items[] = new item[n];
		
		for(int i = 0; i < n ; i++)
		{
			arr[i] = s.nextInt();
			items[i] = new item(arr[i] , i);
		}
		
		Arrays.sort(items, new Comparator<item>() {
			 @Override
			    public int compare(item i1, item i2) {
			        return Integer.compare(i1.element , i2.element);
			 }
		});
		
		for(int i = 0 ;  i < n ; i++)
		{
			System.out.print(items[i].element + "\t");
		}
		System.out.println();
		for(int i = 0 ;  i < n ; i++)
		{
			System.out.print(items[i].index + "\t");
		}
		
	}

}
