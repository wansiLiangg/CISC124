/*
 * This class is passing length, diameter, material, finish, price, and unit to the Bolt class
 */
public class CarriageBolt extends Bolt {

	private static final long serialVersionUID = 1L;

	//Passing length, diameter, material, finish, price, and unit to the Bolt class
	public CarriageBolt(double length, String diameter, String material, String finish, double price, int unit) throws IllegalFastener {
		super(length, diameter, material, finish, price, unit); 
	}
	
	//Assigning a string output
	public String toString() {
		String output; 
		output = "Carriage Bolt, " + super.toString(); 
		return output; 
	}
	
}
