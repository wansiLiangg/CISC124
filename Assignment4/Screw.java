/*
 * This class is assigning the value of head and drive if they are valid, and checking if finish is valid
 * Also, this class is passing length, diameter, material, finish, price, and unit to the OuterThreaded class
 */
public class Screw extends OuterThreaded {

	private static final long serialVersionUID = 1L;
	
	private String head; 
	private String drive; 
	
	//Passing length, diameter, material, finish, price, and unit to the OuterThreaded class
	public Screw (double length, String diameter, String material, String finish, String head, String drive, double price, int unit) throws IllegalFastener {
		super(length, diameter, material, finish, price, unit); 
		checkHead(head); 
		checkDrive(drive);
		checkFinish(finish, material); 
	}
	
	//Assigning the value of head if it is valid
	private void checkHead(String head) throws IllegalFastener {
		String[] legalHead = {"Bugle", "Flat", "Oval", "Pan", "Round"}; 
		if (!inArray(legalHead, head)) {
			throw new IllegalFastener("Illegal head"); 
		}
		this.head = head; 
	}
	
	//Assigning the value of drive if it is valid
	private void checkDrive(String drive) throws IllegalFastener {
		String[] legalDrive = {"6-Lobe", "Philips", "Slotted", "Square"}; 
		if (!inArray(legalDrive, drive)) {
			throw new IllegalFastener("Illegal drive"); 
		}
		this.drive = drive; 
	}
	
	//Checking if finish is valid
	private void checkFinish(String finish, String material) throws IllegalFastener{
		String[] legalFinish = {"Hot Dipped Galvanized", "Plain", "Yellow Zinc", "Zinc", "Balck Phosphate", "ACQ 1000 Hour", "Lubricated"}; 
		if (material.equalsIgnoreCase("Steel")) {
			if (!inArray(legalFinish, finish)) {
				throw new IllegalFastener("Illegal finish"); 
			}
		}
		else {
			if (!finish.equalsIgnoreCase("Plain")) {
				throw new IllegalFastener("Invalid finish"); 
			}
		}
	}
	
	//Assigning a string output
	public String toString() {
		String output; 
		output = head + " head, " + drive + " drive, " + super.toString(); 
		return output; 
	}
	
	
}
