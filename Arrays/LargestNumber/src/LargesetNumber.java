import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class LargesetNumber {

	public LargesetNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s =  new Scanner(System.in);
		System.out.println("Enter the number of elements :");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
		int A[]= new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			A[i] = s.nextInt();
		}
		
		System.out.println(largestNumber(A));
		
		int a[] = allFactors(21);
		
		for(int i = 0 ; i < a.length ; i++)
		{
			System.out.println(a[i]);
		}
		
		
		
	}
	
	public static String largestNumber(final int[] A) {
		String str = "";
		
		int n = A.length;
		String arr[] = new String[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = A[i] + "";
		}
		
		Arrays.sort(arr , new Comparator<String>(){
	        public int compare(String a, String b){
	            return (b+a).compareTo(a+b);}
	        });
		
			//Mycompare(arr);
			
			for(int i = 0 ; i < n ; i++)
			{
				System.out.print(arr[i] + "\t");
				str = str + arr[i];
			}
	
		return str;
		
		
	}

	private static void Mycompare(String[] arr) {
		// TODO Auto-generated method stub
		String xy, yx;
		String temp = "";
		for(int i = 0 ; i < arr.length-1; i++)
		{
			temp = "";
			xy = arr[i] + arr[i+1];
			yx =  arr[i+1] + arr[i];
			if(xy.compareTo(yx)<0)
			{
				temp = arr[i];
				arr[i] =  arr[i+1];
				arr[i+1] = temp;
			}
		}
	}
	
	  public static int[] allFactors(int A) {
	        
	        ArrayList<Integer> arrls = new ArrayList<Integer>();
	        
	        
	        for(int i = 1 ; i <= Math.abs(Math.sqrt(A)) ; i++)
	        {
	            
	            if((A % i) == 0)
	            {
	                arrls.add(i);
	            }
	        }
	        
	        int arr[] = new int[arrls.size()];
	        
	        for(int i = 0 ; i < arrls.size() ; i++)
	        {
	            arr[i] = arrls.get(i);
	        }
	        
	        return arr;
	    }
}
