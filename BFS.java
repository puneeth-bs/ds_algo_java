import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS 
{
	private boolean[] marked;
	private int[] dist;
    private void  distance(ArrayList<Integer>[] adj, int s, int t) 
    {
        Queue<Integer> q = new LinkedList<Integer>();
        dist = new int[adj.length];
        for(int i = 0; i<adj.length; i++)
        {
        	dist[i] = -1;
        }
        marked = new boolean [adj.length];
        q.add(s);
        marked[s] = true;
        dist[s] = 0;
        while(!q.isEmpty())
        {
        	int v = q.remove();
        	for(int w : adj[v])
        	{
        		if(!marked[w])
        		{
        			q.add(w);
        			marked[w] = true;
        			dist[w] = dist[v] + 1;
        		}
        	}
        }
        
        if(dist[t] != 0)
        {
        	System.out.println (""+(dist[t]));
        }
        
        else{
        	System.out.println (""+(-1));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BFS b = new BFS();
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        b.distance(adj, x, y);
        
    }
}

