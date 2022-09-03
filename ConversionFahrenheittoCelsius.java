import java.util.Scanner;

public class ConversionFahrenheittoCelsius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int f=sc.nextInt();
		int max=sc.nextInt();
		int step=sc.nextInt();
		
		int c=0;
		while(f<=max)
		{
			c = ((5*f)-(5*32))/9;
			System.out.println(f+"\t"+c);
			
			f=f+step;
		}
	}

}
