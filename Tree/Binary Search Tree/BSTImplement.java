import java.util.*;

class Node {
	Node left;
	Node right;
	int data;

	public Node() {
		left = right = null;
		data = 0;
	}

	public Node(int item) {
		left = right = null;
		data = item;
	}

}

public class BSTImplement {

	public static Node root = null;

	public static void main(String args[]) {
		System.out.println("hello");
		Scanner s = new Scanner(System.in);

		int option = 0;

		do {
			System.out.println("Press 1 to insert !");
			System.out.println("Press 2 to Delete !");
			System.out.println("Press 3 to Search the node !");
			System.out.println("Press 4 to show the Preorder traversal of BST !");
			System.out.println("Press 5 to show the Level Order Traversal of BST !");
			System.out.println("Press 6 to find the height of BST !");
			System.out.println("Press 0 to Exit !");

			option = s.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter the Key to Insert !");
				insert(s.nextInt());
				break;

			case 2:
				System.out.println("Enter the Key to delete the element :");
				delete(s.nextInt());
				System.out.println("After deletion the PreOrder Traversal of BST is :");
				preOrder(root);
				break;

			case 3:
				System.out.println("Enter the Key to Search : ");
				Node found = searchkey(root, s.nextInt());

				if (found != null)
					System.out.println("The given key is Present in BST !");
				else
					System.out.println("The Given key is not Present in BST !");

				break;

			case 4:
				System.out.println("The PreOrder Traversal of BST : ");
				preOrder(root);
				break;

			case 5:
				System.out.println("The LevelOrder Traversal of BST : ");
				levelOrder(root);
				break;
			
			case 6:
				System.out.println("The Height of give tree is : " + treeHeight(root));
				break;
				
			case 0:
				break;
			}
		} while (option != 0);

		System.out.println("Enter the item to insert in BST");
	}

	public static void insert(int item) {
		root = insertNode(root, item);
	}

	public static Node insertNode(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			System.out.println("node = " + root.data);
			return root;
		} else if (root.data > value) {
			root.left = insertNode(root.left, value);
		} else if (root.data < value) {
			root.right = insertNode(root.right, value);
		}

		return root;
	}

	public static Node searchkey(Node root, int key) {
		if (root != null) {
			if (key == root.data)
				return root;
			else if (key < root.data)
				return searchkey(root.left, key);
			else if (key > root.data)
				return searchkey(root.right, key);
			else
				return null;
		}
		return null;
	}

	public static void delete(int key) {
		root = deletekey(root, key);
	}

	public static Node deletekey(Node root, int key) {
		if (root == null)
			return null;

		if (root.data < key) {
			root.right = deletekey(root.right, key);
		} else if (root.data > key) {
			root.left = deletekey(root.left, key);
		} else {
			// the node that has to be deleted is pointed by root now.
			// if node is the leaf node
			System.out.println("node del = " + root.data);
			System.out.println("node left = " + root.left);
			System.out.println("node right = " + root.right);
			if (root.left == null && root.right == null)
				return null;
			// if node having only 1 child
			else if (root.left == null && root.right != null)
				return root.right;
			else if (root.right == null && root.left != null)
				return root.left;
			// if node having 2 children
			else if (root.right != null && root.left != null) {
				// node with two children: Get the inorder successor (smallest
				// in the right subtree)
				root.data = inOrderSucessor(root.right);
				// delete the inorder sucessor
				root.right = deletekey(root.right, root.data);
			}
		}
		return root;
	}

	public static int inOrderSucessor(Node node) {
		int small = node.data;
		while (node.left != null) {
			small = node.left.data;
			node = node.left;
		}
		return small;
	}

	public static void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public static int treeHeight(Node node)
	{		
		int lnode = 0;
		int rnode = 0;
		
		if(node != null)
		{
			lnode = 1 + treeHeight(node.left);
			rnode = 1 + treeHeight(node.right);
		}
		
		return (lnode > rnode ? lnode : rnode);
		
	}
	
	public static void levelOrder(Node node) {
		Queue<Node> q = new LinkedList<>();
		Node removedele = null;

		if (node != null) {
			if (root == node) {
				q.add(node);
			}

			while (!q.isEmpty()) {
				removedele = q.remove();
				System.out.println(removedele.data);
				if (removedele != null) {
					if (removedele.left != null)
						q.add(removedele.left);

					if (removedele.right != null)
						q.add(removedele.right);
				}
			}
		}
	}
}
