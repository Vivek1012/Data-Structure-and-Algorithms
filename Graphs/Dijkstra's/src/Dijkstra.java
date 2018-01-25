/*Algorithm is for directed graph only !
 * using priority Queue or Heap we can implement the Dijkstra algorithm
 * */
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;


class Node{
	int endnode;
	int weight;
	
	public Node(int endnode , int weight) {
		this.endnode = endnode;
		this.weight = weight;
	}
} 

class Graph {

	int V;

	public char color[];
	public LinkedList<Integer>[] AdjList;
	public LinkedList<Integer>[] WgtList;
	public Node Heap[];
	public int discover[];
	public int finish[];
	public int Pi[];
	public int weight;
	int t = 0;

	public Graph(int n) {
		this.V = n;
		AdjList = new LinkedList[n];
		WgtList = new LinkedList[n];
		color = new char[n];
		discover = new int[n];
		finish = new int[n];
		Pi = new int[n];

		for (int i = 0; i < n; i++) {
			AdjList[i] = new LinkedList<>();
			WgtList[i] = new LinkedList<>();			
		}
		Pi[0] = 0;
	}
}

public class Dijkstra {

	public Dijkstra() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s = new Scanner(System.in);

		System.out.println("Enter the number of nodes you have :");
		int n = s.nextInt();

		Graph vertex = new Graph(n);
		int u;
		int v;
		int w;

		do {
			System.out.println("Enter the edges with start vertex u and end vertex v :");
			u = s.nextInt();
			v = s.nextInt();
			
			if (u == 0 && v == 0)
				break;

			System.out.println("Enter the edge weight : ");
			w = s.nextInt();

			addnode(vertex , u , v , w);

		} while (u != 0 || v != 0);

		printGraph(vertex);
		
		System.out.println("Enter the start vertex ");
		int startnode = s.nextInt();
		System.out.println("Enter the end vertex ");
		int endnode = s.nextInt();
		
		
		showDijkstraPath( vertex , startnode , endnode);
		
	}

	public static void addnode(Graph v, int start, int end , int weight) {
		
		v.AdjList[start].addFirst(end);
		v.WgtList[start].addFirst(weight);

		if (v.color[start] != 'R')
			v.color[start] = 'R';

		//v.AdjList[end].addFirst(start);

		if (v.color[end] != 'R')
			v.color[end] = 'R';

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
	}

	//Heap implementation starts from here
	
	public static void showDijkstraPath(Graph vertex , int start , int end)
	{
		String nodetrack = start + "";
		vertex.Heap = new Node[1];
		int myweight = 0;
		
		vertex.Heap[0] = new Node(0,0);
		
		vertex.color[0] = 'Y';
		int i = start, j = 0;
		while(start != end)
		{
			if(vertex.Heap[0].weight == 0 && vertex.Heap[0].endnode == 0)
			{
				vertex.Heap = new Node[0];
				while(j < vertex.AdjList[i].size()) {
					
					Node temp = new Node( vertex.AdjList[i].get(j) , vertex.WgtList[i].get(j));
					int val = vertex.AdjList[i].get(j);
					vertex.color[val] = 'Y';
					insertHeap(vertex , vertex.Heap , vertex.Heap.length , temp);
					j++;
				}
				buildHeap(vertex.Heap);
			}
			
			Node n = deleteMinKey(vertex , vertex.Heap ,  vertex.Heap.length);
			nodetrack = nodetrack + " " + n.endnode;
			i = n.endnode;
			j= 0;
			while(j < vertex.AdjList[i].size()) {
				int endnode = vertex.AdjList[i].get(j);
				int weight = vertex.WgtList[i].get(j) + n.weight;
				
				if(vertex.color[endnode] == 'Y')
				{
					int pos = getdecrease_key(vertex.Heap , endnode);
					if(vertex.Heap[pos].weight > weight)
					{
						vertex.Heap[pos].weight = weight;
						j++;
					}
				}
				else if(vertex.color[endnode] == 'R') {
					Node temp = new Node(endnode , weight);
					insertHeap(vertex , vertex.Heap , vertex.Heap.length , temp);
					j++;
				}
			}
			buildHeap(vertex.Heap);
			start = n.endnode;	
			myweight = n.weight;
		}
		
		System.out.println("The path from source to destination node is = " + nodetrack);
		System.out.println("The Weight of shortest path = " + myweight);
		
	}
	
	public static void insertHeap(Graph vertex, Node[] heap , int count , Node key) {
		// TODO Auto-generated method stub
		vertex.Heap = new Node[count+1];
		
		for(int i = 0; i < count ; i++)
		{
			vertex.Heap[i] = heap[i];
		}
		vertex.Heap[count] = key; 
		
	}
	
	public static int getdecrease_key(Node[] heaparr, int endnode) {
		// TODO Auto-generated method stub
		for(int i = 0; i < heaparr.length ; i++ )
		{
			if(heaparr[i].endnode == endnode)
				return i;
		}
		return 1;
	}

	public static void buildHeap(Node[] build_heap)
	{
		
		int child = build_heap.length - 1;
		int parent = (child - 1)/2;
		Node temp = null;
		
		while(parent >= 0)
		{
			if(build_heap[parent].weight > build_heap[child].weight)
			{
				temp = build_heap[parent];
				build_heap[parent]= build_heap[child];
				build_heap[child] = temp;
			}
			
			if(parent != 0)
			{
				child = parent;
				parent = (child - 1)/2;
			}
			else {
				parent = -1;
			}
			temp = null;
		}
	}
	
	public static Node deleteMinKey(Graph vertex , Node heap[], int count) 
	{

		Node min = vertex.Heap[0];
		
		Node temp = heap[0];
		heap[0] = heap[heap.length - 1];
		heap[heap.length - 1] = temp;
		
		vertex.Heap = new Node[count-1];
		for(int i = 0; i < count-1 ; i++)
		{
			vertex.Heap[i] = heap[i];
		}
		
		heapify(vertex , count-1);
		
		return min;
	}
	
	public static void heapify(Graph vertex, int count)
	{
		int parent = 0;
		int lchild = (2*parent) + 1;
		int rchild = (2*parent) + 2;
		int len = vertex.Heap.length - 1;
		
		while((parent <= len) || (parent <= len-1))
		{
			if(lchild >= len) {
				if(len == 1)
				{
					if(vertex.Heap[lchild].weight < vertex.Heap[parent].weight) {
						Node temp = vertex.Heap[lchild];
						vertex.Heap[lchild] = vertex.Heap[parent];
						vertex.Heap[parent] = temp;
						
						break;
					}
					else 
						break;
				}
				else 
					break;
			}
				
			else {
				int small_child = (vertex.Heap[lchild].weight > vertex.Heap[rchild].weight) ? rchild : lchild; 
				
				if(vertex.Heap[small_child].weight < vertex.Heap[parent].weight)
				{
					Node temp = vertex.Heap[small_child];
					vertex.Heap[small_child] = vertex.Heap[parent];
					vertex.Heap[parent] = temp;
					
					parent = small_child;
					lchild = (2*parent) + 1;
					rchild = (2*parent) + 2; 
					
				}
				else
					break;
			}

		}
	}
}

