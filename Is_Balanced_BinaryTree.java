package tree.qps;

import java.util.*;
public class Is_Balanced_BinaryTree {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Is_Balanced_BinaryTree m = new Is_Balanced_BinaryTree();
		BinaryTree bt = m.new BinaryTree();
		System.out.println(bt.isBalanced());
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

		public boolean isBalanced() {
			return this.isBalanced(this.root).isBalanced;
		}

		private BalancedPair isBalanced(Node node) {
			// write your code here
			if(node==null)
				return new BalancedPair();
			
			BalancedPair leftBalncTree = isBalanced(node.left);
			BalancedPair rightBalncTree = isBalanced(node.right);
			
			BalancedPair self = new BalancedPair();
			self.height = Math.max(node.data, Math.max(leftBalncTree.height, rightBalncTree.height));
			
			if(leftBalncTree.isBalanced==true && rightBalncTree.isBalanced==true && Math.abs(treeHeight(node.left) - treeHeight(node.right))<=1)
			{
				self.isBalanced = true;
			}
			else
				{
					self.isBalanced = false;
//					self.height = Math.max(node.data, Math.max(leftBalncTree.height, rightBalncTree.height));
				}

			return self;
		}

		private int treeHeight(Node nn) {
			// TODO Auto-generated method stub
			if(nn==null)
				return -1;
			
			int left = treeHeight(nn.left);
			int right = treeHeight(nn.right);
			
			
			return Math.max(left, right)+1;
		}

		private class BalancedPair {
			int height = -1;
			boolean isBalanced = true;
		}

	}
}
