package hashmap.qps;

import java.util.*;
import java.util.Scanner;

public class Snake_and_Ladders_Board {

	static HashSet<Integer> fallout;		// agr bar bar usi snake se kate jayege toh gol gol cycle chlegi overflow stack
											// isliye ek bar kate jane pe uss snake ko yaad rkhege ab ki bar wapis usse nhi ktwana hai
	
	static HashMap<Integer, Integer> map;	// contains the pair from Point A--B snake mila toh kha se kha utrege & ladder mili toh kha se kha chadhege
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t>0)
		{
			fallout = new HashSet<>();
			map = new HashMap<>();

			int n = sc.nextInt();
			int[] board = new int[n+1];
			int l = sc.nextInt();
			int s = sc.nextInt();

			for (int i = 0; i < l; i++) {
				int l_from = sc.nextInt();
				int l_to = sc.nextInt();

				map.put(l_from, l_to);
			}

			for (int i = 0; i < s; i++) {
				int s_from = sc.nextInt();
				int s_to = sc.nextInt();
				
				map.put(s_from, s_to);
			}

			int min_chances = playWithMinChance(board, 1, 0, 0);		// current step start 1 se krege first cell pe khde rhe kr
			System.out.println(min_chances);
			t--;
		}

	}

	private static int playWithMinChance(int[] board, int steps, int attempts, int dice) {
		// TODO Auto-generated method stub
		
		if(steps>=board.length)
		{
			return Integer.MAX_VALUE;
		}
		
		if(steps==board.length-1)
		{
			return attempts;
		}
		
		if(!fallout.contains(steps) && map.containsKey(steps))	// agr iss step pe sanp or ladder hai toh.. && agr sanp hai toh woh unvisited fallout hai toh
		{
			if(map.get(steps)<steps)							// agr yha saanp tha aur usne kata toh uss saanp ko visited mark krdo
				fallout.add(steps);
			
			steps = map.get(steps);
		}
		
		int minChances = Integer.MAX_VALUE;
		for (int i = 1; i <= 6; i++) 
		{
			if((steps+i)<board.length)
			{
				minChances = Math.min(minChances, playWithMinChance(board, steps+i, attempts+1, i));
			}
		}
		
		return minChances;
	}

}
