package chapter03Questions;


/**
 * 
 * @author maxti
 * Describe how you could use a single array to implement three stacks
 * 
 * Instead of describing, I will implement this. It's unclear if I could've used an
 * array of custom nodes so I stuck to a simple array. This takes 0(n) memory and
 * push and pop are O(n);
 * 
 */

public class q1 {
	
	public static void main (String[] args) {
		
		Array3Stack test = new Array3Stack();
		
		test.push(1, 1);
		
		System.out.println(test.toString());
		
		System.out.println("Stack 2 is empty? " + test.isEmpty(2));
		
		test.push(1, 2);
		test.push(3, 102);
		test.push(2, 24);
		test.push(2, 25);
		for (int i = 26; i < 30; i++) {
			test.push(2, i);
		}

		System.out.println(test.toString());

		
		System.out.println(test.toString());
		
		System.out.println("Stack 3 is empty? "+ test.isEmpty(1));
		
		System.out.println("Peek at 2: " + test.peek(2));
		System.out.println("Pop at 2: " + test.pop(2));
		
		System.out.println(test.toString());
		
		System.out.println("Peek at 2: " + test.peek(2));
		System.out.println("Pop at 1: " + test.pop(1));
		System.out.println("Pop at 1: " + test.pop(1));
		System.out.println("Pop at 1: " + test.pop(1));
		
		System.out.println(test.toString());
		
		System.out.println("Pop at 2: " + test.pop(2));
		System.out.println("Pop at 2: " + test.pop(2));
		System.out.println("Pop at 2: " + test.pop(2));
		System.out.println("Pop at 2: " + test.pop(2));
		System.out.println("Pop at 2: " + test.pop(2));
		System.out.println("Pop at 2: " + test.pop(2));

		System.out.println(test.toString());

	}
		
	private static class Array3Stack{

		private int[] array3 = new int[3];
		
		private int index1 = 0;
		private int index2 = 1;
		private int index3 = 2;
		
		private boolean stack1Init = false;
		private boolean stack2Init = false;
		private boolean stack3Init = false;
		
		public void push(int stack, int value){
			int[] tmp = resizeArrayAdd1();
			if (stack == 1) {
				if (this.stack1Init == false) {
					this.array3[index1] = value;
					stack1Init = true;
					return;
				}
				index2++;
				index3++;
				tmp[index1] = value;
				for (int i = index1+1; i<tmp.length;i++) {
					tmp[i] = array3[i - 1];
				}
			}
			if (stack == 2) {
				if (this.stack2Init == false) {
					this.array3[index2] = value;
					stack2Init = true;
					return;
				}
				index3++;
				tmp[index2] = value;
				for (int i = 0; i<index2; i++) {
					tmp[i] = array3[i];
				}
				for (int i = index2 +1; i < tmp.length; i++) {
					tmp[i] = array3[i-1];
				}
			}
			if (stack == 3) {
				if (this.stack3Init == false) {
					this.array3[index3] = value;
					stack3Init = true;
					return;
				}
				tmp[index3] = value;
				for (int i = 0; i<index3; i++) {
					tmp[i] = array3[i];
				}
				for (int i = index3 +1; i < tmp.length; i++) {
					tmp[i] = array3[i-1];
				}
			}
			
			this.array3 = tmp;
		}
		
		public int pop(int stack) {
			int output = 0;
			int[] tmp = resizeArrayMinus1();
			if (stack == 1) {
				if (this.stack1Init == false) {
					System.out.println("Stack " + stack + " not initialized!");
					return 0;
				}
				else {
					if (index1 != index2-1) {
						index2--;
						index3--;
					}
					else {
						output = array3[index1];
						array3[index1] = 0;
						this.stack1Init = false;
						return output;
					}
					
					output = array3[index1];
					for (int i = 0; i < tmp.length; i++) {
						tmp[i] = array3[i+1];
					}
					
					this.array3 = tmp;
				}
			}
			if (stack == 2) {
				if (this.stack2Init == false) {
					System.out.println("Stack " + stack + " not initialized!");
					return 0;
				}
				else {
					if (index2 != index3-1) {
						index3--;
					}
					else {
						output = array3[index2];
						array3[index2] = 0;
						this.stack2Init = false;
						return output;
					}
					output = array3[index2];
					for (int i = 0; i < index2; i++) {
						tmp[i] = array3[i];
					}
					for (int i = index2; i < tmp.length; i++) {
						tmp[i] = array3[i+1];
					}
					this.array3 = tmp;
				}
			}
			if (stack == 3) {
				if (this.stack3Init == false) {
					System.out.println("Stack " + stack + " not initialized!");
					return 0;
				}
				if(index3 == tmp.length-1) {
					output = array3[index3];
					array3[index3] = 0;
					this.stack3Init = false;
					return output;
				}
				output = array3[index3];
				for (int i = 0; i < index3; i++) {
					tmp[i] = array3[i];
				}
				for (int i = index3+1; i < tmp.length; i++) {
					tmp[i] = array3[i+1];
				}
				this.array3 = tmp;
			}
			
			this.array3 = tmp;
			
			return output;
		}
		
		public int peek(int stack) {
			int output = 0;
			
			if (stack == 1) {
				return array3[index1];
			}

			if (stack == 2) {
				return array3[index2];
			}
			if (stack == 3) {
				return array3[index3];
			}
			
			return output;
		}
		
		public boolean isEmpty(int stack) {
			if (stack == 1) {
				return !this.stack1Init;
			}
			if (stack == 2) {
				return !this.stack2Init;
			}
			if (stack == 3) {
				return !this.stack3Init;
			}
			else return false;
		}
		
		public int[] resizeArrayAdd1(){
			int[] tmp = new int[this.array3.length + 1];
			
			return tmp;
		}
		
		public int[] resizeArrayMinus1(){
			int[] tmp = new int[this.array3.length - 1];
			
			return tmp;		
		}
		
		@Override
		public String toString() {
			String output = "Stack 1: [";
			for (int i = 0; i<this.array3.length; i++) {
				if(i == this.index2) {
					output += "] Stack 2: [";
				}
				if(i == this.index3) {
					output += "] Stack 3: [";
				}
				output += array3[i];
				if (i < array3.length - 1 && (i != index2-1 && i != index3-1)){
					output += ", ";
				}
			}
			
			output += "]";			
			
			return output;
		}

	}
	
}
