/*
 * This class is assigning the value of finish, price, unit, and material if they are valid
 * Also, this class includes a getCost method and two value checking methods. 
 */
import java.io.Serializable;

public class Fastener implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String finish; 
	private double price; 
	private int unit; 
	private String material;
	
	//Assigning the value of finish, material, price, and unit
	public Fastener(String material, String finish, double price, int unit) throws IllegalFastener {
		this.finish = finish; 
		this.material = material; 
		checkPrice(price); 
		checkUnit(unit); 
	}
	
	//Assigning the value of price if it is valid
	private void checkPrice(double price) throws IllegalFastener {
		if (price <= 0) {
			throw new IllegalFastener("Illegal price"); 
		}
		this.price = price; 
	}
	
	//Assigning the value of unit if it is valid
	private void checkUnit(int unit) throws IllegalFastener {
		if (unit > 0 && unit <= 10000 && (unit == 1 || unit%5 == 0)) {
			this.unit = unit; 
		}
		else {
			throw new IllegalFastener("Illegal unit"); 
		}
	}
	
	//Assigning a string output
	public String toString() {
		String output; 
		output = material + ", with a " + finish + " finish. " + unit + " in a unit, $" + price + " per unit. "; 
		return output; 
	}
	
	//Calculating the total cost of an order
	public double getOrderCost(int unit) {
		double cost; 
		cost = unit * price; 
		return cost; 
	}
	
	//Checking if a string value is valid
	public boolean inArray(String[] legalInput, String input) {
		int i; 
		for (i=0; i<legalInput.length; i++) {
			if (input.equalsIgnoreCase(legalInput[i])) {
				return true; 
			}
		}
		return false; 
	}
	
	//Checking if a double value is valid
	public boolean inArray(double[] legalInput, double input) {
		int i; 
		for (i=0; i<legalInput.length; i++) {
			if (input == legalInput[i]) {
				return true; 
			}
		}
		return false; 
	}
	
}
