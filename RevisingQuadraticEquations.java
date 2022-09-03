import java.util.Scanner;

public class RevisingQuadraticEquations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		
		int d=0;
		d = (b*b) - (4*a*c);
		
		if(d>0)
		{
			System.out.println("Real and Distinct");
			System.out.print((int)(-b-Math.sqrt(d))/(2*a)+" "+(int)(-b+Math.sqrt(d))/(2*a));
		}
		else if(d<0)
			System.out.println("Imaginary");
		else
		{
			System.out.println("Real and Equal");
			System.out.print((int)(-b-Math.sqrt(d))/(2*a)+" "+(int)(-b+Math.sqrt(d))/(2*a));
		}
	}

}
