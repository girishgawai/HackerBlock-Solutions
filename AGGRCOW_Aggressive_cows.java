import java.util.Arrays;
import java.util.Scanner;

public class AGGRCOW_Aggressive_cows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int noD=sc.nextInt();
			int noC=sc.nextInt();
			
			int[] dist = new int[noD];
			for (int i = 0; i < dist.length; i++) {
				dist[i]=sc.nextInt();
			}
			Arrays.sort(dist);
			
			countMaximumMinDistance(dist,noD,noC);
			t--;
		}

	}

	private static void countMaximumMinDistance(int[] dist, int noD, int noC) {
		// TODO Auto-generated method stub
		int high=dist[dist.length-1]-dist[0];		//last se first wale ko minus kia toh bche hue bichme ke distance line pe hi dhundege
		int low=0;
		int ans=0;						// holds the last updated and the final ans (maximum min dist bet cows
		
		while(low<=high)
		{
			int mid = (high+low)/2;
			if(doCowsFit(noC,mid,dist)==true)		// agr cows sma ja rhe hoge unte distance line ke part me nsare toh true ayega wrna false
			{
				ans=mid;
				low=mid+1;
			}
			else									// agr cow nhi smarhe uss dictn me toh
			{
				high=mid-1;
			}
		}
		
		System.out.println(ans);
	}

	private static boolean doCowsFit(int noC, int mid, int[] dist) {
		// TODO Auto-generated method stub
		int cow=1;						// phli cow rkh di hai phle stall pe
		int pos=0;						// phli cow toh rkhna start krege starting ke stall se hi
		
		for(int i=pos+1;i<dist.length;i++)
		{
			if(dist[i]-dist[pos]>=mid)		// agr cow ajarhi uss stall usi distc me ya uske undr
			{
				cow++;						// oh cow ki val bdhegi ek se.. next cow store kri usme
				pos=i;
			}
			
			if(noC==cow)				// agr no of cow match ho gye cows bdhte bdhte toh true bhej
				return true;			// means sare cows end ho gye itne minimum distance me
		}
		
		
		return false;			// agr yha tk code aya mtlb distnc end hua nd cow baki hai toh false
	}

}
