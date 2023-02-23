package Chapter04Questions;

/**
 * @author maxti
 *
 * I decided to switch methods to make a class that would work 
 * for this specific problem, but not in a generic situation.
 * 
 * Given a sorted (increasing order) array with unique integer elements, 
 * write an algorithm to create a binary search tree with minimal height.
 */

public class Q2a {

	public static void main(String[] args) {
		
		int[] input = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
		
		BST test = new BST(input);
		
	//	System.out.println(test.head.getValue());
		System.out.println(test.toString());
	}

	
	private static class BST{
		
		BSTnode head;
		
		BST (int[] input){
			int[] leftArray = new int[input.length/2];
			int[] rightArray = new int[input.length-input.length/2-1];
			//System.out.println(leftArray.length);
			//System.out.println(rightArray.length);
			
			for (int i = 0; i < leftArray.length; i++) {
				leftArray[i] = input[i];
			}
			
			for(int i = 0; i < rightArray.length; i++) {
				rightArray[i] = input[i+(input.length/2 +1)];
			}
			//System.out.println(rightArray[0]);

			this.head = new BSTnode(input[input.length/2]);
			this.head.setLeftChild(insert(leftArray));
			this.head.setRightChild(insert(rightArray));

		}
		
		@Override
		public String toString() {
			String output =  "";
			BSTnode tmp = this.head;
			
			while (tmp != null) {
				if(tmp.getLeftChild() != null) {
					//output += "" + tmp.getLeftChild().getValue();
				}
				if(tmp.getRightChild() != null) {
					//output += " " + tmp.getRightChild().getValue();
				}
				
				output += getValueOfChildren(this.head.getLeftChild());
				output += this.head.getValue();
				output += getValueOfChildren(this.head.getRightChild());
				
				tmp = null;
			}
			
			
			return output;
		}
		
		private String getValueOfChildren(BSTnode x) {
			if (x == null) {
				return "";
			}
			
			
			String output = getValueOfChildren(x.getLeftChild());
			output += "" + x.getValue();
			output += getValueOfChildren(x.getRightChild());
			
			
			return output;
		}
		
		private BSTnode insert(int[] input) {
			BSTnode output = new BSTnode(input[input.length/2]);
			if (input.length == 2) {
				BSTnode childNode = new BSTnode(input[0]);
				output.setLeftChild(childNode);
				return output;
			}
			
			int[] leftArray = new int[input.length/2];
			int[] rightArray = new int[input.length-input.length/2-1];
			
			for (int i = 0; i < leftArray.length; i++) {
				leftArray[i] = input[i];
			}
			
			for(int i = 0; i < rightArray.length; i++) {
				rightArray[i] = input[i+(input.length/2)+1];
			}
			
			if(leftArray.length != 0) {
				output.setLeftChild(insert(leftArray));			
			}
			if (rightArray.length != 0) {
				output.setRightChild(insert(rightArray));

			}
			
			return output;
			
		}
			
		static class BSTnode{
			int value;
			BSTnode leftChild;
			BSTnode rightChild;
			
		
			private BSTnode(int value){
				this.value = value;
			}
			
			private int getValue() {
				return this.value;
			}
			
			private void setLeftChild(BSTnode input) {
				this.leftChild = input;
			}
			
			private void setRightChild(BSTnode input) {
				
				this.rightChild = input;					
			}
			
			private BSTnode getLeftChild() {
				return this.leftChild;
			}
			
			private BSTnode getRightChild() {
				return this.rightChild;
			}
		}
	}
}
