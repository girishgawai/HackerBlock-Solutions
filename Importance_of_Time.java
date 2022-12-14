package queue.qps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Importance_of_Time {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] call = new int[n];
		int[] ideal = new int[n];
		for (int i = 0; i < call.length; i++) {
			call[i] = sc.nextInt();
		}
		for (int i = 0; i < ideal.length; i++) {
			ideal[i] = sc.nextInt();
		}
		
		System.out.println(importanceOfTime(call, ideal));

	}

	private static int importanceOfTime(int[] call, int[] ideal) {
		// TODO Auto-generated method stub
		Queue<Integer> CO = new LinkedList<>();
		Queue<Integer> IO = new LinkedList<>();
		
		int time = 0;
		
		for (int i = 0; i < ideal.length; i++) {
			CO.add(call[i]);
			IO.add(ideal[i]);
		}
		
		boolean flag = true;
		int ideals = 0;
		while(!CO.isEmpty())
		{
			int calling = CO.poll();
			if(flag==true)
				ideals = IO.poll();
			if(calling==ideals)
			{
				time++;
				flag = true;
			}
			else
			{
				CO.add(calling);
				time++;
				flag = false;
			}
		}
		
		
		
		return time;
	}
}
