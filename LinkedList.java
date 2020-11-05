import java.util.Scanner;
public class LinkedList {
   
    static class Node{
    	int key;
    	int data;
    	Node next;
    	
    	Node(int k, int d){
    		key = k;
    		data = d;
    		next = null;
    	}
    }
    
    static Node head;
    
    public void push(int key, int data){
    	Node new_node = new Node(key, data);
    	
    	new_node.next = head;
    	head = new_node;
    }
    
    public void insert(int prev_node_key, int key, int data){
    	
    	Node temp_node = head;
    	while(temp_node != null){
    		
    		if(temp_node.key == prev_node_key){
    			break;
    		}else{
    			temp_node = temp_node.next;
    		}
    	}
    	
    	
    	Node new_node = new Node(key, data);
    	new_node.next = temp_node.next;
    	temp_node.next = new_node;
    }
    
    public void append(int key, int data){
    	
    	if(head == null){
    		head = new Node(key, data);
    	}
    	
    	Node new_node = new Node(key, data);
    	new_node.next = null;
    	Node last = head;
    	while(last.next != null){
    		last = last.next;
    	}
    	
    	last.next = new_node;
    }
    
    public void printList(Node tempNode) 
    { 
        Node tnode = tempNode; 
        while (tnode != null) 
        { 
        	  
            System.out.print(tnode.key+" "+tnode.data+"");
            if(tnode.next != null){
            	System.out.print("-->");
            } 
            tnode = tnode.next; 
        } 
    }
    
    public void delete(int key){
    	
    	Node temp = head, prev = null;
 
        // If head node itself holds the key to be deleted
        if (temp != null && temp.key == key)
        {
            head = temp.next; // Changed head
            return;
        }
 
        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.key != key)
        {
            prev = temp;
            temp = temp.next;
        }    
 
        // If key was not present in linked list
        if (temp == null) return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
    	
    } 
    	
    public Node reverseLinkedList(){
    	Node node = head;
    	Node prev = null;
    	Node current = node;
    	Node next = null;
    	
    	while(current != null){
    		next = current.next;
    		current.next = prev;
    		prev = current;
    		current = next;
    	}
    	
    	node = prev;
    	return node;
    	
    }
    	
    	
    public static void main(String[] args) 
    {
        LinkedList list = new LinkedList();
        Scanner s = new Scanner(System.in);
        list.push(0, 10);
        list.append(1,20);
        list.append(2, 30);
        list.insert(1, 4, 50);
        list.delete(4);
        System.out.println ();
        
        
        
        int option;
        
        do{
           System.out.println ();
           System.out.println ();
           System.out.println("Choose any options bellow, press 0 to exit");
           System.out.println ("1.Push Node");
           System.out.println ("2.Append Node");
           System.out.println ("3.Insert node after a particular node");
           System.out.println ("4.Delete Node");
           System.out.println ("5.Print Node");
           System.out.println ("6.Reverse linked list");
           System.out.println ();
           System.out.print ("Your option: ");
           option = s.nextInt();
           System.out.println ();
           switch(option){
           	
           	case 0:
           		System.exit(0);
           		break;
           		
           	case 1:
           		System.out.print ("Enter key and data: ");
           		int key = s.nextInt();
           		int data = s.nextInt(); 
           		list.push(key, data);
           		System.out.println ("Node pushed successfully");
           		break;
           		
           		
           	case 2:
           		System.out.print ("Enter key and data of new node: ");
           		int key1 = s.nextInt();
           		int data1 = s.nextInt(); 
           		list.append(key1, data1);
           		System.out.println ("Node appended successfully");
           		break;
           		
           	case 3:
           		System.out.print ("Enter key of previous node, key and data of new node: ");
           		int prev_key = s.nextInt();
           		int key2 = s.nextInt();
           		int data2 = s.nextInt(); 
           		list.insert(prev_key, key2, data2);
           		System.out.println ("Node inserted successfully");
           		break;
           		
           	case 4:
           		
           		System.out.print ("Enter the key of the node to be deleted: ");
           		int key3 = s.nextInt();
           		list.delete(key3);
           		break;
           		
           	case 5:
           		list.printList(head);	
           	     break;
           	case 6:
           		Node head1 = list.reverseLinkedList();
           		System.out.println ("Reversed list: ");
           		list.printList(head1);
           		break;
           }
        }while(option!=0);
        
    }
}
