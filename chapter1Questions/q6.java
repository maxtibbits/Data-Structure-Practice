package chapter1Questions;

/**
 * @author maxti
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * If the "compressed" string would not become smaller than the original string, your method should
 * return the original string.
 * 
 * You can assume the string has only uppercase and lowercase letters.
 * 
 * This algorithm will count uppercase and lowercase letters as separate chars.
 */


public class q6 {

	public static void main(String args[]) {
		
		String input = "zzzZZZZaaAAAmMMMM";
		
		String input2 = "abc";
		
		String input3 = "ILuvProgrammmmmmmmmmmmmmmming";
		
		sCompression(input);
		sCompression(input2);
		sCompression(input3);
		
	}
	
	
	
	private static void sCompression (String input) {
		String output = "";
		HashTable hashTable = new HashTable();
		int hashMapIndex = 0;
		
		
		for (int i = 0; i < input.length(); i++) {
			hashMapIndex = hash(input.charAt(i));
			hashTable.insert(hashMapIndex, input.charAt(i));
		}			
		
		for (int i = 0; i < 52; i++) {
			if (hashTable.tableData[i] != null) {
				output += hashTable.getValue(i) + "" + hashTable.getCount(i);
			}
		}
		
		if (input.length() <= output.length()) {
			System.out.println("Input: " + input + " not compressed. Not shorter.");
			
		}
		else {
			System.out.println("Input: " + input + " compressed to: " + output);
		}
		
	}
	
	private static int hash (char x) {
		int index = x;
		if(index <= 90) {
			index -= 65;
		}
		else if (index >= 97) {
			index -= 72;
		}
				
		return index;
		
	}
	
	private static class HashTable {
		private Entry[] tableData = new Entry[52];
		
		private void insert (int key, char value) {
			if (tableData[key] != null) {
				tableData[key].count++;
			}
			else {
				tableData[key] = new Entry(value);
			}
		}
		
		private int getCount (int index) {
			return tableData[index].count;
		}
		
		private char getValue (int index) {
			return tableData[index].value;
		}
		
	}
	
	private static class Entry {
		char value;
		int count;
		
		private Entry(char value) {
			this.value = value;
			this.count++;
			
		}
				
	}
	
}

