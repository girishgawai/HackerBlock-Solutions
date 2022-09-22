package recursion;

import java.util.Scanner;

public class Boardpath__Count_Print_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max=sc.nextInt();						// size of board
		int n=sc.nextInt();							// number of faces on dice
		
		diceThrowCShowFaces(0, max, "", n);
		
		System.out.println();
		int sum = diceThrowCalculateTotalFaces(0, max, "", n);
		System.out.println(sum);
	}

	// to show the faces
	private static void diceThrowCShowFaces(int curr, int max, String ans, int totalDice) {
		// TODO Auto-generated method stub
		if(curr==max)
		{
			System.out.print(ans+"\t");
			return;
		}
		
		if(curr>max)
			return;
		
		for (int dice = 1; dice <= totalDice; dice++) {
			diceThrowCShowFaces(curr+dice, max, ans+dice, totalDice);
		}
	}
	
	//to calculate thesum if faces sum==4
	private static int diceThrowCalculateTotalFaces(int curr, int max, String ans, int totalDice) {
		// TODO Auto-generated method stub
		if(curr==max)
		{
//			System.out.println(ans);
			return 1;
		}
		
		if(curr>max)
			return 0;
		
		int count=0;								// it will store the count (where the faces sum will be == 4(max)
														// this will store the count value for all diff-diff stacks frames and add it
		for (int dice = 1; dice <= totalDice; dice++) {
			count= count + diceThrowCalculateTotalFaces(curr+dice, max, ans+dice, totalDice);
		}
		
		return count;
	}

}
