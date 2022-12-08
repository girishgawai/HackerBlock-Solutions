//package tree.qps;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class Tree_Left_View {
//	public static void main(String args[]) throws Exception{
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		String[] arr=br.readLine().split(" ");
//		BinaryTree bt=new BinaryTree(arr);
//
//		bt.leftView();
//
//
//
//	public void leftView()
//	{
//		leftView(this.root);
//	}
//
//	class visitedLevel {
//		int depth = -1;
//	}
//
//	private void leftView(Node root) {
//		List<Integer> list = new ArrayList<>();
//		leftsideView(root,0, list, new visitedLevel());
//		for (int i = 0; i < list.size(); i++) {
//			
//			System.out.print(list.get(i)+" ");
//		}
//
//	}
//
//
//	private void leftsideView(Node root, int curLevel, List<Integer> list, visitedLevel d) {
//		// TODO Auto-generated method stub
//		if(root==null || root.data==-1)
//			return;
//		
//		if(curLevel>d.depth)
//		{
//			list.add(root.data);
////			System.out.println(root.data + "==" + d.depth);
//			d.depth = curLevel;
//		}
//		
//		leftsideView(root.left, curLevel+1, list, d);
//		leftsideView(root.right, curLevel+1,list, d );
//	}
//
//
//
//}