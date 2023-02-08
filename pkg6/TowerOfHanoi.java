package pkg6;
/*
 * Implementation of the Tower of Hanoi problem using recursion
 * 
 * Planning on using an actual data structure later
 * 
 * Obscure Mass Effect 1 reference
 */
public class TowerOfHanoi {

	/*
	 * Constructor method for recursion
	 * n = number of disks		
	 */
	public void move(int n, char from, char to, char by) {
		
		if(n == 1) {
			System.out.println("Moving disc " + n + " from " + from + " to " + to + " by " + by);
		}
		else {
			move(n-1, from, by, to);
			System.out.println("Moving disc " + n + " from " +  from + " to " + to + " by " + by);
			move(n-1, by, to, from);
		}
	}
	
	
	public static void main(String[] args) {
		
		TowerOfHanoi test = new TowerOfHanoi();
		test.move(3, 'A', 'C', 'B');
	}
}
