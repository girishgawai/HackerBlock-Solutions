package tree.qps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Vertical_Order_Print_Binary_Tree {

	static int levels;			 								// levels in Tree
	
	TreeMap<Integer, ArrayList<Integer> > map = new TreeMap<>();		// storing the data of tree level by level vertically in map using list

	public void printPreorder()
	{		
		printVertical(this.root, levels);		
//		System.out.println(map);
		
		for(int key : map.keySet())
		{
			for(int nbrs : map.get(key))
				System.out.print(nbrs + " ");
		}
	}


	
	private void printVertical(Node root, int d) {		// d will manage the horizontal level on which we are going..
		// TODO Auto-generated method stub									// if going left d-1, right f+1
		if(root==null)
			return;
		
//		System.out.println(root.val + " " + d);					// d --> denotes the vertical level on which it is present
		if(!map.containsKey(d))
		{
			map.put(d, new ArrayList<>());		// agr nyi arraylist nh bnayi toh nullpointer exception dega dalte time.. isliye s=bando default null ajayega		// agr map me key nh hai ye toh bnalo
		}
		// agr hai toh directly add krlo uski value
		map.get(d).add(root.val);							// map me add kr krdiye.. tree ka node ka data vertical level wise
		
		printVertical(root.left, d-1);
		printVertical(root.right, d+1);
	}

	public class Node {
		int val;
		Node left;
		Node right;
	}
	
	private Node root;
	
	public Vertical_Order_Print_Binary_Tree()
	{
		this.root = CreateTree();
	}

	private Node CreateTree() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Node> q = new LinkedList<>();
		
		levels = sc.nextInt();								// levels in Tree
		levels = levels*2;										// double vertical lines bn skte aise assume krke chlege
		
		int item = sc.nextInt();
		Node nn = new Node();
		nn.val = item;
		root = nn;
		
		q.add(nn);
		
		while(!q.isEmpty())
		{
			Node rv = q.poll();				// removed first element in the Queue and storedd address node in rv
			int c1 = sc.nextInt();			// first child --> left
			int c2 = sc.nextInt();			// second child --> right
			
			if(c1!=-1)						// agr phla child exist krta hai toh
			{
				Node node = new Node();
				node.val = c1;
				rv.left=node;
				q.add(node);
			}
			
			if(c2!=-1)						// agr dusra child exist krta hai toh
			{
				Node node = new Node();
				node.val = c2;
				rv.right=node;
				q.add(node);
			}
		}
		
		return root;
	}
	
	public void Display()
	{
		Display(root);
	}

	private void Display(Node nn)
	{
		if(nn==null)								// Base Case
			return;
		
		String s = "<--" + nn.val + "-->";
		if(nn.left!=null)
		{
			s = nn.left.val + s;
		}
		else
		{
			s = "." + s;
		}
		
		if(nn.right!=null)
		{
			s = s + nn.right.val;
		}
		else
		{
			s = s + ".";
		}
		
		System.out.println(s);
		Display(nn.left);
		Display(nn.right);
	}
	
	
	// Input  -  4 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 -1 -1 -1 -1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertical_Order_Print_Binary_Tree LOTB = new Vertical_Order_Print_Binary_Tree();
//		LOTB.Display();
		
		System.out.println();
		LOTB.printPreorder();
	}

}
