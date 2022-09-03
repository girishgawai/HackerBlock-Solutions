import java.util.Scanner;

public class FindLowercase_Uppercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);			// this will scan only one letter-scan string but 
														// put only a single letter
		
		if(ch>='a' && ch<='z')
			System.out.println("lowercase");
		else if(ch>='A' && ch<='Z')
			System.out.println("UPPERCASE");
		else
			System.out.println("Invalid");
	}

}
