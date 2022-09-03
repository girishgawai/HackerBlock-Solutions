import java.util.*;

public class InverseOfNumber {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		int i=1;
		int sum=0;
		int rem=0;
		while(n>0)
		{
			rem=n%10;
			int num=i;
			for(int j=1;j<=rem-1;j++)
			{
				num=num*10;
				// System.out.println(num);

			}
			sum=sum+num;
			n=n/10;
			i++;
		}
		System.out.println(sum);

	}
}
