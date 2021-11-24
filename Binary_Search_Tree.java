package DataStructure;
/*
 * Imtiaz Adar
 * Binary Search Tree
 */
public class Binary_Search_Tree {
	class BST{
		int data;
		BST left, right;
	}
	
	BST NEWNODE(int data) {
		BST temp = new BST();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}
	
	BST Insert(BST root, int data) {
		if(root == null) {
			root = NEWNODE(data);
		}
		if(data < root.data) {
			root.left = Insert(root.left, data);
		}
		else if(data > root.data) {
			root.right = Insert(root.right, data);
		}
		return root;
	}
	
	BST Find_Min(BST root) {
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	BST Find_Max(BST root) {
		while(root.right != null) {
			root = root.right;
		}
		return root;
	}

	void Inorder(BST root) {
		if(root != null) {
			Inorder(root.left);
			System.out.print("--> " + root.data);
			Inorder(root.right);
		}
	}
	
	void Preorder(BST root) {
		if(root != null) {
			Preorder(root.left);
			Preorder(root.right);
			System.out.print("--> " + root.data);
		}
	}
	
	void Postorder(BST root) {
		if(root != null) {
			System.out.print("--> " + root.data);
			Postorder(root.left);
			Postorder(root.right);
		}
	}
	
	BST Search(BST root, int data) {
		if(root == null)
			return null;
		else if(data < root.data) {
			return Search(root.left, data);
		}
		else if(data > root.data) {
			return Search(root.right, data);
		}
		return root;
	}
	
	BST Remove(BST root, int data) {
		if(root == null)
			return null;
		else if(data < root.data) {
			root.left = Remove(root.left, data);
		}
		else if(data > root.data) {
			root.right = Remove(root.right, data);
		}
		else {
			if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			BST temp = Find_Min(root.right);
			root.data = temp.data;
			root.right = Remove(root.right, root.data);
		}
		return root;
	}
	
	void Find(BST root, int num) {
		if(Search(root, num) != null) {
			System.out.println(num + " FOUND");
		}
		else {
			System.out.println(num + " NOT FOUND");
		}
	}
	
	public static void main(String[] args) throws NullPointerException{
		Binary_Search_Tree tree = new Binary_Search_Tree();
		BST node = null;
		String inorder = "## INORDER ##\n";
		String preorder = "## PREORDER ##\n";
		String postorder = "## POSTORDER ##\n";
		node = tree.Insert(node, 15);
		tree.Insert(node, 24);
		tree.Insert(node, 12);
		tree.Insert(node, 33);
		tree.Insert(node, 46);
		System.out.println(inorder);
		tree.Inorder(node);
		System.out.println("\n");
		System.out.println(preorder);
		tree.Preorder(node);
		System.out.println("\n");
		System.out.println(postorder);
		tree.Postorder(node);
		System.out.println("\n");
		tree.Remove(node, 33);
		System.out.println(inorder);
		tree.Inorder(node);
		System.out.println("\n");
		tree.Find(node, 12);
	}
}
