import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class Toposort 
{
    private boolean [] marked;
    Stack<Integer> stack = new  Stack<Integer>();
    
    public void dfs(int v, boolean [] marked, Stack<Integer> stack, ArrayList<Integer>[] adj)
    {
    	 marked[v] = true;
    	 int i;
    	 Iterator<Integer> it = adj[v].iterator();
    	 while(it.hasNext())
    	 {
    	 	i = it.next();
    	 	if(!marked[i])
    	 	{
    	 		dfs(i, marked, stack, adj);
    	 	}
    	 }
    	 
    	 stack.push(new Integer(v));
    	
    }
    
    public void topologicalSort(ArrayList<Integer>[] adj)
    { 
    	 marked = new boolean [adj.length];
    	 for(int i=0;i<adj.length;i++)
    	 {
    	 	marked[i] = false;
    	 }
    	 
    	 for(int i=0;i<adj.length;i++)
    	 {
    	 	if(marked[i]==false)
    	 	{
    	 		dfs(i, marked, stack,adj);
    	 	}
    	 }
    	 
    	 while(stack.empty() == false)
    	 {
    	 	System.out.print((stack.pop()+1)+" ");
    	 }
    }

    public static  void main(String[] args) {
    	   Toposort t = new Toposort();
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
        }
        
       t.topologicalSort(adj);
                
        
        
    }
}

