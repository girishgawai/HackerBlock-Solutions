package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recursion_Codes_of_the_string {

	static String arr[] = {"-", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u"
			, "v", "w", "x", "y", "z"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
//		System.out.println(arr);
//		formLetter(str,"","",0);
		
		List<String> list = new ArrayList<>();
		list = formLetter(str,"","",0, new ArrayList<>());
		
		System.out.println(list);

	}

//	private static void formLetter(String str, String path, String ans, int i) {
//		// TODO Auto-generated method stub
//		if(ans.length()==str.length())						// if(i>=str.length() || ans.length()==str.length())
//		{
////			System.out.println(ans);
//			System.out.println(path);
//			return;
//		}
//		
//		
//		formLetter(str, path+arr[Integer.parseInt(str.charAt(i)+"")], ans+str.charAt(i), i+1);
//		
//		if((i+2)<=str.length())
//			formLetter(str, path+arr[Integer.parseInt(str.substring(i,i+2))], ans+str.substring(i,i+2), i+2);
//		
//	}
	
	
	private static ArrayList<String> formLetter(String str, String path, String ans, int i, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if(ans.length()==str.length())						// if(i>=str.length() || ans.length()==str.length())
		{
//			System.out.println(ans);
//			System.out.println(path);
			
			list.add(path);
			return list;
		}
		
		
		formLetter(str, path+arr[Integer.parseInt(str.charAt(i)+"")], ans+str.charAt(i), i+1, list);
													// (out of bound arr[index] se)	//	a=1 to z=26 itna hi double string ka charcater value bnega
		if((i+2)<=str.length() && Integer.parseInt(str.substring(i, i+2))<=26)	// if double string 26 se upr ki bni for eg 27,28..
			formLetter(str, path+arr[Integer.parseInt(str.substring(i,i+2))], ans+str.substring(i,i+2), i+2, list);	// toh uska charcter nhi bnta ..
		
		return list;
	}

}
