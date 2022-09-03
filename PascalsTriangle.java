import java.util.Scanner;

public class PascalsTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();

		int row=n;
		int star=1;
		int i=0;

		while(i<row)
		{

			int j=0;
			int val=1;
			while(j<star)
			{
				System.out.print(val+"  ");
				val=((i-j)*val)/(j+1);
				j++;
			}


			i++;
			System.out.println();
			star++;
		}
	}

}
