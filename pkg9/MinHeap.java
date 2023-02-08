package pkg9;

import java.util.Random;

//MinHeap implementation

public class MinHeap {
	
	private int[] HeapArray;
	private int size;
	private int maxsize;
	
    private static final int FRONT = 1;
	
	public MinHeap (int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		
		HeapArray = new int[this.maxsize*2];
		HeapArray[0] = Integer.MIN_VALUE;
		
	}
	
	private int findParent(int i) { 
		return i / 2; 
	}
	
	private int findLeftChild(int i) { 
		 return (2 * i); 
	 }

	private int findRightChild(int i) { 
		return ((2 * i) + 1) ; 
	}
	 
	private boolean isLeaf(int pos) {
		if (pos > (size / 2)) {
			return true;
		}
	    return false;
	}

    private void swap(int fpos, int spos)
    {
 
        int tmp;
        tmp = HeapArray[fpos];
 
        HeapArray[fpos] = HeapArray[spos];
        HeapArray[spos] = tmp;
    }
    
    private void minHeapify(int pos)
    {     
      if(!isLeaf(pos)){
        int swapPos= pos;
        // swap with the minimum of the two children
        // to check if right child exists. Otherwise default value will be '0'
        // and that will be swapped with parent node.
        if(findRightChild(pos)<=size)
           swapPos = HeapArray[findLeftChild(pos)]<HeapArray[findRightChild(pos)]?findLeftChild(pos):findRightChild(pos);
        else
          swapPos= HeapArray[findLeftChild(pos)];
         
        if(HeapArray[pos]>HeapArray[findLeftChild(pos)] || HeapArray[pos]> HeapArray[findRightChild(pos)]){
          swap(pos,swapPos);
          minHeapify(swapPos);
        }
         
      }      
    }
    
    public void insert(int element)
    {
  
         if (size >= maxsize) {
             return;
         }
  
         HeapArray[++size] = element;
         int current = size;
  
         while (HeapArray[current] < HeapArray[findParent(current)]) {
             swap(current, findParent(current));
             current = findParent(current);
         }
     }
  
     // Method 8
     // To print the contents of the heap
     public void print()
     {
         for (int i = 1; i <= size / 2; i++) {
  
             // Printing the parent and both children
             System.out.print(
                 " PARENT : " + HeapArray[i]
                 + " LEFT CHILD : " + HeapArray[2 * i]
                 + " RIGHT CHILD :" + HeapArray[2 * i + 1]);
  
             // By here new line is required
             System.out.println();
         }
     }
  
     // Method 9
     // To remove and return the minimum
     // element from the heap
     public int remove()
     {
  
         int popped = HeapArray[FRONT];
         HeapArray[FRONT] = HeapArray[size--];
         minHeapify(FRONT);
  
         return popped;
     }
	
     private static String printArray(int[] x) {
		 if(x == null) {
			 return "Error: array empty!";
		 }
		 String result = "[" + x[0];
		 if (x.length == 1) {
			 return result += "] Array only has one element!";
		 }
		 for (int i = 1; i < x.length; i++) {
			 result += ", " + x[i];
		 }
		 result += "]";
		 
		 return result;
     }
     
	public static void main(String[] args) {
		
		
		
		Random rand = new Random();
		int[] x = new int[20];
		for (int i = 0; i < x.length; i++) {
			x[i] = rand.nextInt(100);
		}
		MinHeap minHeap = new MinHeap(x.length*2);
		
		System.out.println("Array before MinHeap: " + printArray(x));
		
		for (int i = 0; i < x.length; i++) {
			minHeap.insert(x[i]);
		}
		
		System.out.println("Array After MinHeap: ");
		minHeap.print();
		
		System.out.println("The Min val is "
                + minHeap.remove());

		System.out.println("Array After Remove method: ");
		minHeap.print();

		
	}
}
