import java.util.*;
public class DFS 
{
    private boolean[] marked;
    
    public void dfsTraverse(ArrayList<Integer>[] adj)
    {
    	 marked = new boolean [adj.length];
    	 for(int i = 0; i< adj.length; i++)
    	 {
    	 	marked[i] = false;
    	 }
    	 
    	 for(int v = 0; v < adj.length ; v++)
    	 {
    	 	if(marked[v]==false)
    	 	{
    	 		dfs(v,marked,adj);
    	 	}
    	 }
    }
    	 
    	 public void dfs(int v, boolean[] marked, ArrayList<Integer>[] adj)
    	 {
    	 	marked[v] = true;
    	 	System.out.print((v+1)+" ");
    	 	for(int w: adj[v])
    	 	{
    	 		if(!marked[w])
    	 		{
    	 			dfs(w,marked,adj);
    	 		}
    	 	}
    	 }
    
   
    public static void main(String[] args) 
    {
    	   DFS d = new DFS();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) 
        	{
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x-1].add(y-1);
            adj[y-1].add(x-1);
          }
        d.dfsTraverse(adj);
    }
}
