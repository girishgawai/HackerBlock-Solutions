package tree.qps;

import java.util.Scanner;

public class Lowest_Common_Ancestor_Binary_Tree {
	
	private class Node {
		int data;
		Node left;
		Node right;
	}
	
	private Node root;
	
	Scanner sc = new Scanner(System.in);
	
	public Lowest_Common_Ancestor_Binary_Tree()
	{
		this.root = CreateTree();
	}

	private Node CreateTree() {
		// TODO Auto-generated method stub
		Node node = new Node();
		int item = sc.nextInt();
		node.data = item;
		
		boolean hlc = sc.nextBoolean();
		if(hlc==true)
		{
			node.left = CreateTree();
		}
		
		boolean hrc = sc.nextBoolean();
		if(hrc)
		{
			node.right = CreateTree();
		}
		
		
		return node;
	}

	public static void main(String[] args) {
		Lowest_Common_Ancestor_Binary_Tree obj = new Lowest_Common_Ancestor_Binary_Tree();
//		obj.CreateTree();			// already object bnaya hai tb hi create tree me call ua hai constructor se hi
		
		obj.findLowestComAnces(); 
	}

	public void findLowestComAnces() {
		// TODO Auto-generated method stub

		int p = sc.nextInt();
		int q = sc.nextInt();
		Node ans = findLowestComAnces(p,q,root);
//		System.out.println(ans + "  " + ans.data);
		System.out.println(ans.data);
	}
	
	private Node findLowestComAnces(int p, int q, Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return null;
		
		if(root.data==p || root.data==q)
			return root;
		
		Node leftSide = findLowestComAnces(p, q, root.left);
		Node rightSide = findLowestComAnces(p, q, root.right);
		
		if(leftSide!=null && rightSide!=null)					// mtlb rt side me child q mila LEft side me v child p mila hai toh upr ka hi root node lowest ancestor hai
			return root;
		else if(leftSide==null)
			return rightSide;									// mtlb left wala null hai toh rt me hi element hoga
		else
			return leftSide;									// mtlb right wala null hai toh left wale side k adrs me hi element hoga
		
		
	}
}
