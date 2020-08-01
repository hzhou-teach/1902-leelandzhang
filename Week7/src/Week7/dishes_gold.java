//Leeland Zhang
//I literally knew the correct algorithm, I understood how the problem
//worked, all I had to do was just go through them one by one.
//But my dumb self over-complicated the problem so much.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dishes_gold 
{
	static int[] dirty;
	static int[] prio;
	static int priopos;
	static ArrayList<ArrayList<Integer>> deck;//'counter'
	static int search(int l, int h, int x) 
    { 
        if (h >= l) 
        { 
            int mid = (l+h)/2; 
            int num=deck.get(mid).get(deck.get(mid).size()-1);
            if (num-1 == x) 
                return mid; 
            if (num-1 > x) 
                return search(l, mid - 1, x); 
            return search(mid + 1, h, x); 
        }
        return -1; 
    } 
	static boolean step(int i, int k)
	{
		if(prio[i]==dirty[k])
		{
			priopos++;
			return true;
		}
		else if(deck.isEmpty()||deck.get(deck.size()-1).get(0)<dirty[k])
		{
			deck.add(new ArrayList<Integer>());
			deck.get(deck.size()-1).add(dirty[k]);
			return true;
		}
		else
		{
			if(search(0,deck.size()-1,dirty[k])==-1)
				return false;
			else
			{
				deck.get(search(0,deck.size()-1,dirty[k])).add(dirty[k]);
				return true;
			}
		}
	}
	static boolean iterate(int length)
	{
		priopos=0;
		for(int k=0; k<dirty.length; k++)
		{
			boolean tp=step(priopos,k);
			if(!tp)
				return false;
		}
		return true;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("dishes.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("dishes.out"));
		int N=sc.nextInt();
		dirty=new int[N];
		prio=new int[N];
		for(int i=0; i<N; i++)
		{
			int temp=sc.nextInt();
			dirty[i]=temp;
			prio[i]=temp;
		}
		sc.close();
		//------------------------------------------------------------
		Arrays.sort(prio);
		deck=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> possible=new ArrayList<Integer>();
		possible.add(0);
		int min=dirty[0];
		int max=dirty[0];
		for(int i=1; i<N; i++)
		{
			if(dirty[i]<min)
				min=dirty[i];
			if(dirty[i]>max)
				max=dirty[i];
			if(max-min==i)
				possible.add(i);
		}
		int l=0; 
		int h=possible.size()-1;
		int best=0;
		while (l <= h) 
		{
	        int mid = (l + h) / 2;
	        if (iterate(possible.get(mid)))
	        {
	            best=l;
	            l = mid + 1;
	        }
	        else if (!iterate(possible.get(mid)))
	            h = mid - 1;
	    }
		pr.println(best);
		pr.close();
	}
}
