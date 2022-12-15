package queue.qps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hoodies_At_Coding_Blocks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int o = sc.nextInt();

		Queue<Integer> c1 = new LinkedList<>();
		Queue<Integer> c2 = new LinkedList<>();
		Queue<Integer> c3 = new LinkedList<>();
		Queue<Integer> c4 = new LinkedList<>();

		Queue<Integer> whoStandsFirst = new LinkedList<>();

		while(o!=0)
		{
			String operation = sc.next();
			if(operation.equals("E"))
			{
				int course = sc.nextInt();
				if(!whoStandsFirst.contains(course))
					whoStandsFirst.add(course);

				int roll = sc.nextInt();
				if(course==1)
					c1.add(roll);
				else if(course==2)
					c2.add(roll);
				else if(course==3)
					c3.add(roll);
				else
					c4.add(roll);
			}

			if(operation.equals("D"))
			{
				int startOfQ = whoStandsFirst.peek();
				if(!c1.isEmpty() && startOfQ==1)
				{
					System.out.println(1 + " " + c1.remove());
					if(c1.isEmpty())
						whoStandsFirst.poll();
				}
				else if(!c2.isEmpty() && startOfQ==2)
				{
					System.out.println(2 + " " + c2.remove());
					if(c2.isEmpty())
						whoStandsFirst.poll();
				}
				else if(!c3.isEmpty() && startOfQ==3)
				{
					System.out.println(3 + " " + c3.remove());
					if(c3.isEmpty())
						whoStandsFirst.poll();
				}
				else
				{
					System.out.println(4 + " " + c4.remove());
					if(c4.isEmpty())
						whoStandsFirst.poll();
				}
			}




			o--;
		}



	}

}
