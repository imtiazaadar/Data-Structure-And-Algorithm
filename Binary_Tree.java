package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Author : Imtiaz Adar
 */
public class Binary_Tree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public Node buildTree(Node root, int data) {
		if(root == null) {
			root = new Node(data);
		}
		if(root.data > data) {
			root.left = buildTree(root.left, data);
		}
		else if(root.data < data) {
			root.right = buildTree(root.right, data);
		}
		return root;
	}
	
	public static int sumOfNodes(Node root) {
		if(root == null) return 0;
		int left = sumOfNodes(root.left);
		int right = sumOfNodes(root.right);
		return left + right + root.data;
	}
	
	public static int heightTree(Node root) {
		if(root == null) return 0;
		int left = heightTree(root.left);
		int right = heightTree(root.right);
		return Math.max(left, right) + 1;
	}
	
	public static int countNodes(Node root) {
		if(root == null) return 0;
		int left = countNodes(root.left);
		System.out.print("LEFT " + left + " ");
		int right = countNodes(root.right);
		System.out.print("RIGHT " + right + " ");
		return left + right + 1;
	}
	
	public static void InOrder(Node root) {
		if(root != null) {
			InOrder(root.left);
			System.out.print(root.data + " ");
			InOrder(root.right);
		}
	}
	
	public static void PreOrder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			InOrder(root.left);
			InOrder(root.right);
		}
	}
	
	public static void PostOrder(Node root) {
		if(root != null) {
			InOrder(root.left);
			InOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public static void levelOrder(Node root) {
		if(root == null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			Node currNode = q.remove();
			if(currNode == null) {
				System.out.println();
				if(q.isEmpty()) {
					break;
				}
				else q.add(null);
			}
			else {
				System.out.print(currNode.data + " ");
				if(currNode.left != null) q.add(currNode.left);
				if(currNode.right != null) q.add(currNode.right);
			}
		}
	}
	
	static class TreeInfo{
		int height, diameter;
		TreeInfo(int height, int diameter){
			this.height = height;
			this.diameter = diameter;
		}
	}
	
	public static TreeInfo Diameter(Node root) {
		if(root == null) return new TreeInfo(0, 0);
		TreeInfo left = Diameter(root.left);
		TreeInfo right = Diameter(root.right);
		int finalheight = Math.max(left.height, right.height) + 1;
		int diam1 = left.diameter;
		int diam2 = right.diameter;
		int diam3 = left.height + right.height;
		int finaldiam = Math.max(Math.max(diam1, diam2), diam3);
		TreeInfo res = new TreeInfo(finalheight, finaldiam);
		return res;
	}
	
	public static boolean isIdentical(Node root1, Node root2) {
		if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;
		return (root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
	}
	
	public static boolean isSubTree(Node root1, Node root2) {
		if(root2 == null) return true;
		if(root1 == null) return false;
		if(isIdentical(root1, root2)) return true;
		return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
	}
	
	public static void main(String[] args) {
		Binary_Tree tree = new Binary_Tree();
		Node root = null;
		root = tree.buildTree(root, 15);
		tree.buildTree(root, 25);
		tree.buildTree(root, 10);
		tree.buildTree(root, 30);
		tree.buildTree(root, 11);
		tree.buildTree(root, 8);
		tree.buildTree(root, 9);
		tree.buildTree(root, 51);
		tree.buildTree(root, 41);
		Node root1 = null;
		root1 = tree.buildTree(root1, 15);
		tree.buildTree(root1, 25);
		tree.buildTree(root1, 10);
		tree.buildTree(root1, 30);
		tree.buildTree(root1, 11);
		tree.buildTree(root1, 8);
		tree.buildTree(root1, 9);
		tree.buildTree(root1, 51);
		tree.buildTree(root1, 41);
		System.out.println("Printing in Inorder");
		InOrder(root);
		System.out.println();
		System.out.println("Printing in Preorder");
		PreOrder(root);
		System.out.println();
		System.out.println("Printing in Postorder");
		PostOrder(root);
		System.out.println();
		System.out.println("\nTotal Nodes : " + countNodes(root));
		System.out.println("Sum Of Nodes : " + sumOfNodes(root));
		System.out.println("Height Of Tree : " + heightTree(root));
		System.out.println("Level Order Of Tree : ");
		levelOrder(root);
		System.out.println("Diameter : " + Diameter(root).diameter);
		if(isSubTree(root, root1)) {
			System.out.println("Tree 2 is the sub tree of tree 1");
		}
		else {
			System.out.println("Tree 2 is not the sub tree of tree 1");
		}
	}
}
