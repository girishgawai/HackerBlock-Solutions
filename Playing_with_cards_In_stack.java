package stack_problems;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Playing_with_cards_In_stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();									// no of elemetns in the array
		int q = sc.nextInt();									// no of iterations
		Stack<Integer> cards = new Stack<>();

		for (int i = 0; i < n; i++) {
			cards.push(sc.nextInt());
		}

		gameOnn(cards,q);
	}

	private static void gameOnn(Stack cards, int q) {
		// TODO Auto-generated method stub
		Stack<Integer> A = new Stack<>();							// all prime nos
		Stack<Integer> B = new Stack<>();							// non prime nos

		ArrayList<Integer> list = new ArrayList<>();						// consists of all prime nos till 10^5 = 100000
		primeNos(list);
		
		for(int i=1; i<=q; i++)
		{
			int prime = list.get(i-1);
			while(!cards.isEmpty())
			{
				int item = (int) cards.pop();
				
				if(item%prime==0)
					B.push(item);
				else
					A.push(item);
			}
			
			while(!B.isEmpty())
				System.out.println(B.pop());
			
			cards = A;
			A = new Stack<>();
		}
		
		while(!cards.isEmpty())
			System.out.println(cards.pop());
	}

	private static void primeNos(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		// Prime Sieve Algorithm
		boolean[] prime = new boolean[100001];
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 2; i*i <= 100000; i++) {
			if(prime[i]==false)
			{
				list.add(i);
				for (int mult = 2; mult*i <= 100000; mult++) {
					prime[mult*i] = true;
				}
			}
		}
		
		for(int i = 2; i<=100000; i++)
		{
			if(!prime[i])
				list.add(i);
		}
	}
}
