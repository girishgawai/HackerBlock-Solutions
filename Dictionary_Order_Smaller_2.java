package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Dictionary_Order_Smaller_2 {

	public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str.length()==1)
        {
            System.out.println(str);
        }
        else
        {
            ArrayList<String> list = allWordsSmaller(str,"",str.charAt(0), new ArrayList<String>());
            Collections.sort(list);
            //      System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
            	if(list.get(i).equals(str))
            		break;
                System.out.println(list.get(i));
            }
        }
    }
    // to prevent this and not to have repeated ans strings if the character is repeated uin questiong string
    private static ArrayList<String> allWordsSmaller(String que, String ans, char firstChar, ArrayList<String> list) {
        // TODO Auto-generated method stub
        if(que.length()==0)
        {
//            if(ans.charAt(0)<firstChar)		// input cCA--> has to give cAC its valid but this line will not create this which is wrong
//            {
                //              System.out.println(ans+"\t");
                list.add(ans);
                return list;
//            }
        }
        boolean[] visited = new boolean[256];                               /// 26 size because all total small letters
        for (int i = 0; i < que.length(); i++)
        {
            char ch = que.charAt(i);
            if(visited[ch-0]==false)
            {
                visited[ch-0]=true;
                String s1 = que.substring(0,i);
                String s2 = que.substring(i+1);
                allWordsSmaller(s1+s2, ans+ch, firstChar, list);
            }
        }
        return list;
    }
}