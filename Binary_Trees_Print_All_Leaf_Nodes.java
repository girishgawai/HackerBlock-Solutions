package tree.qps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Binary_Trees_Print_All_Leaf_Nodes {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public Binary_Trees_Print_All_Leaf_Nodes()
	{
		this.root = CreateTree();
	}




	private Node CreateTree() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int item = sc.nextInt();						// first Node value- Root ki val
		Node node = new Node();
		node.data = item;

		this.root = node;								// root me tree ke frst node ka adrs daal dia.. root set ho gya
		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while(!q.isEmpty())
		{
			Node removed = q.poll();

			int c1 = sc.nextInt();
			int c2 = sc.nextInt();

			if(c1!=-1) {
				Node lc = new Node();
				lc.data = c1;
				removed.left = lc;
				q.add(lc);
			}

			if(c2!=-1) {
				Node rc = new Node();
				rc.data = c2;
				removed.right = rc;
				q.add(rc);
			}
		}

		return root;
	}

//	public void display()
//	{
//		Display(root);
//	}
//
//
//	private void Display(Node root) {
//		// TODO Auto-generated method stub
//		if(root==null)
//			return;
//		
//		System.out.println(root.data);
//		Display(root.left);
//		Display(root.right);
//	}

	// Display only Leaf Node Data
	public void displayleafNodeDAta()
	{
		PrintLeafNode(root);
	}


	private void PrintLeafNode(Node root) {
		// TODO Auto-generated method stub
		if(root.left==null && root.right==null)
		{
			System.out.print(root.data + " ");
			return;
		}
		
		PrintLeafNode(root.left);
		PrintLeafNode(root.right);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Trees_Print_All_Leaf_Nodes obj = new Binary_Trees_Print_All_Leaf_Nodes();
		obj.displayleafNodeDAta();
	}

}
