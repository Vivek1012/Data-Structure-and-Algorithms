import java.util.Scanner;

public class MaximumCharacter {

	public MaximumCharacter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the input string w/o space in it :");
		String str = s.next();
		
		char arrTostr[] = str.toCharArray();
		int max = Integer.MIN_VALUE;
		
		int pos[] = new int[26];
		int charpos = 0;
		
		for(int i = 0 ; i < arrTostr.length ; i++)
		{
			if(arrTostr[i]>=65 && arrTostr[i] <= 90) 
			{
				pos[(int)arrTostr[i]-65]++;
				if(max < pos[(int)arrTostr[i]-65]) {
					max = pos[(int)arrTostr[i]-65];
					charpos = (int)arrTostr[i]-65;
				}
			}
			else if(arrTostr[i]>=97 && arrTostr[i] <= 122)
			{
				pos[((int)arrTostr[i])-97]++;
				if(max < pos[(int)arrTostr[i]-97]) {
					max = pos[(int)arrTostr[i]-97];
					charpos = (int)arrTostr[i]-97;
				}
			}
		}
		
		System.out.println("The maximum ocurrance of a character is : " + ((char)(charpos+97)) + " with the value is " +  max);
		
	}

}
