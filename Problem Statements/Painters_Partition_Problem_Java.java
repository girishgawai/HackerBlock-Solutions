package arrays_problems;

import java.util.Scanner;

public class Painters_Partition_Problem_Java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noP=sc.nextInt();					// num of painters
		int noB=sc.nextInt();					// num of boards
		int[] boards= new int[noB];
		for (int i = 0; i < boards.length; i++) {
			boards[i]=sc.nextInt();
		}
		
		minTimeToPaint(boards,noP);
	}

	private static void minTimeToPaint(int[] boards, int noP) {
		// TODO Auto-generated method stub
		int low=0;
		int high=0;
		for (int i = 0; i < boards.length; i++) {
			high+=boards[i];
		}
		
		int ans = Integer.MAX_VALUE;
		while(low<=high)
		{
			int mid = (low+high)/2;
			if(canTheyPaint(boards,mid,noP)==true)
			{
				ans = Math.min(ans, mid);
				high=mid-1;
			}
			else
				low=mid+1;
		}
		
		System.out.println(ans);
	}

	private static boolean canTheyPaint(int[] boards, int mid, int noP) {
		// TODO Auto-generated method stub
		int painter=1;
		int paintedBoard=0;
		
		for (int i = 0; i < boards.length; ) {
			if(paintedBoard+boards[i]>mid)
			{
				painter++;
				paintedBoard=0;
			}
			else
			{
				paintedBoard+=boards[i];
				i++;
			}
			
			if(painter>noP)
				return false;
			
		}
		
		return true;
	}

}
