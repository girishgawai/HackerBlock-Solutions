package priority_queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sort_Game {
	
	static class Stud_Data {
		String name;
		int marks;
		
		public Stud_Data(String name, int marks)
		{
			this.name = name;
			this.marks = marks;
		}
		
		@Override
		public String toString()
		{
			return name + " " + marks;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		
		int n = sc.nextInt();
		Stud_Data[] arr = new Stud_Data[n];
		
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			int marks = sc.nextInt();

			
			Stud_Data obj = new Stud_Data(name, marks);
			arr[i] = obj;
		}

		Arrays.sort(arr, new Comparator<Stud_Data>() {

			@Override
			public int compare(Stud_Data o1, Stud_Data o2) {
				// TODO Auto-generated method stub
				if(o1.marks==o2.marks)
					return o1.name.compareTo(o2.name);
				
				return o2.marks-o1.marks;
			}
		});
		
		for (Stud_Data stud_Data : arr) {
			
			if(stud_Data.marks<max)
				continue;
			
			System.out.println(stud_Data);
		}
	}

}
