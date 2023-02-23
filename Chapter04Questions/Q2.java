//package Chapter04Questions;
//
///**
// * 4.2
// * @author maxti
// * 
// * Given a sorted (increasing order) array with unique integer elements, 
// * write an algorithm to create a binary search tree with minimal height.
// */
//public class Q2 {
//
//	public static void main(String[] args) {
//		
//		int[] input = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
//		
//		BST test = new BST();
//		
//		for (int i = 0; i<input.length; i++) {
//			test.add(input[i]);
//		}
//		
//		System.out.println(test.head.balanced);
//		System.out.println(test.head.getValue());
//	}
//	
//	private static class BST{
//		
//		BSTnode head;
//		
//		private void add(int x) {
//			if (this.head == null) {
//				BSTnode tmpNode = new BSTnode(x);
//				this.head = tmpNode;
//				return;
//			}
//			head.insert(x);
//			head.checkHeight();
//			
//			if (head.balanced == false){
//				System.out.println("hnelo");
//				BSTnode tmpNode = this.head;
//				while (tmpNode.getLeftChild() != null) {
//					tmpNode = tmpNode.getLeftChild();
//				}
//				
//				tmpNode.setLeftChild(tmpNode);
//				tmpNode = tmpNode.getRightChild();
//				head.checkHeight();
//			}
//		}
//		
////		private boolean checkBalance(BSTnode x) {
////			boolean output = false;
////			
////			//checkleft
////			if (x.getLeftChild == null) {
////				
////			}
////			
////			
////			return output;
////		}
////	
//		
//		
//
//
//		static class BSTnode{
//			int value;
//			BSTnode leftChild;
//			BSTnode rightChild;
//			BSTnode parent;
//			int height;
//			boolean balanced;
//			
//			private int checkHeight() {
//				int rightHeight, leftHeight, height;
//				
//				if(this.leftChild == null && this.rightChild == null) {
//					this.height = 0;
//					return 0;
//				}
//				if (this.leftChild != null) {
//					leftHeight = this.leftChild.checkHeight();
//				}
//				else {
//					leftHeight = 0;
//				}
//				
//				if (this.rightChild != null) {
//					rightHeight = this.rightChild.checkHeight();
//				}
//				else {
//					rightHeight = 0;
//				}
//				
//				if (rightHeight > leftHeight) {
//					height = rightHeight+1;
//				}
//				else {
//					height = leftHeight+1;
//				}
//				
//				if(Math.abs(rightHeight - leftHeight) > 1) {
//					this.balanced = false;
//				}
//				else {
//					this.balanced = true;
//				}
//				
//				this.height = height;
//				return height;
//			}
//			
//			private BSTnode(int value){
//				this.value = value;
//			}
//			
//			private int getValue() {
//				return this.value;
//			}
//			
//			private void setValue(int x) {
//				this.value = x;
//			}
//			
//			private void insert(int x) {
//				BSTnode tmpNode = new BSTnode(x); 
//				
//				if(x <= this.value){
//					if (this.leftChild == null) {
//						this.leftChild = tmpNode;
//						this.leftChild.parent = this;
//						return;
//					}
//					else {
//						this.leftChild.insert(x);
//					}
//				}
//				
//				if(x > this.value){
//					if (this.rightChild == null) {
//						this.rightChild = tmpNode;
//						this.rightChild.parent = this;
//						return;
//					}
//					else {
//						this.rightChild.insert(x);
//						
//					}
//				}
//			}
//			
//			private void setLeftChild(BSTnode input) {
//				this.leftChild = input;
//			}
//			
//			private BSTnode getLeftChild() {
//				return this.leftChild;
//			}
//			
//			private void setRightChild(BSTnode input) {
//				
//				this.rightChild = input;					
//			}
//			
//			private BSTnode getRightChild() {
//				return this.rightChild;
//			}
//		}
//	}
//	
//	
//	
//}
