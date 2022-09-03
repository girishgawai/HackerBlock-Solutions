package arrays_optimized.codes;
import java.util.Scanner;

public class Kth_Root_Optimized_BinarySearchAlgo {
	public static void main(String[] args) {
		//   TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong();
		while(t>0)
		{
			long n = sc.nextLong();                         // bcaz n i/p is bigger
			long k = sc.nextLong();
			long x = find_Kth_RootOfWhat(n,k);
			System.out.println(x);
			t--;
		}
	}
	private static long find_Kth_RootOfWhat(long n, long k) {
		// TODO Auto-generated method stub
		long high=n, low=0,mid=0;
		while(low<=high)
		{
			mid=(high+low)/2;
			if(Math.pow(mid, k)==n)
				return mid;
			if(Math.pow(mid, k)>n)
				high=mid-1;
			else					//mid<n
				low=mid+1;
		}
		return high;

	}
}