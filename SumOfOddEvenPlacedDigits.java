import java.util.Scanner;

public class SumOfOddEvenPlacedDigits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int o=0;
		int e=0;
		int counter=0;
		
		while(n>0)
		{
			if(counter%2==0)
			{
				e=e+(n%10);
			}
			if(counter%2==1)
			{
				o=o+(n%10);
			}
			n=n/10;
			counter++;
		}
		
		System.out.println(e);
		System.out.println(o);
		
		
	}

}
