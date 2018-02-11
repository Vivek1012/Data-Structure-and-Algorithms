import java.util.Scanner;

public class NonrepeatingCharacter {

	public NonrepeatingCharacter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =  new Scanner(System.in);
		
		System.out.println("Enter the string without spaces :");
		String str = s.next();
		
		System.out.println("Enter the kth position :");
		int k = s.nextInt();
		
		int n = str.length();
		int countarr[] = new int[26];
		
		for(int i = 0 ; i < n ; i++)
		{
			countarr[(int)str.charAt(i) - 97]++;
		}
		
		int count = 0;
		int pos = 0;
		for(int i = 0 ; i < n ; i++)
		{
			if(countarr[(int)str.charAt(i) - 97] == 1)
				count++;
			
			if(count == k)
			{
				pos = (int)str.charAt(i) - 97;
				break;
			}
		}
		
		System.out.println("The character at kth position with non repeteations is = " + (char)(pos+97));
	}

}
