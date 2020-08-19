/*
 * This class is checking if the point is valid and assign the value of point. 
 * Also, this class is passing length, diameter, material, finish, head, drive, price, and unit to the Screw class. 
 */
public class WoodScrew extends Screw {
	
	private static final long serialVersionUID = 1L;
	
	private String point; 

	//Passing length, diameter, material, finish, head, drive, price, and unit to the Screw class
	public WoodScrew(double length, String diameter, String material, String finish, String head, String drive, String point, double price, int unit) throws IllegalFastener {
		super(length, diameter, material, finish, head, drive, price, unit); 
		checkPoint(point); 
	}
	
	//Assign the value of point if it is valid
	private void checkPoint(String point) throws IllegalFastener {
		String[] legalPoint = {"Double Cut", "Sharp", "Type 17"}; 
		if (!inArray(legalPoint, point)) {
			throw new IllegalFastener("Illegal point"); 
		}
		this.point = point; 
	}
	
	//Assigning a string output
	public String toString() {
		String output; 
		output = "Wood Screw, " + point + " point, "+ super.toString(); 
		return output; 
	}
	
}
