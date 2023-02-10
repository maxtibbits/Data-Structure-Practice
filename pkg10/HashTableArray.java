package pkg10;

public class HashTableArray<T> {

	Entry[] arrayHash;
	int size;
	
	public HashTableArray(int size) {
		this.size = size;
		arrayHash = new Entry[size];
		
		for(int i = 0; i < size; i++) {
			arrayHash[i] = new Entry();
		}
	}
	
	int getHash(int key) {
		return key%size;
	}
	
	public void insert (int key, Object value) {
		int hashIndex = getHash(key);
		Entry storedEntry = arrayHash[hashIndex]; //if element is null, will return null
		
		Entry newEntry = new Entry(key, value);
		newEntry.next = storedEntry;
		arrayHash[hashIndex] = newEntry;
		
	}
	
	public T get (int key) {
		T value = null;
		int HashIndex = getHash(key);
		Entry storedEntry = arrayHash[HashIndex];
		
		while(storedEntry != null) {
			if(storedEntry.getKey() == key) {
				value = (T) storedEntry.getValue();
				break;
			}
			storedEntry = storedEntry.next;
		}
		
		return value;
		
		
	}
}
