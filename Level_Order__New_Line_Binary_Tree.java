package tree.qps;
import java.util.*;

public class Level_Order__New_Line_Binary_Tree {

		static Scanner scn = new Scanner(System.in);

		public static void main(String[] args) {
			Level_Order__New_Line_Binary_Tree m = new Level_Order__New_Line_Binary_Tree();
			BinaryTree bt = m.new BinaryTree();
			bt.levelOrderNewLine();
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

			public void levelOrderNewLine() {
				// write your code here
				LinkedList<Node> q = new LinkedList<>();
				LinkedList<Node> help = new LinkedList<>();
				q.add(root);
				
				while(!q.isEmpty()) {
					Node itemRemove = q.remove();
					
					System.out.print(itemRemove.data + " ");
					
					if(itemRemove.left!=null)
					{
						help.add(itemRemove.left);
					}
					
					if(itemRemove.right!=null)
					{
						help.add(itemRemove.right);
					}
					
					
					if(q.isEmpty())
					{
						System.out.println();
						q = help;
						help = new LinkedList<>();
					}
				}
				
				
			}

		}

}
