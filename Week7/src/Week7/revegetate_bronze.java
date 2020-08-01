//Leeland Zhang
//Took me 45 minutes to write the code, took me 1 hour and a half to debug
//when all I did was accidentally wrote i++ instead of j++.
//Got 10/10 in the end and I feel so stupid and wasted to much time
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class revegetate_bronze 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("revegetate.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("revegetate.out"));
		int N=sc.nextInt();
		int M=sc.nextInt();
		ArrayList<ArrayList<Integer>> fields=new ArrayList<ArrayList<Integer>>(N);
		for(int i=0; i<M; i++)
		{
			fields.add(new ArrayList<Integer>());
		}
		for(int i=0; i<M; i++)
		{
			int x=sc.nextInt()-1;
			int y=sc.nextInt()-1;
			fields.get(x).add(y);
			fields.get(y).add(x);
		}
		sc.close();
		int[] ans=new int[N];
		for(int i=0; i<N; i++)
		{
			boolean[] tp=new boolean[4];
			for(int j=0; j<fields.get(i).size(); j++)
			{
				if(fields.get(i).get(j)<i)
				{
					tp[ans[fields.get(i).get(j)]]=true;
				}
			}
			for(int j=0; j<4;j++)
			{	
				if(!tp[j])
				{
					ans[i]=j;
					break;
				}
			}
		}
		System.out.println(ans.length);
		for(int i=0; i<ans.length; i++)
		{
			pr.print(ans[i]+1);
		}
		pr.close();
	}
}
