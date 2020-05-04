import java.lang.*;
import java.io.*;
class Node 
{
	public int iData;
	

    public Node(int key) 
    {
    	  iData = key;
    }
    
    
}

class Heap
{
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;
	
	
	public Heap(int mx)
	{
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize];
	}
	
	public boolean isEmpty()
	{
		return currentSize==0;
	}
	
	public boolean insert(int key)
	{
		if(currentSize == maxSize)
		{
			return false;
		}
		
		else{
			Node newNode = new Node(key);
			heapArray[currentSize] = newNode;
			trickleUp(currentSize++);
			return true;
			
		}
	}
	
	public void trickleUp(int index)
	{
		int parent = (index-1)/2;
		Node bottom = heapArray[index];
		while(index > 0 && (heapArray[parent].iData < bottom.iData))
		{
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapArray[index] = bottom;
	}
	
	public void triclkeDown(int index)
	{
		int largerChild;
		Node top = heapArray[index];
		while(index == currentSize/2)
		{
			int leftChild = 2*index+1;
			int rigthChild = leftChild+1;
			if(rigthChild<currentSize && (heapArray[leftChild].iData < heapArray[rigthChild].iData))
			{
				largerChild = rigthChild;
			}
			else{
				largerChild = leftChild;
			}
			
			if(top.iData>= heapArray[largerChild].iData)
			{
				break;
			}
			else{
				heapArray[index] = heapArray[largerChild];
				index = largerChild;
			}
			
			top = heapArray[index];
		}
	}
	
	public Node remove()
	{
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		triclkeDown(0);
		return root;
	}
	
	public boolean change(int index, int newValue)
	{
		if(index<0 || index>currentSize)
		{
			return false;
		}
		
		int oldValue = heapArray[index].iData;
		if(oldValue<newValue)
		{
			trickleUp(index);
		}
		else{
			triclkeDown(index);
		}
		return true;
	}
	
public void displayHeap()
{
System.out.print("heapArray: "); 
for(int m=0; m<currentSize; m++)
if(heapArray[m] != null)
System.out.print( heapArray[m].iData + " ");
else
System.out.print( "-- ");
System.out.println();
int nBlanks = 32;
int itemsPerRow = 1;
int column = 0;
int j = 0;
String dots = "...............................";
System.out.println(dots+dots); 
while(currentSize > 0) 
{
if(column == 0) 
for(int k=0; k<nBlanks; k++) 
System.out.print(' ');
System.out.print(heapArray[j].iData);
if(++j == currentSize) 
break;
if(++column==itemsPerRow) 
{
nBlanks /= 2; 
itemsPerRow *= 2; 
column = 0; 
System.out.println(); 
}
else 
for(int k=0; k<nBlanks*2-2; k++)
System.out.print(' '); 
} 
System.out.println("\n"+dots+dots); 
} 


} 
class HeapApp
{
public static void main(String[] args) throws IOException
{
int value, value2;
Heap theHeap = new Heap(31); 
boolean success;
theHeap.insert(70); 
theHeap.insert(40);
theHeap.insert(50);
theHeap.insert(20);
theHeap.insert(60);
theHeap.insert(100);
theHeap.insert(80);
theHeap.insert(30);
theHeap.insert(10);
theHeap.insert(90);
while(true) 
{
putText("Enter first letter of ");
putText("show, insert, remove, change: ");
int choice = getChar();
switch(choice)
{
case 's': // show
theHeap.displayHeap();
break;
case 'i': // insert
putText("Enter value to insert: ");
value = getInt();
success = theHeap.insert(value);
if( !success )
putText("Can't insert; heap is full" + '\n');
break;
case 'r': // remove
if( !theHeap.isEmpty() )
theHeap.remove();
else
putText("Can't remove; heap is empty" +
'\n');
break;
case 'c': // change
putText("Enter index of item: ");
value = getInt();
putText("Enter new priority: ");
value2 = getInt();
success = theHeap.change(value, value2);
if( !success )
putText("Can't change; invalid index" +
'\n');
break;
default:
putText("Invalid entry\n");
} 
} 
} 


public static void putText(String s)
{
System.out.print(s);
System.out.flush();
}

public static String getString() throws IOException
{
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
String s = br.readLine();
return s;
}

public static char getChar() throws IOException
{
String s = getString();
return s.charAt(0);
}

public static int getInt() throws IOException
{
String s = getString();
return Integer.parseInt(s);
}

}
	
	
	
	
