package pkg10;

public class HashTableArrayDemo {
	
	public static void main (String[] args) {
		HashTableArray<String> test = new HashTableArray<String>(10);
		test.insert(1, "henlo");
		test.insert(4, "hiya");
		test.insert(3, "1st Bonjour");
		test.insert(13, "2nd Bonjour");
		
		System.out.println(test.get(1));
		System.out.println(test.get(12));
		
		System.out.println(test.get(3));
		System.out.println(test.get(13));
		

	}
	
	
}
