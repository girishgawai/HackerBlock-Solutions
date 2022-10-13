package recursion;

import java.util.Scanner;

public class Rat_In_A_Maze {
//	static boolean flag;									// static flag will not work har fun frame me ke karn use krte nhi aaya muze

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		char[][] maze= new char[n][m];

		for (int i = 0; i < maze.length; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				maze[i][j]=str.charAt(j);
			}
		}

		int[][] ans = new int[n][m];

		boolean flag = ratWay(maze,0,0,ans);
		if(flag==false)									// agr ans nhi mila toh -1 print krdo
			System.out.println(-1);
		else											// agr ans mila hai toh display krdo ans wala maze path
				display(ans);
	}


	private static boolean ratWay(char[][] maze, int cr, int cc, int[][] ans) {
		// TODO Auto-generated method stub
		if(cr==maze.length-1 && cc==maze[0].length-1 && maze[cr][cc]!='X')		// last point pe X nhi rha toh and range me rha toh
		{
			ans[cr][cc]=1; 						// bcaz last point pe aane pe hmne update hi nhi kia tha ans ko so ab update krdiya 1 se
//			display(ans);
			return true;	   // ek bar ans milne pe aur extra answers na mile and calls na lge fun ko iske aage se krke true return kia
		}

		if(cc<0 || cr<0 || cc>=maze[0].length || cr>=maze.length || maze[cr][cc]=='X')		// range ke bahr rha OR ya fir X rha toh
			return false;


		maze[cr][cc]='X';
		ans[cr][cc]=1;

		// sirf 2 directions me chal skte hai phle Right (Col+1) then Down (Row+1)
		//		ratWay(maze, cr, cc+1, ans);				// col +1 kia col me aage bdhe in same row
		//		ratWay(maze, cr+1, cc, ans);				// row +1 kia row me aage bdhe in same col				
		int[] c = {1,0};			// row ka array bnaya upr ke statements se
		int[] r = {0,1};			// column ka array bnaya upr ke statements se agr val 1 or 0 rhi toh

		for (int i = 0; i < c.length; i++) {
			boolean flag = ratWay(maze, cr+r[i], cc+c[i], ans);			// flag me store kr rhe hai value ko
			if(flag==true)
				return true;		// agr iss fun call pe return true aaya means ans mil chuka hai.. ab aur calls mnhi lgane fun ko so
		}

		maze[cr][cc]='O';					// back tracking
		ans[cr][cc]=0;						// back tracking
		return false;

	}

	private static void display(int[][] ans) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
