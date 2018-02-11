import java.util.Arrays;
import java.util.Scanner;

public class CountSubstrings {

	public CountSubstrings() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string :");
		String str = s.next();
		
		System.out.println("Enter the value of k :");
		int k = s.nextInt();
		
		int count[] = new int[26];
		int n = str.length();
		int count_dist = 0;
		int distsubstring = 0;
		
		for(int i = 0; i < n ; i++) {
			
			Arrays.fill(count, 0);
			count_dist = 0;
			for(int j = i ; j < n ; j++)
			{
				if(count[(int)str.charAt(j) - 'a'] == 0)
					count_dist++;
				
				count[(int)str.charAt(j) - 'a']++;
						
				if(count_dist == k)
					distsubstring++;
			}
		}
		
		System.out.println("The number of substring with " + k + "th distinct elements are : " + distsubstring );
	}

}
