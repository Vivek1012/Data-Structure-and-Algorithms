import java.util.*;

class Node
{	
	Node left;
	Node right;
	Node parent;
	int data , height;
	
	public Node()
	{
		left = right = null;
		parent = null;
		height = 1;
		data = 0;
	}

	public Node(int item)
	{
		left = right = null;
		data = item;
		height = 1;
	}

}

public class AVLImplement{

	public static Node root = null;
		
	public static void main(String args[])
	{		
	
		Scanner s = new Scanner(System.in);
		
		int option = 0 ; 

		do{
			System.out.println("Press 1 to insert !");
			System.out.println("Press 2 to Delete !");
			System.out.println("Press 3 to Search the node !");			
			System.out.println("Press 4 to show the Preorder traversal of BST !");
			System.out.println("Press 5 to print the parents : ");
			System.out.println("Press 6 to show inOrder : ");
			System.out.println("Press 0 to Exit !");
			
		
			option = s.nextInt();
			
			switch(option)
				{
					case 1 : System.out.println("Enter the Key to Insert !");
							 insert(s.nextInt());
							 break;
					
					case 2 : System.out.println("Enter the Key to delete the element :");
							 delete(s.nextInt());
							 //int minimum = getMinimum(root);
							 //System.out.println("minimum = " + minimum);
							// setMinimum(root , minimum);
							 System.out.println("After deletion the PreOrder Traversal of BST is :");
							 preOrder(root);
							 break;
					
					case 3 : System.out.println("Enter the Key to Search : ");
							 Node found = searchkey(root , s.nextInt());
							 
							 if(found != null)
								System.out.println("The given key is Present in BST !");
							 else 
								System.out.println("The Given key is not Present in BST !");
								
						 	 break;
						 	 
					case 4 : System.out.println("The PreOrder Traversal of BST : ");
							 preOrder(root);
							 break;
			
					case 5 : System.out.println("Enter the node to find all the parents : ");
							  System.out.println("The Parent's of the node are : ");
							  showParent(s.nextInt());
							  break;
							
					case 6 : System.out.println("The inorder traversal of tree : ");
							  inOrder(root);
							  break;
						  			
					case 0 : break;
				}
		}while(option != 0);				
		
		System.out.println("Enter the item to insert in BST");		
	}
	
	public static void insert(int item)
	{
		root = insertNode(root , item);
	}
	
	public static Node insertNode(Node root , int value)
	{
		if(root == null)
		{
			root = new Node(value);
			root.parent = null;
			return root;
		}
		else if(root.data > value)
		{
			root.left = insertNode(root.left , value);
			root.left.parent = root;
		}
		else if(root.data < value)
		{
			root.right = insertNode(root.right , value);
			root.right.parent = root;
		}
		
		root.height = max(getheight(root.left) , getheight(root.right)) + 1;
		
		int balance = getBalanceFactor(root);
		
		System.out.println("height = " + root.height);
		System.out.println("balance = " + balance);
		
		System.out.println("hello = " + root.data);
		
		if(balance == 2 && value < root.left.data) // this is LL
			return rotateRight(root);
		
		if(balance == 2 && value > root.left.data) // this is LR
			return rotateLeftThenRight(root);
			
		if(balance == -2 && value > root.right.data) // this is RR
			return rotateLeft(root);
			
		if(balance == -2 && value < root.right.data) // this is RL
			return rotateRightThenLeft(root);
		
		return root;
	}
	
	
	public static Node rotateLeft(Node Z)
	{
		Node Y = Z.right;
		
		if(Z.right != null) {
			Z.right = Y.left;

			if(Y.left != null)
				Y.left.parent = Z;
		}
		
		if(Y.left != null)
			Y.left.parent = Z;
		
		Y.left = Z;
		
		if(Z.parent != null)
			Y.parent = Z.parent;
		else
			Y.parent = null;
		
		Z.parent = Y;
		
		Z.height = max(getheight(Z.left) , getheight(Z.right)) + 1;
		Y.height = max(getheight(Y.left) , getheight(Y.right)) + 1;
	
		return Y;
	}
	
	public static Node rotateLeftThenRight(Node Z){
		Z.left = rotateLeft(Z.left);
		return rotateRight(Z);
	}
	
