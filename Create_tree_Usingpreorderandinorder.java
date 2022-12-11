package tree.qps;
import java.util.*;

public class Create_tree_Usingpreorderandinorder {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Create_tree_Usingpreorderandinorder m = new Create_tree_Usingpreorderandinorder();
		int[] pre = takeInput();
		int[] in = takeInput();
		BinaryTree bt = m.new BinaryTree(pre, in);
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

		public BinaryTree(int[] pre, int[] in) {
			this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
		}

		private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
			// write your code here
			if(plo>phi || ilo>ihi)
				return null;
			
			Node node = new Node();
			node.data = pre[plo];
			int idx = linearSearch(pre[plo], in, ilo, ihi);				// inorder me iss index pe element mila preorder ka jo root node bnega
			int tnbi = idx-ilo;											// nodes before idx is found
			
			node.left = construct(pre, plo+1, plo+tnbi, in, ilo, idx-1);
			node.right = construct(pre, plo+tnbi+1, phi, in, idx+1, ihi);
			
			
			return node;
		}

		private int linearSearch(int item, int[] in, int ilo, int ihi) {
			// TODO Auto-generated method stub
			for (int i = ilo; i <= ihi; i++) {
				if(item==in[i])								// jha pe woh element mil gya inorder me uska index bhej dege inorder wala
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
