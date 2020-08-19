/*
 * This class is checking if the size, length, gauge, and finish of common nail are valid. 
 * Also, this class is passing size, length, gauge, finish, price, and unit to the Nail class. 
 */
public class CommonNail extends Nail{
	
	private static final long serialVersionUID = 1L;

	//Passing size, length, gauge, finish, price, and unit to the Nail class
	public CommonNail(String size, double length, double gauge, String finish, double price, int unit) throws IllegalFastener {
		super(size, length, gauge, finish, price, unit); 
		checkSize(size); 
		checkLength(length); 
		checkGauge(gauge); 
		checkFinish(finish); 
	}
	
	//Checking if the size is valid
	private void checkSize(String size) throws IllegalFastener {
		String[] legalSize = {"6D", "8D", "10D", "12D", "16D", "60D"}; 
		if (!inArray(legalSize, size)) {
			throw new IllegalFastener("Illegal size"); 
		}
	}
	
	//Checking if the length is valid
	private void checkLength(double length) throws IllegalFastener {
		double[] legalLength = {2, 2.5, 3, 3.25, 3.5, 6}; 
		if (!inArray(legalLength, length)) {
			throw new IllegalFastener("Illegal length"); 
		}
	}
	
	//Checking if the gauge is valid
	private void checkGauge(double gauge) throws IllegalFastener {
		double[] legalGauge = {2, 8, 9, 10.25, 11.5}; 
		if (!inArray(legalGauge, gauge)) {
			throw new IllegalFastener("Illegal gauge"); 
		}
	}
	
	//Checking if the finish is valid
	private void checkFinish(String finish) throws IllegalFastener {
		String[] legalFinish = {"Bright", "Hot Dipped Galvanized"}; 
		if (!inArray(legalFinish, finish)) {
			throw new IllegalFastener("Illegal finish"); 
		}
	}
	
	//Assigning a string output
	public String toString() {
		String output; 
		output = "Common Nail, " + super.toString(); 
		return output; 
	}
	
}
