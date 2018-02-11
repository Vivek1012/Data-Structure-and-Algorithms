import java.util.Scanner;

public class AnagramSubstringSearch {

	public AnagramSubstringSearch() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the text :");
		String txt = s.next();
		char text[] = txt.toCharArray();
		int clonetxt[] = new int[26];
		int n = text.length;
		
		System.out.println("Enter the pattern :");
		String pat = s.next();
		char patt[] = pat.toCharArray();
		int clonepat[] = new int[26];
		int p = patt.length;
		
		for(int i = 0 ; i < p ; i++)
		{
			clonetxt[text[i] - 'A']++;
			clonepat[patt[i] - 'A']++;
		}
		
		for(int i = p ; i < n ; i++)
		{
			if(compare(clonetxt , clonepat) == true)
				System.out.println("The pattern found at index = " + (i - p));
			
			clonetxt[text[i] - 'A']++;
			clonetxt[text[i-p] - 'A']--;
				
		}
		if(compare(clonetxt , clonepat) == true)
			System.out.println("The pattern found at index = " + (n - p));
	}
	
	public static boolean compare(int[] clonetxt , int[] clonepat)
	{
		for(int i = 0; i < clonepat.length; i++)
		{
			if(clonepat[i] != clonetxt[i])
				return false;
		}
		return true;
	}

}
