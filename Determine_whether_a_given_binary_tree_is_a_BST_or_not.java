package tree.qps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Determine_whether_a_given_binary_tree_is_a_BST_or_not {
	static class BinaryTreeFromLvlOrder {

		private Scanner s = new Scanner(System.in);

		private class Node {
			int val;
			Node left;
			Node right;

			public Node(int val) {
				this.val = val;
			}
		}

		private Node root;

		public BinaryTreeFromLvlOrder() {
			// TODO Auto-generated constructor stub
			root = construct();// 2k
		}

		private Node construct() {
			// TODO Auto-generated method stub

			int val = s.nextInt();
			Node nn = new Node(val);
			Queue<Node> lvl = new LinkedList<>();
			lvl.add(nn);

			while (!lvl.isEmpty()) {
				Node front = lvl.remove();
				int a = s.nextInt();
				int b = s.nextInt();

				if (a != -1) {
					Node na = new Node(a);
					front.left = na;
					lvl.add(na);
				}

				if (b != -1) {
					Node nb = new Node(b);
					front.right = nb;
					lvl.add(nb);
				}
			}
			return nn;// 2k
		}

		private boolean isValid() {
			// TODO Auto-generated method stub


			return checkBST(root).isBST;
		}

		class BSTPari{
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			boolean isBST = true;;
		}

		private BSTPari checkBST(Node root) {
			// TODO Auto-generated method stub
			if(root==null)
				return new BSTPari();

			BSTPari left = checkBST(root.left);
			BSTPari right = checkBST(root.right);

			BSTPari self = new BSTPari();
			self.min = Math.min(root.val, Math.min(left.min, right.min));
			self.max = Math.max(root.val, Math.max(left.max, right.max));

			if(left.isBST==true && right.isBST==true && root.val>left.max && root.val<right.min)
			{
				self.isBST = true;
			}
			else
			{
				self.isBST = false;
			}
			return self;
		}

	}

	public static void main(String[] args) {
		BinaryTreeFromLvlOrder bt = new BinaryTreeFromLvlOrder();
		System.out.println(bt.isValid());
	}
}
