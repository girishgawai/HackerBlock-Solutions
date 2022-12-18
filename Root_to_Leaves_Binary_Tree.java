package tree.qps;

import java.util.LinkedList;
import java.util.Scanner;

public class Root_to_Leaves_Binary_Tree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;							// start of Tree --> there will be only ONE Root node in entire tree
	Scanner sc = new Scanner(System.in);

	public Root_to_Leaves_Binary_Tree()
	{
		this.root = CreateTree();
	}

	private Node CreateTree() {
		// TODO Auto-generated method stub
		int item = sc.nextInt();
		Node n = new Node();
		n.data = item;

		boolean hlc = sc.nextBoolean();				// has left cycle?
		if(hlc==true)
			n.left = CreateTree();

		boolean hrc = sc.nextBoolean();				// has left cycle?
		if(hrc==true)
			n.right = CreateTree();

		return n;
	}

	public void Display()
	{
		Display(root);
	}

	private void Display(Node nn)
	{
		if(nn==null)								// Base Case
			return;
		
		String s = "<--" + nn.data + "-->";
		if(nn.left!=null)
		{
			s = nn.left.data + s;
		}
		else
		{
			s = "." + s;
		}
		
		if(nn.right!=null)
		{
			s = s + nn.right.data;
		}
		else
		{
			s = s + ".";
		}
		
		System.out.println(s);
		Display(nn.left);
		Display(nn.right);
	}
	
	public static void main(String[] args) {
		Root_to_Leaves_Binary_Tree obj = new Root_to_Leaves_Binary_Tree();
		
		
		obj.findSumPathEqualsTo();
	}

	/* With Static Vairable
	
	private void findSumPathEqualsTo() {
		// TODO Auto-generated method stub
		int k = sc.nextInt();
		findSumPathEqualsTo(root, k);
	}

	static LinkedList<Node> list = new LinkedList<>();
	private void findSumPathEqualsTo(Node root, int sum) {
		// TODO Auto-generated method stub
		if(sum==0 && root==null)
		{
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).data + " ");
			}
			list.clear();
			return;
		}
		
		if(root==null)
			return;
		
		list.add(root);
		findSumPathEqualsTo(root.left, sum-root.data);
		findSumPathEqualsTo(root.right, sum-root.data);
	}

	*/
	
	// Without Static Variable
	private void findSumPathEqualsTo() {
		// TODO Auto-generated method stub
		int k = sc.nextInt();
		LinkedList<Node> list = new LinkedList<>();
		findSumPathEqualsTo(root, k, list);
	}

	
	private void findSumPathEqualsTo(Node root, int sum, LinkedList<Node> list) {
		// TODO Auto-generated method stub
		if(sum==0 && root==null)
		{
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).data + " ");
			}
			list.clear();											// list clear kia hai kyu ki next time v calls chlte rhte toh list me xtra ka unwanted data add hota.. sare node
			return;
		}
		
		if(root==null)
			return;
		
		list.add(root);
		findSumPathEqualsTo(root.left, sum-root.data, list);
		findSumPathEqualsTo(root.right, sum-root.data, list);
	}


}
