package arrays_2D;

import java.util.Scanner;

public class Piyush_and_Magical_Park {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();			//matrix ax
		int n = sc.nextInt();			//matrix b
		int k = sc.nextInt();			// atleast tni strength rhni ch chahiye
		int s = sc.nextInt();			///initial strength
		char[][] arr = new char[m][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=sc.next().charAt(0);
			}
		}
		goToPark(arr,k,s);
	}

	private static void goToPark(char[][] arr, int k, int s) {
		// TODO Auto-generated method stub
		for (int i = 0; s>k && i < arr.length; i++) {
			for (int j = 0; s>k &&j < arr[i].length; j++) {
				if(arr[i][j]=='.')
					s-=2;
				else if(arr[i][j]=='*')
					s+=5;
				else								//if =='#'
					break;
				
				if(j!=arr[i].length-1)
					s--;
			}
		}
		if(s>k)
		{
			System.out.println("Yes");
			System.out.println(s);
		}
		else
			System.out.println("No");
	}

}
