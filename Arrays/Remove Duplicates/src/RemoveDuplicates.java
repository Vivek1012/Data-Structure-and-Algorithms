import java.util.Scanner;

public class RemoveDuplicates {

	public RemoveDuplicates() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
				
		System.out.println("Enter the number of elements for array : ");
		int n  = s.nextInt();
		
		int arr[] = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = s.nextInt();
		}
		
		int i = 0;
		int j = 1;
		while(j < n)
		{
			if(arr[i] != arr[j])
			{
				arr[++i] = arr[j];
			}
			j++;
		}
		
		for(int x = 0 ; x <= i ; x++)
		{
			System.out.println(arr[x]);
		}
	}

}
