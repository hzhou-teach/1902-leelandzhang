//I gave up and I don't understand the solutions at all
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class paintbarn_silver 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("paintbarn.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("paintbarn.out"));
		int N=sc.nextInt();
		int K=sc.nextInt();
		int[][] paint=new int[1000][1000];
		for(int i=0; i<N; i++)
		{
			int x0=sc.nextInt();
			int y0=sc.nextInt();
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			for(int j=y0; j<y1; j++)
			{
				for(int k=x0; k<x1; k++)
				{
					paint[j][k]++;
				}
			}
		}
		sc.close();
		int count=0;
		for(int i=0; i<1000; i++)
		{
			for(int j=0; j<1000; j++)
			{
				if(paint[i][j]==K)
					count++;
			}
		}
		pr.println(count);
		pr.close();
	}
}
