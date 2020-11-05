

import java.util.Scanner;
public class CountingSort {
	
    public int countSort(int [] input_arr, int [] count_arr, int [] output_arr, int n, int range)
    {
    	  for(int i = 0; i < n; i++)
        {
        	++count_arr[input_arr[i]];//count the frequency of the elements in the input array and place them in the count array
        	                          // according to their index
        }
        int [] result_arr = new int[range];
        
        for(int i = 1; i < range; i++)
        {
        	count_arr[i] = count_arr[i] + count_arr[i-1]; //storing cummulative values in a count array
        }
        
        for(int i = 0; i < n; i++)
        {
        	output_arr[--count_arr[input_arr[i]]] = input_arr[i]; // place elements of input_arr in output_arr using 
        	                                                      //the positions stored in the count_arr
        }
        
        int median = output_arr[(output_arr.length)/2];
        return median;
    }
    
   
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CountingSort cs = new CountingSort();
        int range = 100;
        int n = s.nextInt();
        int [] input_arr = new int[n];// create an input array
        int [] count_arr = new int[range];// create a count array
        for(int i = 0; i < n; i++)
        {
        	input_arr[i] = s.nextInt();
        }
        
        int [] output_arr = new int[n];
        for(int i = 0; i < n; i++)
        {
        	output_arr[i] = 0;
        }
        
        
        for(int i = 0; i < range; i++)
        {
        	count_arr[i] = 0;//intialise count array elements to zero
        }
        
        
        cs.countSort(input_arr, count_arr, output_arr, n, range);
    }
 }

