package tree.qps;
import java.util.*;
import java.io.*;

public class Tree_Right_View {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] arr=br.readLine().split(" ");
		BinaryTree bt=new BinaryTree(arr);

		bt.rightView();

	}
}

class BinaryTree
{
	private class Node
	{
		int data;
		Node left,right;
		Node(int data)
		{
			this.data=data;
		}
	}

	Node root;

	BinaryTree(String[] arr)
	{
		Queue<Node> queue=new LinkedList<Node>();
		construct(arr,0,queue);
	}

	public void rightView()
	{
		rightView(this.root);
	}

//	class visitedLevel {
//		int depth = 0;
//	}
	static int d = -1;
	private void rightView(Node root) {
//		display_tree(root);
		List<Integer> list = new ArrayList<>();
		rightsideView(root,0, list);
		for (int i = 0; i < list.size(); i++) {
			
			System.out.print(list.get(i)+" ");
		}
	}


	private void rightsideView(Node root, int curLevel, List<Integer> list) {
		// TODO Auto-generated method stub
		if(root==null || root.data==-1)
			return;
		
		if(curLevel>d)
		{
			list.add(root.data);
//			System.out.println(root.data + "==" + d.depth);
			d = curLevel;
		}
		
		rightsideView(root.right, curLevel+1,list);
		rightsideView(root.left, curLevel+1, list);
	}

	private void construct(String[] arr,int ind,Queue<Node> queue)
	{
		if(ind>=arr.length)
			return;
		if(queue.size()==0)
		{
			Node nn=new Node(Integer.parseInt(arr[ind]));
			this.root=nn;
			queue.add(nn);
		}
		else
		{
			Node parent=queue.peek();
			if(parent.data!=-1){
				if(parent.left==null)
				{
					parent.left=new Node(Integer.parseInt(arr[ind]));
					queue.add(parent.left);
				}
				else
				{
					if(parent.right==null)
					{
						parent.right=new Node(Integer.parseInt(arr[ind]));
						queue.add(parent.right);
						queue.poll();
					}
				}
			}
			else
			{
				queue.poll();
				ind--;
			}
		}
		construct(arr,ind+1,queue);
	}

	public void display()
	{
		display_tree(this.root);
	}

	private void display_tree(Node root)
	{
		if(root==null)
			return;
		String str=root.data+"";
		if(root.left!=null)
		{
			str=root.left.data+" <= "+str;
		}
		else
		{
			str="END <= "+str;
		}

		if(root.right!=null)
		{
			str=str+" => "+root.right.data;
		}
		else
		{
			str=str+" => END";
		}
		System.out.println(str);
		display_tree(root.left);
		display_tree(root.right);

	}


}