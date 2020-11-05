import java.util.Scanner;
import java.util.*;
public class MergeSort{
    
     public void merge(String [] arr, int l, int m, int r)
     {
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        String L[] = new String[n1]; 
        String R[] = new String[n2]; 
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) {
            double a = Double.parseDouble(L[i]);
            double b = Double.parseDouble(R[j]); 
            if (a <= b) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }
    
    public void printArray(String [] arr, int n){
    	for(int i = 0; i < n; i++)
    	{
    		System.out.print(arr[i]+" ");
    	}
    }
    
    
    
    
    public void mergeSort(String [] arr, int l, int r){
        if(l<r)
        {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
   }
    
    
    
        
    public static void main(String [] args)
    {
    	   long start = System.currentTimeMillis();
        Scanner s = new Scanner (System.in);
        MergeSort solution = new MergeSort();
        int n = s.nextInt();
        String  [] arr = new String [n];
        
        for(int i = 0; i< n; i++)
        {
            arr[i] = s.next();
        }
        
        
        solution.mergeSort(arr, 0, arr.length-1);
        System.out.println ("Sorted array: ");
        solution.printArray(arr, arr.length);
        
        System.out.println ();
        long end = System.currentTimeMillis();	
        float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
    }

 
}
