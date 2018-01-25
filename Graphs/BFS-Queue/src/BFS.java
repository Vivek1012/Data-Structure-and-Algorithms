import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//RED initially
//After insertions in Queue Yellow
//After Deletion Blue

class Graph {
	
	int V;
	
	public char color[];
	public LinkedList<Integer> AdjList[];

	public Graph(int n) {
		this.V = n;
		AdjList = new LinkedList[n];
		color = new char[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			AdjList[i] = new LinkedList<>();
		}
	}
}
public class BFS {

	public BFS() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of nodes you have :");
		int n = s.nextInt();
		
		Graph vertex = new Graph(n);
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
		
		BFSTraversal(vertex);
		
	}
	
	public static void BFSTraversal(Graph g)
	{
		 Queue<Integer> q = new LinkedList<>();
		 int bfsarr[] = new int[g.V];
		 
		 q.add(0);
		 g.color[0] = 'Y';
		 int value =  g.AdjList[0].getFirst();
		 int count = 0;
		 
		 while(!q.isEmpty()) {
			 value = q.peek();
			 for(Integer val : g.AdjList[value]) {
				 if(g.color[val] == 'R') {
					 q.add(val);
					 g.color[val] = 'Y';
				 }
			 }
			 if(count < g.V)
				 bfsarr[count] = q.poll();
			 count++;
			 if(count == g.V)
				 break;
			 
			 g.color[value] = 'B';
		 }
		 
		 printBFSTraversal(bfsarr);
	}
	
	private static void printBFSTraversal(int[] bfsarr) {

		for(int i = 0 ; i < bfsarr.length ; i++)
		{
			System.out.println(bfsarr[i]);
		}
		
	}

	public static void addnode(Graph v , int start , int end)
	{
		v.AdjList[start].addFirst(end);
		
		if(v.color[start] != 'R')
			v.color[start] = 'R';
		
		v.AdjList[end].addFirst(start);
		
		if(v.color[end] != 'R')
			v.color[end] = 'R';
		
	}
	
	  static void printGraph(Graph vertex)
	    {       
	        for(int v = 0; v < vertex.V; v++)
	        {
	            System.out.println("Adjacency list of vertex "+ v);
	            System.out.print("head");
	            System.out.print(vertex.color[v]);
	            for(Integer pCrawl: vertex.AdjList[v]){
	                System.out.print(" -> "+pCrawl);
	            }
	            System.out.println("\n");
	        }
	    }

}
