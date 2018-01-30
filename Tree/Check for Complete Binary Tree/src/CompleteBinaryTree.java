import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	Node left;
	Node right;
	int data;
	
	public Node()
	{
		left = null;
		right = null;
		data = 0;
	}
	public Node(int item)
	{
		this.data = item;
	}
}
public class CompleteBinaryTree {

	public static Node root = null;
	public CompleteBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Select the option to perform the operation :");
		System.out.println("Select 1 to enter the item in Tree :");
		System.out.println("Select 2 to see the preOrder traversal of Tree :");
		System.out.println("Select 3 to check the Tree is Complete Binary Tree :");
		
		Scanner s = new Scanner(System.in);
		int op = s.nextInt();
		
		while(op != 0)
		{
			switch(op)
			{
			case 1 : System.out.println("Enter the value you want to insert : ");
					 insertNode();
					 break;
					 
			case 2 : System.out.println("PreOrder traversal of given Tree is : ");
					 preOrder(root);
					 break;
					 
			case 3 : boolean isCBT = CheckCompleteBinaryTree(root);
					 if(!isCBT)
						 System.out.println("The given tree is not complete binary Tree");
					 else
						 System.out.println("The given tree is complete binary Tree");
					 break;
			
			
			}
			System.out.println("Select the option to perform the operation :");
			System.out.println("Select 1 to enter the item in Tree :");
			System.out.println("Select 2 to see the preOrder traversal of Tree :");
			System.out.println("Select 3 to check the Tree is Complete Binary Tree :");
			op = s.nextInt();
		}
		
	}
	/* Given a binary tree, return true if the tree is complete
    else false */
	private static boolean CheckCompleteBinaryTree(Node node) {
		// TODO Auto-generated method stub
		
		//Create an empty queue which store the nodes of tree
		Queue<Node> queue = new LinkedList<Node>();
		Node tempNode = new Node();
		//insert the root node in tree
		queue.add(node);
		//this is the boolean flag maintained to check for invalid complete binary tree
		Boolean flag = false;
		
		// now insert delete the nodes from queue unless the queue will become empty
		while(!queue.isEmpty())
		{
			
			tempNode = queue.remove();
			//check if the node is not null
			if(tempNode.left != null)
			{
				// this condition would check weather there is a node previous to this node is not a full node, if it does than
				// the tree is not a complete binary tree, return false in this case.
				if(flag == true)
					return false;
				// this is else part, to insert the left node in queue
				queue.add(tempNode.left);
			}
			//if this is not a full node than, set this flag as true
			else
				flag = true;
			
			if(tempNode.right != null)
			{
				// this condition would check weather there is a node previous to this node is not a full node, if it does than
				// the tree is not a complete binary tree, return false in this case.
				if(flag == true)
					return false;
				
				queue.add(tempNode.right);
			}
			//if this is not a full node than, set this flag as true
			else
				flag = true;
		}
		
		return true;
		
	}

	private static void preOrder(Node node) {
		// TODO Auto-generated method stub
		if(node != null)
		{
			System.out.println(node.data + "\t");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	private static void insertNode() {
		// TODO Auto-generated method stub
		root = insert(root);
	}

	private static Node insert(Node node) {
		// TODO Auto-generated method stub
		
		  /* Let us construct the following Binary Tree which
        is not a complete Binary Tree
              1
            /   \
           2     3
          / \     \
         4   5     6
      */
		
	     	node = new Node(1);
	        node.left = new Node(2);
	        node.right = new Node(3);
	        node.left.left = new Node(4);
	        node.left.right = new Node(5);
	        node.right.right = new Node(6);
	         
	        return node;
	}

}
