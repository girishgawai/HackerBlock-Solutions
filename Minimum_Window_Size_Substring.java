package strings_optimized_codes;

import java.util.Scanner;

public class Minimum_Window_Size_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String searchIn=sc.next();				// jisme search krna hai
		String searchThis=sc.next();			// jisko search krna hai

		String ans = findMinWindowOfSubString(searchIn,searchThis);
		System.out.println(ans);
	}

	private static String findMinWindowOfSubString(String searchIn, String searchThis) {
		// TODO Auto-generated method stub
		int[] searchFor = new int[256];							// sare ascii values unn letters ki jo searchThis me hai
		int[] searchInside = new int[256];							// sare ascii values unn letters ki jo searchIn me hai

		// ab jisko dhundege uska uss characters ka count (total occurrence 1 or jitna bari reapt hai utna ho gya hai array me iss)
		for (int i = 0; i < searchThis.length(); i++) {
			char ch=searchThis.charAt(i);							// jisko srch krna hai usme ke har character ko store kre 'ch' me
			searchFor[ch]++;										// sare ascii values pe inn letters ki addition val =1 kri hai			
		}

		int start=0;
		int minSizeWindow = Integer.MAX_VALUE;
		int startIndex=-1;								// agr empty string di toh blank return krayege
		int count=0;									// yeh count rkhega jitne leeter milne chahiye ans me

		for(int end=0; end<searchIn.length(); end++)
		{
			char ch = searchIn.charAt(end);				// jisme dhundhna hai uski uske har char ko ch me store kira
			searchInside[ch]++;							// uss char ki ascii val pe jakr array me +1 krte gye jitne bari woh char mila

			if(searchInside[ch]<=searchFor[ch])			// jitne bar woh chars hai utne bar mile ya usse kum bar mile toh count bdhao
			{
				count++;			
			}

			if(count==searchThis.length())				// itna count hai utna mil gya mtlb string mili toh
			{
				// agr jisko check hi nhi krna searchFor] me woh 0 hai toh chlte rhne ke liye
				while(searchInside[searchIn.charAt(start)]>searchFor[searchIn.charAt(start)] || searchFor[searchIn.charAt(start)]==0)
				{
					// jisko srch krna hai uska uss char ka occurence kum rha aur jisme dhundna tha usme woh jaada bar mila char toh
					if(searchInside[searchIn.charAt(start)]>searchFor[searchIn.charAt(start)])	// srch[] me srch ke uss element k char
					{										// pe uski ascii val pe count-1 krege agr, jaada bari mil gya hoga char toh
						searchInside[searchIn.charAt(start)]--;
					}
					start++;
				}

				// agr cunt mil gya jitne char dhundne the min widnow me utne toh min widnow ki size ko save krlo
				if(minSizeWindow>end-start+1)		// agr jo sbse chotiu window ki size hai jisme string ans mili woh bdi rhi toh
				{											// nyi wali choti window ko store krdege purani se replace krke
					minSizeWindow=end-start+1;		// eg. end=5 start=2 toh iski widnow ani chaiye diff 3 but+1 kia toh window sze 4
					startIndex=start;				// stor krke rkhega starting index ko sbse choti winow ke
				}

			}

		}

		if(startIndex==-1)
			return "";							// min size window milti hi nhi toh kuch nhi return krte.. empty string input rhti toh

		return searchIn.substring(startIndex, startIndex+minSizeWindow);			// jo min window thi usko return krdiya substring method se

	}

}
