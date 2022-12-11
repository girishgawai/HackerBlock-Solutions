package tree.qps;
import java.util.*;

public class Create_Tree_Using_Postorder_and_Inorder {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Create_Tree_Using_Postorder_and_Inorder m = new Create_Tree_Using_Postorder_and_Inorder();
		int[] post = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(post, in);
		bt.display();
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree(int[] post, int[] in) {
			this.root = this.construct(post, 0, post.length - 1, in, 0, in.length - 1);
		}

		private Node construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {
			// write your code here
			if(ilo>ihi || plo>phi)
				return null;
			
			Node nn = new Node();
			nn.data = post[phi];
			int idx = linearSearch(post[phi], in, ilo, ihi);			// inorder[] me jis index pe item mila
			int tnbp = idx-ilo;
			
			
			nn.left = construct(post, plo, plo+tnbp-1, in, ilo, idx-1);
			nn.right = construct(post, plo+tnbp, phi-1, in, idx+1, ihi);
			
//			node.left = construct(post, plo, plo - ilo + idx - 1, in, ilo, idx - 1);
//			node.right = construct(post, phi - ihi + idx, phi - 1, in, idx + 1, ihi);
			
			return nn;
		}

		private int linearSearch(int item, int[] in, int ilo, int ihi) {
			// TODO Auto-generated method stub
			for (int i = ilo; i <= ihi; i++) {
				if(item==in[i])
					return i;
			}
			
			return 0;
		}

		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
			if (node == null) {
				return;
			}

			String str = "";

			if (node.left != null) {
				str += node.left.data;
			} else {
				str += "END";
			}

			str += " => " + node.data + " <= ";

			if (node.right != null) {
				str += node.right.data;
			} else {
				str += "END";
			}

			System.out.println(str);

			this.display(node.left);
			this.display(node.right);
		}

	}


}
