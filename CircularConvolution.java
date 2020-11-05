import java.util.Scanner;
public class CircularConvolution {
	
	
	public void rigthRotate(int [] arr, int [][] matrix, int n){
		
		int temp[] = new int [n];
		int r = 1;
		for(int k = 0; k < n; k++)
		{
			for(int i = 0 ; i < n; i++)
		     {
			   temp[(i+r)%n] = arr[i];
			   //System.out.print (temp[(i+r)%n]+" ");
			   matrix[i][k] = temp[(i+r)%n];
		     }
		     
		     for(int j = 0; j < n; j++)
		     {
		     	arr[j] = temp[j];
		     }
		}
		
	}
	
	public void printMatrix(int [][] matrix, int n){
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println ();
		}
		System.out.println ();
	}
	
	public void multiplyMatrix(int [][] matrix, int [] x, int n){
		
		for(int i = 0; i < n; i++){
			int sum = 0;
			for(int j = 0; j < n; j++){
				
				sum += matrix[i][j] * x[j];	
			}
			System.out.print(sum+" ");
		}
	}
	
    public static void main(String[] args) {
    	   Scanner s = new Scanner(System.in);
    	   CircularConvolution c = new CircularConvolution();
        System.out.print ("Enter length of the sequence: ");
        int n = s.nextInt();
        int [] x = new int[n];
        int [] h = new int[n];
        int [][] matrix = new int[n][n];
        
        System.out.print("Enter x sequence: ");
        for(int i = 0; i < n ;i++)
        {
        	x[i] = s.nextInt();
        }
        System.out.print("Enter h sequence: ");
        for(int i = 0; i < n ;i++)
        {
        	h[i] = s.nextInt();
        }
        
        c.rigthRotate(h, matrix, n);
        c.printMatrix(matrix, n);
        System.out.print("x(n) * h(n) = [ ");
        c.multiplyMatrix(matrix, x, n);
        System.out.print("]");
        
        
    }
}
