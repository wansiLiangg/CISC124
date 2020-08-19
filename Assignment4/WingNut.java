/*
 * This class is passing diameter, material, finish, price, and unit to the InnerThreaded class
 */
public class WingNut extends InnerThreaded {
	
	private static final long serialVersionUID = 1L;

	//Passing diameter, material, finish, price, and unit to the InnerThreaded class
	public WingNut(String diameter, String material, String finish, double price, int unit) throws IllegalFastener {
		super(diameter, material, finish, price, unit); 		
	}	
	
	//Assigning a string output
	public String toString() {
		String output; 
		output = "Wing Nut, " + super.toString(); 
		return output; 
	}
}
