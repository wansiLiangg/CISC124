/*
 * This class is checking if the finish is valid and passing diameter, material, finish, price, and unit to the Threaded class. 
 */
public class InnerThreaded extends Threaded {

	private static final long serialVersionUID = 1L;

	//Passing diameter, material, finish, price, and unit to the Threaded class
	public InnerThreaded(String diameter, String material, String finish, double price, int unit) throws IllegalFastener {
		super(diameter, material, finish, price, unit); 
		checkFinish(finish, material); 
	}
	
	//Checking if the finish is valid
	private void checkFinish(String finish, String material) throws IllegalFastener{
		String[] legalFinish = {"Chrome", "Hot Dipped Galvanized", "Plain", "Yellow Zinc", "Zinc"}; 
		if (material.equalsIgnoreCase("Steel")) {
			if (!inArray(legalFinish, finish)) {
				throw new IllegalFastener("Illegal finish"); 
			}
		}
		else if (!finish.equalsIgnoreCase("Plain")) {
				throw new IllegalFastener("Invalid finish"); 
		}
	}
	
	//Assigning a string output
	public String toString() {
		String output; 
		output = super.toString(); 
		return output; 
	}
	
}
