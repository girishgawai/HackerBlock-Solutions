package arrays_problems;

import java.util.Scanner;

public class Murthal_Parantha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int p=sc.nextInt();
		int c=sc.nextInt();
		int[] time = new int[c];
		for (int i = 0; i < time.length; i++) {
			time[i]=sc.nextInt();
		}
		int maxTime = calculateTime(time,p);
		System.out.println(maxTime);
	}

	private static int calculateTime(int[] time, int p) {
		// TODO Auto-generated method stub
		int[] timeTemp=new int[time.length];					// timings of cooks for each individual paratha
		int[] visitor= new int[time.length];				// visitor count.. uss particular cooks ko frst time visit kiya hai kv ya nhi
		for (int i = 0; i < timeTemp.length; i++) {
			timeTemp[i]=time[i];							// particular cook ke timings ko initial timings pe laya hai
			visitor[i]=0;									// visitor count sab jgah initially Zero hai
		}
		int j=0,maxTime=0;									// j--> index hold krega jis cook ko paratha bnana hai uska

		int[]cooksTimings = new int[time.length];			// initial timings saare cooks ke Zero rhege
		int count=0;										// number of parathas made till now
		while(count<p)
		{
			//			int i=0;
			for (int i = 0; i < time.length; i++) 
			{
				if((visitor[j]==0))						// agr cook ne ek v paratha nhi bnaya av tk ke.. ek v bar visited nhi hai toh
				{
					if(visitor[i]>0)					// jis cooks ko order dene ka soch rhe phle v bnaye hai paratha toh.. visited
					{
						if((cooksTimings[j]+time[j]>(time[i]+timeTemp[i]+cooksTimings[i])) && i!=j)
							{
								j=i;
							}
					}
					else						// jis cooks ko order dene ka soch rhe usne ek v bar bnaya nhi ho paratha toh.. unvisited
					{
						if(((cooksTimings[j]+time[j])>(time[i]+cooksTimings[i])) && i!=j)
							j=i;
					}
					
				}
				else									// agr cook ne parathw bnaye honge toh.. visited hai already
				{
					if(visitor[i]>0)			// jis cooks ko order dene ka soch rhe usne ek v bar bnaya nhi ho paratha toh.. unvisited
					{
						if((time[i]+timeTemp[i]+cooksTimings[i]) < (time[j]+timeTemp[j]+cooksTimings[j])) 
							j=i;
					}
					else						// jis cooks ko order dene ka soch rhe usne ek v bar bnaya nhi ho paratha toh.. unvisited
					{
						if(((time[j]+timeTemp[j]+cooksTimings[j])>time[i]+cooksTimings[i]) && i!=j)
							j=i;
					}

				}
			}

			count++;
			if(visitor[j]>0)
				time[j]=time[j]+timeTemp[j];
			
			cooksTimings[j]=cooksTimings[j]+time[j];			// totals time kitna lga uss particular cook ko ab tk ke parathe bnane me
			visitor[j]++;										// ye cook itne bari visit ho chuka hai
			
//			System.out.println(time[j]+"=="+"time["+j+"]"+"===visited["+j+"] = "+visitor[j]+" parathas+ --> "+count);
//			System.out.println("===+=======   ");
		}

		for (int i = 0; i < time.length; i++) {
			maxTime=Math.max(maxTime, cooksTimings[i]);
//			System.out.print("Cooks Timings "+ cooksTimings[i]+"  ");
//									System.out.println(time[i]+"==");
		}
		return maxTime;
	}

}
