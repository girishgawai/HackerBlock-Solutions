import java.util.Scanner;

public class DecimalToOcatal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		int sum=0,rem=0;
		int mult=1;
		while(n>0)
		{
			rem=n%8;
			rem=rem*mult;
			sum=sum+rem;
			n=n/8;
			mult=mult*10;
		}
		System.out.println(sum);
		

	}

}
