import java.util.Scanner;

public class OddEvenBackInDelhi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		while(input>0)
		{
			int n=sc.nextInt();

			int rem=0,even=0,odd=0;
			while(n>0)
			{
				rem=n%10;
				if(rem%2==0)
					even=even+rem;
				else
					odd=odd+rem;

				n=n/10;
//							System.out.println(odd+"   "+even);
			}
			if(even%4==0 || odd%3==0)
				System.out.println("Yes");
			else
				System.out.println("No");
			
			input--;
		}
	}

}
