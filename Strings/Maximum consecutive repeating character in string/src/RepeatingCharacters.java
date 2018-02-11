import java.util.Scanner;

public class RepeatingCharacters {

	public RepeatingCharacters() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the string :");
		String str = s.next();
		int n = str.length();
		int count = 1;
		int max = Integer.MIN_VALUE;
		char res = ' ';
		
		for(int i = 0; i < n ; i++)
		{
			if(i < n-1 && str.charAt(i) == str.charAt(i+1))
			{
				count++;
			}
			else {
				count = 1;
			}
			
			if(count > max)
			{
				max = count;
				res = str.charAt(i);
			}
		}
		
		System.out.println("The most repeating character is = " + res);
	}

}
