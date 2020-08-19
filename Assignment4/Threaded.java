/*
 * This class is checking if material is valid, and assigning the value of diameter if it is valid. 
 * Also, this class is passing material, finish, price, and unit to the Fastener class. 
 */
public class Threaded extends Fastener {

	private static final long serialVersionUID = 1L;
	
	private String diameter; 
	
	//Passing material, finish, price, and unit to the Fastener class
	public Threaded(String diameter, String material, String finish, double price, int unit) throws IllegalFastener {
		super(material, finish, price, unit); 
		checkDiameter(diameter); 
		checkMaterial(material); 
	}
	
	//Assigning the value of diameter if it is valid
	private void checkDiameter(String diameter) throws IllegalFastener{
		String[] legalDiameter = {"#8-13", "#8-15", "#8-32", "#10-13", "#10-24", "#10-32", "1/4-20", "5/16-18", "3/8-16", "7/16-14", "1/2-13", "5/8-11", "3/4-10"}; 
		if (!inArray(legalDiameter, diameter)) {
			throw new IllegalFastener("Illegal point"); 
		}
		this.diameter = diameter; 
	}
	
	//Checking if material is valid
	private void checkMaterial(String material) throws IllegalFastener{
		String[] legalMaterial = {"Brass", "Stainless Steel", "Steel"}; 
		if (!inArray(legalMaterial, material)) {
			throw new IllegalFastener("Illegal point"); 
		}
	}
	
	//Assigning a string output
	public String toString() {
		String output; 
		output = diameter + " thread, " + super.toString(); 
		return output; 
	}
}
