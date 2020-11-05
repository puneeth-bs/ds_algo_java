import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite 
{
	
	
    private boolean  bipartite(ArrayList<Integer>[] adj, int source) 
    {
    	   int[] colorArr = new int[adj.length];
    	   for(int i = 0; i<adj.length; i++)
    	   {
    	   	colorArr[i] = -1;
    	   }
    	   colorArr[source] = 1;
    	   Queue<Integer> q = new LinkedList<Integer>();
    	   q.add(source);
    	   while(!q.isEmpty())
    	   {
    	   	int v = q.remove();
    	   	for(int w: adj[v])
    	   	{
    	   		if(colorArr[w] == -1)
    	   		{
    	   			colorArr[w] = 1-colorArr[v];
    	   			q.add(w);
    	   		}
    	   		
    	   		else if(colorArr[w] == colorArr[v])
    	   		{
    	   			return false;
    	   		}
    	   	}
    	   }
    	   
    	   return true;
    }

    public static void main(String[] args) {
    	   Bipartite b = new Bipartite();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        } 
        	
        	
        if(b.bipartite(adj, 0))
        {
        	System.out.println ("1");
        }  
        	
        else{
        	System.out.println ("0");
        }
        
    }

}
