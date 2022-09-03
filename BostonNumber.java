import java.util.Scanner;

//A Boston number is a composite number, the sum of whose digits is the sum of the digits of its prime factors obtained as a result of prime factorization (excluding 1 ). The first few such numbers are 4,22 ,27 ,58 ,85 ,94 and 121 . For example, 378 = 2 × 3 × 3 × 3 × 7 is a Boston number since 3 + 7 + 8 = 2 + 3 + 3 + 3 + 7. Write a program to check whether a given integer is a Boston number.

public class BostonNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int original=n;
		int sum=0,i=2;
		int sample=0;
		
		while(i<=n)
		{
			if(n%i==0)
			{
				sample=i;
				while(sample>0)
				{
					sum=sum+sample%10;
					sample=sample/10;
				}
				int rem=n%i;
//				sum=sum+i;
				n=n/i;
			}
			else
				i++;
		}
//		System.out.println(sum);
		
		int sumOriginal=0;
		while(original>0)
		{
			sumOriginal=sumOriginal+original%10;
			original=original/10;
		}
//		System.out.println(sumOriginal);
		
		if(sum==sumOriginal)
			System.out.println(1);
		else
			System.out.println(0);
	}

}
