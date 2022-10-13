package recursion;

import java.util.Scanner;

public class Rat_Chases_Its_Cheese {
	static boolean flag;

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
		ratWay(maze,0,0,ans);
		
		if(flag==false)
			System.out.println("NO PATH FOUND");
//		display(maze);
	}
	
	
	private static void ratWay(char[][] maze, int cr, int cc, int[][] ans) {
		// TODO Auto-generated method stub
		if(cr==maze.length-1 && cc==maze[0].length-1 && maze[cr][cc]!='X')		// last point pe X nhi rha toh and range me rha toh
		{
			ans[cr][cc]=1; 						// bcaz last point pe aane pe hmne update hi nhi kia tha ans ko so ab update krdiya 1 se
			display(ans);
			
			flag=true;
			return;
		}
		
		if(cc<0 || cr<0 || cc>=maze[0].length || cr>=maze.length || maze[cr][cc]=='X')		// range ke bahr rha OR ya fir X rha toh
			return;
		
		
		maze[cr][cc]='X';
		ans[cr][cc]=1;
		
		ratWay(maze, cr+1, cc, ans);
		ratWay(maze, cr-1, cc, ans);
		ratWay(maze, cr, cc+1, ans);
		ratWay(maze, cr, cc-1,  ans);
		
		maze[cr][cc]='O';					// back tracking
		ans[cr][cc]=0;						// back tracking
		
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
