import java.util.*;

public class TwosComplement
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the String:");
		String str = s.next();
		char ch[] = str.toCharArray();
		int i = str.length()-1;
		
		
		while(i >= 0)
		{
			if(ch[i] == '1')
				break;
			i--;	
		}
		i--;
		for(; i >=0 ; i--)
		{
			if(ch[i] == '1')
				ch[i] = '0';
			else
				ch[i] = '1';
		}
		
		for(i = 0 ; i < ch.length ; i++)
		{
			System.out.print(ch[i] + "\t");
		}
		
	}
}