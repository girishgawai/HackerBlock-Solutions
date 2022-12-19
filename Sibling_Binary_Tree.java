package tree.qps;
import java.util.*;


public class Sibling_Binary_Tree {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Sibling_Binary_Tree m = new Sibling_Binary_Tree();
		BinaryTree bt = m.new BinaryTree();
		bt.sibling();

		//			bt.Display();
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
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


		public void sibling() {
			this.sibling(this.root);
		}

		private void sibling(Node node) {
			// write your code here
			if(node==null)
				return;

			if (node.left != null && node.right != null)
			{
				sibling(node.left);
				sibling(node.right);
			}

			// If left child is NULL and right
			// is not, print right child
			// and recur for right child
			else if (node.right != null)
			{
				System.out.print(node.right.data + " ");
				sibling(node.right);
			}

			// If right child is NULL and left
			// is not, print left child
			// and recur for left child
			else if (node.left != null)
			{
				System.out.print( node.left.data + " ");
				sibling(node.left);
			}
		}

	}

}
