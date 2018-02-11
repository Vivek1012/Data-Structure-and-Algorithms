import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Testing_String {

	public Testing_String() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int x = 0 ; x < t ; x++)
		{
		    String str = s.next();
		    char arr[] = str.toCharArray();
		    int n = arr.length;
		    int k = s.nextInt();
		    
		    int chr[] = new int[26];
		    int max = Integer.MIN_VALUE;
		    int sum = 0;
		    
		    for(int i = 0 ; i < n ; i++)
		    {
		        chr[arr[i] - 'a']++;
		    }

		    PriorityQueue<Integer> Pqueue = new PriorityQueue<Integer>(n , Collections.reverseOrder());
			
		    for(int i = 0 ; i < 26 ; i++)
		    {
		    	Pqueue.add(chr[i]);
		    }
		    
		    int dummy = k;
		    int head = 0;
		    
		   
		    while(dummy > 0)
		    {
	    		head = Pqueue.poll();
	    		head = head - 1;
	    		Pqueue.add(head);
	    		
	    		dummy--;
		    }
		    
		    while(!Pqueue.isEmpty())
		    {
		    	if(Pqueue.peek() != 0)
		    		sum = sum + (int)Math.pow(Pqueue.poll() , 2 );
		    	else 
		    		Pqueue.poll();
		    }
		    System.out.println(sum);
		}
	}
}
		
	