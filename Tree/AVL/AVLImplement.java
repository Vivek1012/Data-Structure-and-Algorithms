import java.util.*;

class Node
{	
	Node left;
	Node right;
	Node parent;
	int data , height;
	int countNode ;
	int sum;
	int min;
	int max;
	int mingap;
	
	public Node()
	{
		left = right = null;
		parent = null;
		height = 1;
		countNode = 1;
		data = 0;
		sum = 0;
		mingap = -1;
	}

	public Node(int item)
	{
		left = right = null;
		data = item;
		height = 1;
		countNode = 1;
		sum = item;
		min = item;
		max = item;
		mingap = -1;
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
			System.out.println("Press 5 to show the node count of AVL : ");
			System.out.println("Press 6 to find Rank of item :");
			System.out.println("Press 7 to find the item given a Rank : ");
			System.out.println("Press 8 to find the number of nodes between x and y :");
			System.out.println("press 9 to show the Sum of nodes : ");
			System.out.println("Press 10 to find the PrefixSum of Node : ");
			System.out.println("Press 11 to find the sum of nodes between x and y : ");
			System.out.println("Press 12 to show the min of all the nodes in AVL : ");
			System.out.println("Press 13 to find min of a node : ");
			System.out.println("Press 14 to show the max of all the nodes in AVL : ");
			System.out.println("Press 15 to find min of a node : ");
			System.out.println("Press 16 to print the parents : ");
			System.out.println("Press 17 to show inOrder : ");
			System.out.println("Press 18 to show minGap of all the nodes : ");
			System.out.println("Press 19 to find the minGap of a tree : ");
			System.out.println("Press 20 to find the maxGap of all the nodes : ");
			System.out.println("Press 21 to find the maxGap of a tree : ");
			System.out.println("Press 22 to find the minGap between x and y : ");
			System.out.println("Press 23 to find the maxGap between x and y : ");
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

					case 5 : System.out.println("The Node of each node is : ");
							 showCount(root);
							 break;
							 
					case 6 : System.out.println("Enter the item value to find the rank : ");
							 int rank = findRank(root , s.nextInt() , 1);
							 System.out.println("The Rank of Given Key is : " + rank);
							 break;
					
					case 7 : System.out.println("Enter the rank between 1 to " + root.countNode + " to find Element : ");
							 int givenRank = s.nextInt();
							 int eleRank = getItemfromRank(root , givenRank , 0);
							 System.out.println("The Element for the Rank " + givenRank + " is " + eleRank);
							 break;
							
					case 8 : System.out.println("Enter the Node X : ");
							 int x = s.nextInt();
							 System.out.println("Enter the Node Y : ");
							 int y = s.nextInt();
							 System.out.println("Number of Nodes Between " + x + " and " + y + " are " + (findRank(root , x , 1) - findRank(root , y , 1) + 1));
							 break;
					
					case 9 : System.out.println("The SUM of each node is : ");
							 showSum(root);
							 break;
					 
					case 10 : System.out.println("Enter the Node value to find the PrefixSum : ");
							 int key = s.nextInt();
							 int presum = prefixSum(root , key , 0);
							 System.out.println("The prefuxSum of node " + key + " is " + presum);
							 break;
							
					case 11 : System.out.println("Enter the Node X : ");
							 int a = s.nextInt();
							 System.out.println("Enter the Node Y : ");
							 int b = s.nextInt();
							 System.out.println("Number of Nodes Between " + a + " and " + b + " are " + (prefixSum(root , b , 0) - prefixSum(root , a , 0) + a ));
							 break;
							 
					case 12 : System.out.println("The Min of each node is : ");
							  showMin(root);
							  break;
					
					case 14 : System.out.println("The Min of each node is : ");
							 showMax(root);
							 break;
			 
					case 16 : System.out.println("Enter the node to find all the parents : ");
							  System.out.println("The Parent's of the node are : ");
							  showParent(s.nextInt());
							  break;
							
					case 17 : System.out.println("The inorder traversal of tree : ");
							  inOrder(root);
							  break;
					
					case 18 : System.out.println("The minGaps of all the nodes is ");
							  showMingap(root);
							  break;
							  
					case 19 : System.out.println("The minGap of tree is ");
					  		  System.out.println(root.mingap);
					  		  break;

					case 20 : System.out.println("The maxGaps of all the nodes is ");
							  showMaxgap(root);
							  break;
							  
					case 21 : System.out.println("The maxGap of Tree : ");
							  System.out.println(root.max - root.min);
							  break;
							  
					case 22 : System.out.println("Enter the Value of x : ");
							  int xmin = s.nextInt();
							  
							  System.out.println("Enter the Value of y : ");
							  int ymin = s.nextInt();
							  
							  System.out.println("The minGap between x and y : " + minGapbetweenXandY(xmin , ymin));
							  break;
							  

					case 23 : System.out.println("Enter the Value of x : ");
							  int xmax = s.nextInt();
							  
							  System.out.println("Enter the Value of y : ");
							  int ymax = s.nextInt();
							  
							  System.out.println("The maxGap between x and y : " + maxGapbetweenXandY(xmax , ymax, root));
							  break;
					
					case 24 : System.out.println("Enter the Value of x : ");
							  int xleft = s.nextInt();
							  
							  System.out.println("Enter the Value of y : ");
							  int yright = s.nextInt();
							  
							  System.out.println("The closest Common Ansistor between x and y : ");
							  Node getAnsistor = CommonAncestorforXandY(xleft , yright, root); 
							  System.out.println(getAnsistor.data);
							  break;
							  
					  
					case 0 : break;
				}
		}while(option != 0);				
		
		System.out.println("Enter the item to insert in BST");		
	}
	
	private static Node CommonAncestorforXandY(int x, int y , Node node) 
	{
		if(x > node.data && y > node.data)
		{
			return CommonAncestorforXandY(x, y , node.right);
		}
		else if(x < node.data && y < node.data)
		{
			return CommonAncestorforXandY(x, y , node.left);
		}
		return node;
	}
	
	
	private static int maxGapbetweenXandY(int xmax, int ymax , Node node) {
		
		//search left node, if not present return it's parent
		Node root = node;
		int left = xmax, right = ymax; 
		
		while(node != null)
		{
			if(xmax == node.data)
			{
				left = node.data;
				break;
			}
			else if(xmax < node.data)
			{
			if((node.left != null) && (node.left.data > xmax))
				node = node.left;
			else
			{
				left = node.data;
				break;
			}
			}
			else if(xmax > node.data)
			{
				if((node.right != null) && (node.right.data > xmax))
					node = node.right;
				else 
				{
					left = node.data;
					break;
				}
			}
		}
		System.out.println("left = " + left);
		node = root;
		
		while(node != null)
		{
			if(ymax == node.data) {
				right = node.data;
				break;
			}
			else if(ymax < node.data)
			{
			if((node.left != null) && (node.left.data > ymax))
				node = node.left;
			else
			{
				right = node.left.data;
				break;
			}
			}
			else if(ymax > node.data)
			{
				if((node.right != null) && (node.right.data < ymax))
					node = node.right;
				else 
				{
					right = node.right.data;
					break;
				}
			}
		}
		
		System.out.println("right = " + right);
		return right - left;
	}

	private static String minGapbetweenXandY(int xmin, int ymin) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void setMinimum(Node root , int minimum , int delnode) 
	{
		while(root.parent != null)
		{
			if(root.parent.min == delnode)
			{	
				root.parent.min = root.min;
				
			}
		
			else if(root.parent.min > root.min && root.parent.data > root.data)
				root.parent.min = root.min;
			
			root = root.parent;
			
		}
		
		if(root.parent == null && root.min >= root.left.min)
			root.min = root.left.min;
	}
	
	public static void setMaximum(Node root , int maximum , int delnode)
	{
		while(root.parent != null)
		{
			if(root.parent.max == delnode)
			{	
				root.parent.max = root.max;
			}
		
			else if(root.parent.max < root.max && root.parent.data < root.data)
				root.parent.max = root.max;
			
			root = root.parent;
			
		}
		
		if(root.parent == null && root.max <= root.right.max)
			root.max = root.right.max;
		
	}
	
	public static void insert(int item)
	{
		root = insertNode(root , item);
		Node found = searchkey(root , item);
		setMingap(found);
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
			if(root.min > root.left.min)
			{
				root.min = root.left.min;
			}
		}
		else if(root.data < value)
		{
			root.right = insertNode(root.right , value);
			root.right.parent = root;
			if(root.max < root.right.max)
			{
				root.max = root.right.max;
			}
		}
		
		root.height = max(getheight(root.left) , getheight(root.right)) + 1;
		root.countNode = getCount(root.left) + getCount(root.right) + 1;
		root.sum = getSum(root.left) + getSum(root.right) + root.data;
		
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
	
	public static void setMingap(Node node)
	{
		if((node.left == null && node.right == null) && (node.parent != null))
			{
			node.mingap = -1;
			if(node != null) {
					setMingap(node.parent);
				}
			}
		
		else if(node != null)
		{
		int min = 23452;
		int mymin[] = {-1, -1, -1, -1};
		
		if(node.left != null)
			mymin[0] = node.left.mingap;
		
		if(node.right != null)
			mymin[1] = node.right.mingap;
		
		if(node.left != null)
			mymin[2] = node.data - node.left.max;
		
		if(node.right != null)
			mymin[3] = node.right.min - node.data;
		
		for(int i = 0 ; i < 4 ; i++)
		{
				if(min >= mymin[i] && mymin[i] != -1)
					min = mymin[i]; 
		}
		
		node.mingap = min;

		if(node.parent != null)
			setMingap(node.parent);
		}
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
		
		Z.countNode = getCount(Z.left) + getCount(Z.right) + 1;
		Y.countNode = getCount(Y.left) + getCount(Y.right) + 1;
		
		Z.sum = getSum(Z.left) + getSum(Z.right) + Z.data;
		Y.sum = getSum(Y.left) + getSum(Y.right) + Y.data;
		
		
			if(Z.left != null)
				Z.min = getMin(Z.left);
			else 
				Z.min = Z.data;
		
			if(Z.right != null)
				Z.max = getMax(Z.right);
			else
				Z.max = Z.data;
			
	
			if(Y.left != null)
				Y.min = getMin(Y.left);
			else 
				Y.min = Y.data;
			
			if(Y.right != null)
				Y.max = getMax(Y.right);
			else
				Y.max = Y.data;
		
			setMingap(Z);
			setMingap(Y);
		
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
		
		Z.countNode = getCount(Z.left) + getCount(Z.right) + 1;
		Y.countNode = getCount(Y.left) + getCount(Y.right) + 1;
		
		Z.sum = getSum(Z.left) + getSum(Z.right) + Z.data;
		Y.sum = getSum(Y.left) + getSum(Y.right) + Y.data;
		
		
			if(Z.left != null)
				Z.min = getMin(Z.left);
			else 
				Z.min = Z.data;
		
			if(Z.right != null)
				Z.max = getMax(Z.right);
			else
				Z.max = Z.data;
			
			
			if(Y.left != null)
				Y.min = getMin(Y.left);
			else 
				Y.min = Y.data;
			
			if(Y.right != null)
				Y.max = getMax(Y.right);
			else
				Y.max = Y.data;
		
			setMingap(Z);
			setMingap(Y);
			
		return Y;
	}
	
	public static int getSum(Node node)
	{

		if(node == null)
			return 0;
			
		return node.sum;	
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
	
	public static int getCount(Node node)
	{
		if(node == null)
			return 0;
			
		return node.countNode;
	}
	
	public static int getMin(Node node)
	{
		if(node == null)
			return 0;
		
		return node.min;
	}
	
	public static int getMax(Node node)
	{
		if(node == null)
			return 0;
		
		return node.max;
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
			
			root.countNode = getCount(root.left) + getCount(root.right) + 1;
			
			root.sum = getSum(root.left) + getSum(root.right) + root.data;
				
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
		
		if(templ != null) {
			//System.out.println("temp = " + temp.data);
			templ.min = templ.data;
			setMinimum(templ , templ.data , key);
			setMingap(templ);
		}
		
		if(tempr != null)
		{
			tempr.max = tempr.data;
			setMaximum(tempr , tempr.data , key);
			setMingap(tempr);
		}
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
	
	public static void showCount(Node node)
	{
		 if (node != null) {
				System.out.print(node.countNode + " ");
				showCount(node.left);
				showCount(node.right);
			}
	}
	
	public static void showMin(Node node)
	{
		if(node != null)
		{
			System.out.print(node.min + " ");
			showMin(node.left);
			showMin(node.right);
		}
	}
	
	public static void showMax(Node node)
	{
		if(node != null)
		{
			System.out.print(node.max + " ");
			showMax(node.left);
			showMax(node.right);
		}
	}
	public static void showSum(Node node)
	{
		 if (node != null) {
				System.out.print(node.sum + " ");
				showSum(node.left);
				showSum(node.right);
			}
	}
	
	public static void showMingap(Node node)
	{
		 if (node != null) {
				System.out.print(node.mingap + " ");
				showMingap(node.left);
				showMingap(node.right);
			}
	}

	public static void showMaxgap(Node node)
	{
		 if (node != null) {
				System.out.print((node.max - node.min) + " ");
				showMaxgap(node.left);
				showMaxgap(node.right);
			}
	}

	
	public static int findRank(Node node , int key , int rank)
	{
		
		int temp = 0;
		if(node == null)
			return 0;
		
		else if(node.data == key) {
			if(node.right != null)
			{
				temp = getCount(node.right);
			}
			else 
				temp = 0;
			
			rank = temp + rank;
			
			return rank;
		}
		else if(node.data < key) {
			rank = findRank(node.right , key , rank);
		}
		else if(node.data > key)
		{
			if(node.right != null)
				temp = getCount(node.right) + 1;
			else 
				temp = 0;
			
			rank = rank + temp;
			rank= findRank(node.left , key , rank);
		}
		return rank;
	}
	
	public static int getItemfromRank(Node node , int rank , int temp)
	{
		
		int getitem = 0;
		if(node == null)
			return 0;
		
		else if((temp + getCount(node.right) + 1) == rank)
			getitem = node.data;
		
		else if(((temp + getCount(node.right) + 1) > rank))
		{
			if(node.right != null)
				getitem = getItemfromRank(node.right , rank , temp);
		}
		
		else if((temp + getCount(node.right) + 1) < rank)
		{
			if(node.right != null)
				temp = node.right.countNode + temp + 1;
			else
				temp = 0;
			if(node.left !=  null)
				getitem = getItemfromRank(node.left , rank , temp);
		}
		return getitem;
	}
	
	public static int prefixSum(Node node , int key , int presum)
	{
		
		int temp = 0;
		if(node == null)
			return 0;
		else if(node.data == key)
		{
			if(node.left != null)
				temp = getSum(node.left);
			else 
				temp = 0;
			
			return (temp + presum + node.data);
		}
		
		else if(node.data < key)
		{
			if(node.left != null)
				temp = getSum(node.left);
			else 
				temp = 0;
			
			presum = presum + temp + node.data;
			presum = prefixSum(node.right , key , presum);
		}
		else if(node.data > key)
		{
			presum = prefixSum(node.left , key , presum);
		}
		
		return presum;
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
