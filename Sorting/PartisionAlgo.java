import java.util.*;
public class PartisionAlgo{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of elements you want : ");
		int n = s.nextInt();
		
		System.out.println("Enter the elements : ");
		int arr[] = new int[n];
		for(int i = 0; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		partision(arr , 0 , arr.length);
		
		System.out.println("Sorted Array list : ");
		for(int i = 0; i < n ; i++)
		{
			System.out.print(arr[i] + "\t");
		}
	}
	

public static int partision(int a[] , int l , int r )
	{
	int i , j;
	i=l;
	j=r;
	int m = (l+r)/2;
	int p = m;
	//p=m;
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
}