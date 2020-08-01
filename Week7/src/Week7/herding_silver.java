//Leeland Zhang
//Took me 2 hours
//10/12
//Don't really know wut is wrong with last two cases
//To actually think of the algorithm took me one hour though, the next hour
//was kind of wasted
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class herding_silver 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("herding.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("herding.out"));
		int N=sc.nextInt();
		long[] farm=new long[N];
		for(int i=0; i<N; i++)
		{
			farm[i]=sc.nextLong();
		}
		sc.close();
		Arrays.sort(farm);
		long gaps=0; //all gaps
		long min=1000000000;
		long gap=0;//temperary gap
		long spots=1;
		for(int i=1; i<N; i++)
		{
			spots+=farm[i]-farm[i-1];
			gap+=farm[i]-farm[i-1]-1;
			if(spots>=N)
			{
				gaps+=gap;
				if(spots>N)
				{
					spots-=farm[i]-farm[i-1];
					gap+=N-spots;
					gap-=farm[i]-farm[i-1]-1;
				}
				if(gap<min)
					min=gap;
				gap=0;
				spots=1;
			}
		}
		gaps-=Math.min(farm[1]-farm[0]-1, farm[N-1]-farm[N-2]-1);
		if(min==1&&farm[1]-farm[0]==1&&farm[N-1]-farm[N-2]!=1)
			pr.println(gaps);
		else
			pr.println(min);
		pr.println(gaps);
		pr.close();
	}
}
