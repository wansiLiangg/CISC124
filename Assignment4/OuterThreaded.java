/*
 * This class is checking if the length is valid, and passing diameter, material, finish, price, and unit to the Threaded class
 */
public class OuterThreaded extends Threaded {

	private static final long serialVersionUID = 1L;
	
	private double length; 
	
	//Passing diameter, material, finish, price, and unit to the Threaded class
	public OuterThreaded(double length, String diameter, String material, String finish, double price, int unit) throws IllegalFastener {
		super(diameter, material, finish, price, unit); 
		checkLength(length); 
	}
	
	//Checking if length is valid
	private void checkLength(double length) throws IllegalFastener {
		if (length>0.5 && length<6) {
			this.length = length; 
		}
		else if (length>=6 && length<11) {
			this.length = length; 
		}
		else if (length>=11 && length<20) {
			this.length = length; 
		}
		else {
			throw new IllegalFastener("Invalid length"); 
		}
	}
	
	//Assigning a string output
	public String toString() {
		String output; 
		output = length + " long, " + super.toString(); 
		return output; 
	}
	
}
