import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class FindDuplicate {

	public FindDuplicate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SAXException, JAXBException {
		// TODO Auto-generated method stub
		
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of element's in array : ");
		int n = s.nextInt();
		
		System.out.println("Enter the elements of array :");
//		int arr[] = new int[n];
//		for(int i = 0 ; i < n; i++)
//		{
//			arr[i] = s.nextInt();
//		}
		
//		the basic idea to find the duplicate in given array is to change the value of array to -ve if
//		it is +ve else the given number is duplicate.
		
//		for(int i =0 ; i < n ; i++)
//		{
//		
//		}
		
		ArrayList a = new ArrayList<Integer>();
		
		for(int i = 0 ; i < n; i++)
		{
			a.add(s.nextInt());
		}
		
		
		 int arr[] = new int[a.size()];
		 for(int i  = 0; i < n ; i++)
		 {
			 arr[i] = (int) a.get(i);
		 }
		 
		 for(int i  = 0; i < n ; i++)
		 {
			if(arr[Math.abs(arr[i])] > 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.println(Math.abs(arr[i]));
		 }
	}

}

