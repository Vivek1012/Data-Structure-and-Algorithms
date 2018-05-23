import java.util.*;

public class BinaryStringsFromGivenPattern
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string:");
		String str = s.next();
		
		Queue<String> queue =  new LinkedList<String>();
		
		queue.add(str);
		
		while(!queue.isEmpty())
		{
			String sq = queue.poll();
			System.out.println(sq);
			int i = sq.indexOf('?');
			
			if(i >= 0)
			{
				queue.add(sq.substring(0, i)+ '0' + sq.substring(i+1, sq.length()));
				queue.add(sq.substring(0, i)+ '1' + sq.substring(i+1, sq.length()));
			}
			else
			{
				while(!queue.isEmpty())
				{
					System.out.println(queue.poll());
				}
				break;
			}
		}
	}
}
