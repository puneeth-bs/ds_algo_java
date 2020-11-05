import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Acyclicity 
{
    public boolean [] visited;
    public boolean [] recStack;
    public  int cycles = 0;
    
    public boolean isCyclic(int i,ArrayList<Integer>[] adj, boolean [] visited, boolean[] recStack)
    {
    	  if(recStack[i])
    	  {
    	  	return true;
    	  } 
    	  	
    	  if(visited[i])
    	  {
    	  	return false;
    	  }
    	  	
    	  visited[i] = true;
    	  recStack[i] = true;
    	  
    	  for(int w : adj[i])
    	  {
    	  	if(isCyclic(w,adj,visited,recStack));
    	  	{
    	  		return true;
    	  	}
    	  }
    	  
    	  recStack[i] = false;
    	  
    	  
    	  return false; 
    }
    
    private  boolean  acyclic(ArrayList<Integer>[] adj) 
    {
       boolean[] visited = new boolean[adj.length]; 
       boolean[] recStack = new boolean[adj.length]; 
       
       for(int i = 0; i<adj.length;i++)
       {
       	if(isCyclic(i, adj, visited, recStack))
       	{
       		return true;
       	}
       }
       
       return false;
              
    }
    
    public int Count(ArrayList<Integer>[] adj)
    {
    	  if(acyclic(adj))
    	  {
    	  	cycles+=1;
    	  }
    	  
    	  return cycles;
    }

    public static void main(String[] args) {
    	   Acyclicity ac = new Acyclicity();
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
        ac.acyclic(adj);
        System.out.println (ac.Count(adj)+" ");
        
       
    }
}

