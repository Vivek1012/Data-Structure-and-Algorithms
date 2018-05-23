import java.util.*;

public class Minflips{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the String :");
		String str = s.next();
		char ch[] = str.toCharArray();
		int i = 0;
		char last = ch[0];
		int count = 0;
		int n = ch.length;
		
		while(i < n){
			if(ch[i] != last)
			{
				count++;
			}
			last = ch[i];
			i++;		
		}
		
		System.out.println(count/2);
	}
}