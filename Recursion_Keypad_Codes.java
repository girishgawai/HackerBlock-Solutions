package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recursion_Keypad_Codes {

	static String[] key = {"", "abc","def","ghi","jkl","mno","pqrs","tuv","wx", "yz"};
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String digits= sc.next();

		List<String> list = new ArrayList<String>();
		if(digits.length()==0)
			System.out.println(list);

		list = pressKey(digits, "", new ArrayList<String>());
		count = pressKeyCount(digits, "", new ArrayList<String>());

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+"\t");
		}
		System.out.println("\n"+count);
	}

	private static List<String> pressKey(String digits, String ans, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if(digits.length()==0)
		{
			//			System.out.println(ans+"  ");
			list.add(ans);
			return list;
		}

		char num = digits.charAt(0);
		String letters = key[num-'0'];
		//		System.out.println(letters);

		for (int i = 0; i < letters.length(); i++) {
			pressKey(digits.substring(1), ans+letters.charAt(i), list);
		}
		return list;

	}

	private static int pressKeyCount(String digits, String ans, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if(digits.length()==0)
		{
			//			System.out.println(ans+"  ");
			//			list.add(ans);
			return count++;
		}

		char num = digits.charAt(0);
		String letters = key[num-'0'];
		//		System.out.println(letters);

		for (int i = 0; i < letters.length(); i++) {
			pressKeyCount(digits.substring(1), ans+letters.charAt(i), list);
		}
		return count;

	}

}
