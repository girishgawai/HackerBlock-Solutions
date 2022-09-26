package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Maze_path_Count_Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m = sc.nextInt();
		int[][]arr = new int[n][m];

		ArrayList<String>list = printMaze(arr,0,0,n-1,m-1,"", new ArrayList<>());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+"\t");
		}
		System.out.println();
		System.out.println(countPath(arr, 0, 0, n-1, m-1, ""));
	}

	private static ArrayList<String> printMaze(int[][] arr, int cr, int cc, int er, int ec, String path, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if(cr==er && cc==ec)
		{
//			System.out.print(path+"\t");
			list.add(path);
			return list;
		}
		
		if(cr>er || cc>ec)
			return list;
		
		printMaze(arr, cr+1, cc, er, ec, path+"V", list);
		printMaze(arr, cr, cc+1, er, ec, path+"H", list);
		
		return list;
	}
	
	private static int countPath(int[][] arr, int cr, int cc, int er, int ec, String path) {
		// TODO Auto-generated method stub
		if(cr==er && cc==ec)
		{
//			System.out.print(path+"\t");
			return 1;
		}
		
		if(cr>er || cc>ec)
			return 0;
		
		int n = countPath(arr, cr+1, cc, er, ec, path+"V");
		int m = countPath(arr, cr, cc+1, er, ec, path+"H");
		
		return n+m;
	}

}
