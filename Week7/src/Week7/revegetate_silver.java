
//Leeland Zhang
//Took me an hour and half
//Got 9/12
//I think to make it faster I can take them in as groups,
//and then merge groups together if they have a common number,
//just I don't know how to merge, I know that its possible,
//and to be totally honest I spent so much time that I don't want to 
//completely re-write my code
//I also forgot to account for the special case that no solutions exist
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class revegetate_silver 
{
	private static boolean[] possible;
	private static int count=0;
	static void deleate(int x, ArrayList<ArrayList<Integer>> fields)
	{
			count++;
			possible[x]=true;
			for(int i=0; i<fields.get(x).size();i++)
			{
				if(!possible[fields.get(x).get(i)])
				deleate(fields.get(x).get(i),fields);
			}
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("revegetate.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("revegetate.out"));
		int N=sc.nextInt();
		int M=sc.nextInt();
		ArrayList<ArrayList<Integer>> fields=new ArrayList<ArrayList<Integer>>(N);
		for(int i=0; i<N; i++)
		{
			fields.add(new ArrayList<Integer>());
		}
		for(int i=0; i<M; i++)
		{
			String useless=sc.next();
			int x=sc.nextInt()-1;
			int y=sc.nextInt()-1;
			fields.get(x).add(y);
			fields.get(y).add(x);
		}
		sc.close();
		possible=new boolean[N];
		int count1=0;
		while(count<N)
		{
			int pos=0;
			for(int i=0; i<possible.length; i++)
			{
				if(!possible[i])
				{
					pos=i;
					break;
				}
			}
			deleate(pos,fields);
			count1++;
		}
		if(count1==0)
			pr.print(0);
		else
		{
			pr.print(1);
			for(int i=0; i<count1; i++)
				pr.print(0);
		}
		pr.close();
	}
}
