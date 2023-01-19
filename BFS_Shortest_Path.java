package graph.qps;
import java.util.*;

public class BFS_Shortest_Path {

	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
	TreeMap<Integer, Integer> ans = new TreeMap<>();					// TreeMap rhne se sare keys sorted order me hi rhegi
	
	public BFS_Shortest_Path(int v)	// kitne nodes/vertexes ka graph bnega
	{
		for(int i = 1; i <= v; i++)
		{
			map.put(i, new HashMap<>());
			ans.put(i, -1);						// to maintain default case.. so pre filling -1 for each node
		}														// 
	}

	public void addEdges(int v1, int v2, int cost)
	{
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}


	public class DijkstraPair {
		int vtx;					// jis vtx pe aye hai
		String vtx_acqr_by_path;							// iss vertex pe jis vertex ke path se aye hai woh
		int cost;						// kitni cost lgi iss vertex tk aane me

		public DijkstraPair(int vtx, String vtx_acqr_by_path, int cost)
		{
			this.vtx = vtx;
			this.vtx_acqr_by_path = vtx_acqr_by_path;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return this.vtx + " --> " + this.vtx_acqr_by_path + " @ " + this.cost;
		}
	}


	public void minCostPath(int src)
	{																// isme sara vtx-vtx pair maintain rhega wid ascending sorted by cost
		PriorityQueue<DijkstraPair> pq = new PriorityQueue<>(new Comparator<DijkstraPair>() {
			@Override
			public int compare(DijkstraPair o1, DijkstraPair o2)
			{
				return o1.cost-o2.cost;									// sorting on the basis of Cost of edges (min cost)
			}
		});		

		HashSet<Integer> visited = new HashSet<>();							// sare visited wale vtx isme mark krege

		DijkstraPair source = new DijkstraPair(src, src+"", 0);		// src vtx - src vtx jane ka path khud src hai and cost 0  for start
		
		pq.add(source);
		
		// Ab whi BFS lgayege har vtx pe jayege jiski cost cum lgegi with traking the acquire path wid min cost
		while(!pq.isEmpty())
		{
			// step 1 remove
			DijkstraPair removed = pq.remove();
			
			// step 2 check if removed data vtx islready removed i.e. marked at visited.. if so it forms cycle then ignore below steps
			if(visited.contains(removed.vtx)) {
				continue;
			}

			// step 3 mark as visited .. removed data/node/vertex ko
			visited.add(removed.vtx);
			if(removed.vtx!=src)			// final ans k liye ek list me store kr rhe hai min costs.. with acquring path sorted label wise
			{
				ans.put(removed.vtx, removed.cost);	// ans ke HashMap me jisko remove kia hai uss key me removed krne tk ki cost rkho
			}

			// step 4 self work.. in our case we are printing the PathAcquire with the minimum sum
//			System.out.println(removed);

			// step 5 Add all the unvisited neighbours of removed vertex
			for(int nbrs : map.get(removed.vtx).keySet())
			{
				if(!visited.contains(nbrs))					// visited nh hoge nbrs toh hi add krege.. wrna visited rhe toh Cycle form krskte
				{
					int costCompleted = removed.cost + map.get(removed.vtx).get(nbrs);
					DijkstraPair adding = new DijkstraPair(nbrs, removed.vtx_acqr_by_path + nbrs, costCompleted);
					pq.add(adding);
				}
			}	
		}

		/******************************** Sorted Minimum Cost of Graph AcquirePath wise ********************************/

		
//		System.out.println(ans);
//		for(int key : ans.keySet())
//		{
//			if(key!=src)
//				System.out.print(ans.get(key) + " ");
//		}
		
		int i = 1;
		while(ans.containsKey(i))
		{
			if(i!=src)										// sirf src se src tk wala nhi print krna tha khudko
				System.out.print(ans.get(i) + " ");
			i++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int vertexes = sc.nextInt();
			int edges = sc.nextInt();
			BFS_Shortest_Path algo = new BFS_Shortest_Path(vertexes);
			for(int i = 1; i <= edges; i++)
			{
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				int cost = sc.nextInt();
				algo.addEdges(v1, v2, cost);
			}
			
			int src = sc.nextInt();
			algo.minCostPath(src);
			System.out.println();
			
			t--;
		}
	}

}
