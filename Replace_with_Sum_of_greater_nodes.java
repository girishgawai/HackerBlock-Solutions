package tree.qps;

import java.util.Scanner;

public class Replace_with_Sum_of_greater_nodes {
	private class Node {
		int val;
		Node left;
		Node right;
	}
	
	private Node root;
	private Node root_ans;
	
	public Replace_with_Sum_of_greater_nodes(int[] in)
	{
		this.root = Create_Tree(in,0,in.length-1);
	}

	private Node Create_Tree(int[] in, int si, int ei) {
		// TODO Auto-generated method stub
		if(si>ei)
			return null;
		
		
		int mid = (si+ei)/2;
		Node nn = new Node();
		nn.val = in[mid];
		
		nn.left = Create_Tree(in, si, mid-1);
		nn.right = Create_Tree(in, mid+1, ei);
		
		
		return nn;
	}
	
	public void display()
	{
		Display(this.root);		
		System.out.println();
	}
	
	public void displayans()
	{
		Display(this.root_ans);		
		System.out.println();
	}

	private void Display(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null)
			return;
		
		String str = "<--"+nn.val+"-->";
		if(nn.left!=null)
			str = nn.left.val+str;
		else
			str = "."+str;
		if(nn.right!=null)
			str= str+nn.right.val;
		else
			str = str+".";
		
		System.out.println(str);
		
		Display(nn.left);
		Display(nn.right);		
	}
	
	public int max()
	{
		return maximum(root);
	}
	
	
	private int maximum(Node nn) {
		// TODO Auto-generated method stub
		if(nn==null)
			return Integer.MIN_VALUE;
		
		int right = maximum(nn.right);
		return Math.max(right, nn.val);
	}
	
	static int sum = 0;
	public void makeInnOrderUpdatation()
	{
		root_ans = makeInnOrderUpdatation(root);
	}

	private Node makeInnOrderUpdatation(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return null;
		
//		System.out.println(root.val);
		Node nn = new Node();
		nn.left = makeInnOrderUpdatation(root.left);
		nn.val = sum;
//		System.out.println(sum);
		sum = sum - root.val;
		nn.right = makeInnOrderUpdatation(root.right);
		
		return nn;
	}

	public static void main(String[] args) {
//		int[] in = { 20, 30, 40, 50, 60, 70, 80};
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++)
		{
			in[i]=sc.nextInt();
			sum = sum + in[i];
		}
		Replace_with_Sum_of_greater_nodes bst = new Replace_with_Sum_of_greater_nodes(in);
//		bst.display();
		bst.makeInnOrderUpdatation();
//		System.out.println();
		bst.printPreOrder();

	}

	private void printPreOrder() {
		// TODO Auto-generated method stub
		printPreOrder(this.root_ans);
	}

	private void printPreOrder(Node root_ans2) {
		// TODO Auto-generated method stub
		if(root_ans2==null)
			return;
		
		System.out.print(root_ans2.val + " ");
		printPreOrder(root_ans2.left);
		printPreOrder(root_ans2.right);
	}
	

}
