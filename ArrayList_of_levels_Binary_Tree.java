package tree.qps;
import java.util.*;

public class ArrayList_of_levels_Binary_Tree {

		static Scanner scn = new Scanner(System.in);

		public static void main(String[] args) {
			ArrayList_of_levels_Binary_Tree m = new ArrayList_of_levels_Binary_Tree();
			BinaryTree bt1 = m.new BinaryTree();
			System.out.println(bt1.levelArrayList());
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

			public ArrayList<ArrayList<Integer>> levelArrayList() {
				// write your code here
				HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();		// store rkhega level by level ke nodes usi level me
				printLevelByLevel(this.root, 1, map);
				
				ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
				for(int key : map.keySet())
				{
					ansList.add(map.get(key));				// uss keyset ki main key level wali usme ka list ko add krdiya 2D List me
				}
				
				return ansList;
			}

			// PreOrder traverse krke add krege map me current level ki key pe value node ki list me
			private void printLevelByLevel(Node root, int currLevel, HashMap<Integer, ArrayList<Integer>> map) {
				// TODO Auto-generated method stub
				if(root==null)
					return;
				
				if(!map.containsKey(currLevel))				// agr map me yeh key present nh hai toh bnao
				{
					map.put(currLevel, new ArrayList<>());
				}
				
				// agr map me already key exists krti hai toh iss key me value add krdo list me node ka data/value
				map.get(currLevel).add(root.data);						// iss key ki value wali adrs ki list me value add krdi node ki
				
				printLevelByLevel(root.left, currLevel+1, map);
				printLevelByLevel(root.right, currLevel+1, map);
			}

		}



}
