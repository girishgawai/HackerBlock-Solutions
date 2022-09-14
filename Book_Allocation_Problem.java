package arrays_optimized;

import java.util.Arrays;
import java.util.Scanner;

public class Book_Allocation_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int noB=sc.nextInt();
			int noS=sc.nextInt();
			
			int[] books = new int[noB];					// books containing certain amouynt of pages
			for (int i = 0; i < books.length; i++) {
				books[i]=sc.nextInt();
			}
			
			maximumBooksToReadMinStudents(books,noB,noS);
			t--;
		}

	}

	private static void maximumBooksToReadMinStudents(int[] books, int noB, int noS) {
		// TODO Auto-generated method stub
		int low=0;
		int high=0;
		// Jaada se jada kitne pages pdhlege?? saare ke ssare toh whi count krke high me dalege
		for (int i = 0; i < books.length; i++) {
			high+=books[i];
		}
//		System.out.println(high);
		
//		int ans=Integer.MAX_VALUE;			// keeps the track of maxm pages can be read by students 	
		int ans=0;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(doTheyRead(mid, books, noS)==true)
			{
//				System.out.println(mid+"=="+ans);
//				ans= Math.min(ans, mid);
				ans=mid;						// jitne jitne pages max read kr skte usko store kia
				high=mid-1;
			}
			else
			{
//				System.out.println("hi");
			low=mid+1;
			}
			
		}
		
		System.out.println(ans);
	}

	private static boolean doTheyRead(int max, int[] books, int noS) {
		// TODO Auto-generated method stub
		int student=1;
		int readed=0;
		
		for (int i = 0; i < books.length; ) 
		{
			if(readed+books[i]>max)
			{
				student++;
				readed=0;
			}
			else
			{
				readed=readed+books[i];
				i++;
			}
//			System.out.println(student+"=="+readed+"==="+max);
			if(student>noS)
			{
//				System.out.println(student+"==="+noS);
				return false;
			}
			
		}
		
		
		
		return true;
	}

}
