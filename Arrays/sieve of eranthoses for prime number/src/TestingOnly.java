import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class TestingOnly {

	public TestingOnly() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the value of A and B :");
		
		Scanner s = new Scanner(System.in);
		int val = cpFact(s.nextInt() , s.nextInt());
		
		System.out.println(val);

	}

	   public static int cpFact(int A, int B) {
	        
	        int arr[] = allFactors(A);
	        int index = 0;
	        
	        for(int i = arr.length-1 ; i >=0 ; i--)
	        {
	            if(gcd(arr[i] , B) == 1)
	            { index = i;
	                break;
	            }
	        }
	        
	        return arr[index];
	    }
	    public static int gcd(int A, int B) {
	        
	        if(A == 0 && B != 0)
	            return B;
	        if(A != 0 && B == 0)
	            return A;

	        if(A == B)
	            return A;
	            
	        if(A>B)
	            return gcd(A-B , B);
	        
	        return gcd(A, B-A);
	    }
	    
	     public static int[] allFactors(int A) {
	        
	        ArrayList<Integer> arrls = new ArrayList<Integer>();
	        
	        
	        for(int i = 1 ; i <= (Math.abs(Math.sqrt(A))) ; i++)
	        {
	            
	            if((A % i) == 0)
	            {
	                arrls.add(i);
	                if(A>1 && i != (A/i))
	                    arrls.add(A/i);
	                
	            }
	        }
	        
	        int arr[] = new int[arrls.size()];
	        
	        for(int i = 0 ; i < arrls.size() ; i++)
	        {
	            arr[i] = arrls.get(i);
	        }
	        
	        Arrays.sort(arr);
	        
	        return (arr);
	    }
}
