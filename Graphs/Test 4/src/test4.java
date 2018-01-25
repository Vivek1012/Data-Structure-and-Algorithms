import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//RED initially
//After insertions in Queue Yellow
//After Deletion Blue

class Graph {
	
	int V;
	
	public char color[];
	public char color1[];
	public char color2[];
	public int val1= 0;
	public int val2 = 0;
	
	public LinkedList<Integer> AdjList[];
	public LinkedList<Integer>[] WgtList;
	public LinkedList<Integer> Graph1[];
	public LinkedList<Integer>[] WgtList1;
	public LinkedList<Integer> Graph2[];
	public LinkedList<Integer>[] WgtList2;
	
	

	public Graph(int n) {
		this.V = n;
		AdjList = new LinkedList[n];
		WgtList = new LinkedList[n];
		Graph1 = new LinkedList[n];
		WgtList1 = new LinkedList[n];
		Graph2 = new LinkedList[n];
		WgtList2 = new LinkedList[n];
		
		
		color = new char[n];
		color1 = new char[n];
		color2 = new char[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			AdjList[i] = new LinkedList<>();
			Graph1[i] = new LinkedList<>();
			Graph2[i] = new LinkedList<>();
			WgtList[i] = new LinkedList<>();
			WgtList1[i] = new LinkedList<>();
			WgtList2[i] = new LinkedList<>();
		}
	}
}
public class test4 {


	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the number of nodes you have :");
		int n = s.nextInt();
		
		Graph vertex = new Graph(n);
		int u;
		int v;
		int w;
		int one = 0;
		int two = 0;
		int three = 0;
		
		do
		{
			System.out.println("Enter the edges with start vertex u and end vertex v :");
			u = s.nextInt();
			v = s.nextInt();
			
			if(u == 0 && v == 0)
				break;
			
			System.out.println("Enter the edge weight : ");
			w = s.nextInt();
			if(w == 1)
				one++;
			if(w == 2)
				two++;
			if(w==3)
				three++;
			
			addnode(vertex , u , v ,w );
			
		}while(u != 0 || v != 0);
		
		seperateGraph(vertex);
		
		printGraph(vertex);
		
		BFSTraversal(vertex);
		BFSTraversalGraph1(vertex);
		BFSTraversalGraph2(vertex);
		
		System.out.println("hey");
		if(vertex.val1 != 1 || vertex.val1 != 1)
		{
			System.out.println("-1");
		}
		else
			System.out.println(7 -(((2*vertex.V) - 2) - three));
		
	}
	
	private static void seperateGraph(Graph vertex) {
		
		 for(int v = 0; v < vertex.V; v++)
	        {
	           
	            for(int i = 0 ; i < vertex.WgtList[v].size() ; i++){
	            	if(vertex.WgtList[v].get(i) == 1)
	            	{
	            		vertex.Graph1[v].add(vertex.AdjList[v].get(i));
	            		vertex.WgtList1[v].add(vertex.WgtList[v].get(i));
	            	}
	            	if(vertex.WgtList[v].get(i) == 3)
	            	{
	            		vertex.Graph1[v].add(vertex.AdjList[v].get(i));
	            		vertex.WgtList1[v].add(vertex.WgtList[v].get(i));
	            		vertex.Graph2[v].add(vertex.AdjList[v].get(i));
	            		vertex.WgtList2[v].add(vertex.WgtList[v].get(i));
	            		
	            	}
	            	if(vertex.WgtList[v].get(i) == 2)
	            	{
	            		vertex.Graph2[v].add(vertex.AdjList[v].get(i));
	            		vertex.WgtList2[v].add(vertex.WgtList[v].get(i));
	            	} 
	            }
	           
	        }
		
	}

	public static void BFSTraversalGraph1(Graph g)
	{
		
		 Queue<Integer> q = new LinkedList<>();
		 int bfsarr[] = new int[g.V];
		 
		 q.add(0);
		 g.color1[0] = 'Y';
		 int value =  g.Graph1[0].getFirst();
		 int count = 0;
		 
		 while(!q.isEmpty()) {
			 value = q.peek();
			 for(Integer val : g.Graph1[value]) {
				 if(g.color1[val] == 'R') {
					 q.add(val);
					 g.color1[val] = 'Y';
				 }
			 }
			 if(count < g.V)
				 bfsarr[count] = q.poll();
			 count++;
			 if(count == g.V)
				 break;
			 
			 g.color1[value] = 'B';
		 }
		 
		 int c = 0;
		 for(int i = 0 ; i < g.V ; i++)
		 {
			 if(g.color1[i] == 'B')
				 c++;
		 }
		 
		 if(count == 5)
			 g.val1 = 1;
		 
		 printBFSTraversal(bfsarr);
	}
	

	public static void BFSTraversalGraph2(Graph g)
	{
		 Queue<Integer> q = new LinkedList<>();
		 int bfsarr[] = new int[g.V];
		 
		 q.add(0);
		 g.color2[0] = 'Y';
		 int value =  g.Graph2[0].getFirst();
		 int count = 0;
		 
		 while(!q.isEmpty()) {
			 value = q.peek();
			 for(Integer val : g.Graph2[value]) {
				 if(g.color2[val] == 'R') {
					 q.add(val);
					 g.color2[val] = 'Y';
				 }
			 }
			 if(count < g.V)
				 bfsarr[count] = q.poll();
			 count++;
			 if(count == g.V)
				 break;
			 
			 g.color2[value] = 'B';
		 }
		 
		 
		 int c = 0;
		 for(int i = 0 ; i < g.V ; i++)
		 {
			 if(g.color1[i] == 'B')
				 c++;
		 }
		 
		 if(count == 5)
			 g.val2 = 1;
		 
		 printBFSTraversal(bfsarr);

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
	
	public static void addnode(Graph v, int start, int end , int weight) {
		
		v.AdjList[start].addFirst(end);
		v.WgtList[start].addFirst(weight);

		if (v.color[start] != 'R')
			v.color[start] = 'R';
		v.color1[start] = 'R';
		v.color2[start] = 'R';

		v.AdjList[end].addFirst(start);
		v.WgtList[end].addFirst(weight);
		
		if (v.color[end] != 'R')
			v.color[end] = 'R';
		v.color1[end] = 'R';
		v.color2[end] = 'R';

	}

	
	static void printGraph(Graph vertex) {
		for (int v = 0; v < vertex.V; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			//System.out.print(vertex.color[v]);
			for (Integer pCrawl : vertex.AdjList[v]) {
				System.out.print(" -> " + pCrawl);
			}
			
			System.out.println();
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : vertex.WgtList[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
		//graph 1
		System.out.println("\n");
		System.out.println("\n");
		for (int v = 0; v < vertex.V; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			//System.out.print(vertex.color[v]);
			for (Integer pCrawl : vertex.Graph1[v]) {
				System.out.print(" -> " + pCrawl);
			}
			
			System.out.println();
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : vertex.WgtList1[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
		
		//graph 2

		System.out.println("\n");
		System.out.println("\n");
		
		for (int v = 0; v < vertex.V; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			//System.out.print(vertex.color[v]);
			for (Integer pCrawl : vertex.Graph2[v]) {
				System.out.print(" -> " + pCrawl);
			}
			
			System.out.println();
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : vertex.WgtList2[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

}
