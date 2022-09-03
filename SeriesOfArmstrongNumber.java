import java.util.Scanner;

public class SeriesOfArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stubScanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		checkArmstrong(n1,n2);
	}
	
	public static void checkArmstrong(int n1, int n2)
	{
		while(n1<=n2)
		{
		int n=n1;
		int cod = countOfDigits(n);
		
		int originalData=n;
		int ans = 0;
		int rem=0;
		while(n>0)
		{
			rem=n%10;
			ans=(int) (ans+Math.pow(rem, cod));
			n=n/10;
		}
		if(ans==originalData)
			System.out.println(ans);
		
		n1++;
		}
	}
	
	public static int countOfDigits(int n)
	{
		int count=0;
		while(n>0)
		{
			count++;
			n=n/10;
		}
//		System.out.println(count);
		return count;
	}

}
