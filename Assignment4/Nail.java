/*
 * This class is assigning the value of size, length, and gauge of common nail. 
 * Also, the Nail class is passing material, finish, price, and unit to the Fastener class. 
 */
public class Nail extends Fastener {
	
	private static final long serialVersionUID = 1L;
	
	private String size; 
	private double length; 
	private double gauge; 

	//Assigning the value of size, length, gauge and passing material, finish, price unit as parameters to Fastener class. 
	public Nail(String size, double length, double gauge, String finish, double price, int unit) throws IllegalFastener {
		super("Steel", finish, price, unit); 
		this.size = size; 
		this.length = length; 
		this.gauge = gauge;
	}
	
	//Assigning a string output
	public String toString() {
		String output; 
		output = size + " size, " + length + " long, " + gauge + " gauge, " + super.toString();
		return output; 
	}
	
}
