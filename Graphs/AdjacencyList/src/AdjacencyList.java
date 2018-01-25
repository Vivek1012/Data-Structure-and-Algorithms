import java.util.LinkedList;
import java.util.Scanner;
class Vertex {
	int V;
	
	public LinkedList<Integer> AdjList[];

	public Vertex(int n) {
		this.V = n;
		AdjList = new LinkedList[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			AdjList[i] = new LinkedList<>();
		}
	}
}

public class AdjacencyList{

	public static void addnode(Vertex v , int start , int end)
	{
		v.AdjList[start].addFirst(end);
		
		v.AdjList[end].addFirst(start);
	}
	
	  static void printGraph(Vertex vertex)
	    {       
	        for(int v = 0; v < vertex.V; v++)
	        {
	            System.out.println("Adjacency list of vertex "+ v);
	            System.out.print("head");
	            for(Integer pCrawl: vertex.AdjList[v]){
	                System.out.print(" -> "+pCrawl);
	            }
	            System.out.println("\n");
	        }
	    }
	  

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of nodes you have :");
		int n = s.nextInt();
		
		Vertex vertex = new Vertex(n);
		int u;
		int v;
		
		do
		{
			System.out.println("Enter the edges with start vertex u and end vertex v :");
			u = s.nextInt();
			v = s.nextInt();
			
			if(u == 0 && v == 0)
				break;
			
			addnode(vertex , u , v);
			
		}while(u != 0 || v != 0);
		
		printGraph(vertex);
	}

}