	public static Node rotateRightThenLeft(Node Z){
		Z.right = rotateRight(Z.right);
		return rotateLeft(Z);
	}
	
	public static Node rotateRight(Node Z)
	{
		
		Node Y = Z.left;
		
		if(Z.left !=  null) {
			Z.left = Y.right;
			if(Y.right != null)
				Y.right.parent = Z;
		}
			
		if(Y.right != null)
			Y.right.parent = Z;
		
		Y.right = Z;
		
		if(Z.parent != null)
			Y.parent = Z.parent;
		else 
			Y.parent = null;
		
		Z.parent = Y;
		
		Z.height = max(getheight(Z.left) , getheight(Z.right)) + 1;
		Y.height = max(getheight(Y.left) , getheight(Y.right)) + 1;
			
		return Y;
	}

	public static int max(int leftnode , int rightnode)
	{
		return (leftnode > rightnode ? leftnode : rightnode);
	}
	
	public static Node searchkey(Node root , int key)
	{
	
		if(root != null)
		{
			if(key == root.data)
				return root;
			else if(key < root.data)
				return searchkey(root.left , key);
			else if(key > root.data)
				return searchkey(root.right , key);
			else 
				return null;
		}		
		return null;
	}
	
	public static int getheight(Node node)
	{
		if(node == null)
			return 0;
		
		return node.height;
	}
	
	
	public static int getBalanceFactor(Node node)
	{
	
		if(node == null)
		return 0;
		
		int heightl = getheight(node.left);
		int heightr = getheight(node.right);
		
		return heightl - heightr;
	}
	
	public static void delete(int key){
		root = deletekey(root , root, key);
	}
	public static Node deletekey(Node root, Node newRoot, int key)
	{
		Node templ = null;
		Node tempr = null;
		if(root == null)
			return null;
		
		if(root.data < key)
		{
			System.out.println("root.right = " + root.right);
			root.right = deletekey(root.right, newRoot, key);
		}
		else if(root.data > key)
		{
			System.out.println("root.left = " + root.left.data);
			root.left = deletekey(root.left ,newRoot , key);
		}
		else
		{
			//the node that has to be deleted is pointed by root now.
			//if node is the leaf node
			if(root.left == null && root.right == null){
				templ = root.parent;
				tempr = root.parent;
				root.parent = null;
				root = null;
				}
			//if node having only 1 child
			else if(root.left == null && root.right != null)
			{
				root.right.parent = root.parent;
				//templ = root.parent;
				tempr = root.parent;
				root = root.right;
			}
			else if(root.right == null && root.left != null)
			{	
				root.left.parent = root.parent;
				templ = root.parent;
				//tempr = root.parent;
				root = root.left;
			}
			//if node having 2 children
			else if(root.right != null && root.left != null)
			{
				// node with two children: Get the inorder successor (smallest
				// in the right subtree)
				root.data = inOrderSucessor(root.right);
				//delete the inorder sucessor
				root.right = deletekey(root.right ,newRoot , root.data);
				//System.out.println(root.right.data);
				if(root.right != null)
					root.right.parent = root.parent;
			}
		}
		
		int balance = 0;
		if(root != null) {
			root.height = max(getheight(root.left) , getheight(root.right)) + 1;
			
			balance = getBalanceFactor(root);
		}
		
		if(balance > 1 && getBalanceFactor(root.left) > 0) // this is LL
			return rotateRight(root);
		
		else if(balance > 1 && getBalanceFactor(root.left) <= 0) // this is LR
			return rotateLeftThenRight(root);
			
		else if(balance < -1 && getBalanceFactor(root.right) <= 0) // this is RR
			return rotateLeft(root);
			
		else if(balance < -1 && getBalanceFactor(root.right) > 0) // this is RL
			return rotateRightThenLeft(root);
		
		return root;
	}

	public static int inOrderSucessor(Node node)
	{
		int small = node.data;
		while(node.left != null)
			{
			small = node.left.data;
			node = node.left;
			}
			return small;
	}
	
	public static void preOrder(Node node)
	{
		 if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}	
	

	public static void inOrder(Node node)
	{
		 if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}	
	
	public static void showParent(int key)
	{
		Node found = searchkey(root , key);
		
		while(found != null)
		{
			System.out.println(found.data + " ");
			found = found.parent;
		}
	}
}

