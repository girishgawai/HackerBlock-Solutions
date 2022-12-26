package tree.qps;
import java.util.*;


public class Level_Order_Zigzag_Binary_Tree {

	Scanner sc = new Scanner(System.in);

	public class Node {
		int data;
		Node left;
		Node right;

	}

	private Node root;

	public Level_Order_Zigzag_Binary_Tree() {
		// TODO Auto-generated constructor stub
		this.root = CreateTree();

	}

	private Node CreateTree() {
		// TODO Auto-generated method stub

		int item = sc.nextInt();
		Node nn = new Node();
		nn.data = item;
		boolean hlc = sc.nextBoolean();
		if (hlc == true) {
			nn.left = CreateTree();// left subStree
		}

		boolean hlr = sc.nextBoolean();
		if (hlr == true) {
			nn.right = CreateTree();// right SubStree
		}
		return nn;

	}


	public void levelOrderZZ() {
		// write your code here

		zigzaglevelprint(this.root);
	}

	private void zigzaglevelprint(Node root) {
		// TODO Auto-generated method stub
		Queue<Node> queue = new LinkedList<>();
		Queue<Node> help = new LinkedList<>();

		List<Integer> ansList = new ArrayList<>();
		int level = 1;					// start wid very first level 1
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node removed = queue.remove();
			ansList.add(removed.data);							// contains data of every removed node.. level wise
			// agr removed data ka left right child hoga toh uske childrens ko add kro helper Queue me
			if(removed.left!=null)
				help.add(removed.left);

			if(removed.right!=null)
				help.add(removed.right);

			// agr Queue empty hogyi hai.. toh uss level ka sara data mil gya hai list me ab bss use print kro
			// agr Queue empty nhi hue hai mtlb uss level ka saara data av v collect hone ka hai so continue removing form Queue
			if(queue.isEmpty())
			{
				// Queue is EMpty means time to print the level,, bcaz level ke sare nodes complete ho gye hai
				if(level%2==0)
				{						// agr level odd hai toh right to left level print kro  <--
					Collections.reverse(ansList);
					for (int i = 0; i < ansList.size(); i++) {						
						System.out.print(ansList.get(i) +" ");
					}
				}
				else
				{						// agr level even hai toh left to right level print kro  -->
					for (int i = 0; i < ansList.size(); i++) {						
						System.out.print(ansList.get(i) +" ");
					}
				}

				queue = help;			// ab childern jis queue me the usko Queue point krdega next node k sare elements childs
				help = new LinkedList<>();				// helper ko khali krdiye ab wapis se nye childs sotre krega remove Q ke

				ansList.clear();		// clear the list.. to store new elements of level..  wrna phle ke elements v store hi rhege
				level++;			// level 1 se bdhega.. kyu ki Qeueue khali hogyi mtlb uss level ke sare datas print ho gye
			}
		}

	}


}
