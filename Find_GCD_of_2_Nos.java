import java.util.Scanner;

public class Find_GCD_of_2_Nos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        
        int rem=0;
        while(true)
        {
        	rem=n1%n2;
        	if(rem==0)
        	{
        		System.out.println(n2);
        		break;
        	}
        	n1=n2;
        	n2=rem;
        	
        }

	}

}
