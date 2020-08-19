
import java.io.Serializable;

/**
 * The pizza class is for users to design their pizza
 */
public class Pizza implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * The method is a constructor defaults the pizza as a small pizza with single cheese and ham
	 * 
	 * @throws IllegalPizza
	 */
	public Pizza() throws IllegalPizza {
		this("small", "single", "none", "none", "single"); 
	}
	
	private String size; 
	private String cheese;  
	private String pineapple; 
	private String greenPepper; 
	private String ham;
	
	/**
	 * The method is getting the size, cheese, pineapple, green pepper, and ham of the pizza
	 * 
	 * @param size -- small, medium, or large
	 * @param cheese -- single, double, or triple
	 * @param pineapple -- single or none
	 * @param greenPepper -- single or none
	 * @param ham -- single or none
	 * @throws IllegalPizza
	 */
	public Pizza(String size, String cheese, String pineapple, String greenPepper, String ham) throws IllegalPizza {
		size(size); 
		cheese(cheese); 
		ham(ham); 
		pineapple(pineapple); 
		greenPepper(greenPepper); 
		if (this.ham.equals("none")) {
			if (!this.pineapple.equals("none") || !this.greenPepper.equals("none")) {
				throw new IllegalPizza("You do not have ham, so you cannot have pineapple and green pepper");
			}
		}
	}
	
	private void size(String size) throws IllegalPizza {
		if (size == null) {
			throw new IllegalPizza("Size is not provided"); 
		}
		size = size.toLowerCase(); 
		if (size.equals("small") || size.equals("medium") || size.equals("large")) {
			this.size = size; 
		}
		else {
			throw new IllegalPizza("You have entered an invalid size"); 
		}
	}
	
	private void cheese(String cheese) throws IllegalPizza {
		if (cheese == null) {
			throw new IllegalPizza("Cheese is not provided"); 
		}
		cheese = cheese.toLowerCase(); 
		if (cheese.equals("single") || cheese.equals("double") || cheese.equals("triple")) {
			this.cheese = cheese; 
		}
		else {
			throw new IllegalPizza("You have entered an invalid cheese"); 
		}
	}
	
	private void pineapple(String pineapple) throws IllegalPizza {
		if (pineapple == null) {
			throw new IllegalPizza("Pineapple is not provided"); 
		}
		pineapple = pineapple.toLowerCase(); 
		if (pineapple.equals("single") || pineapple.equals("none")) {
			this.pineapple = pineapple; 
		}
		else {
			throw new IllegalPizza("You have entered an invalid pineapple"); 
		}
	}
	
	private void greenPepper(String greenPepper) throws IllegalPizza {
		if (greenPepper == null) {
			throw new IllegalPizza("Green pepper is not provided"); 
		}
		greenPepper = greenPepper.toLowerCase(); 
		if (greenPepper.equals("single") || greenPepper.equals("none")) {
			this.greenPepper = greenPepper; 
		}
		else {
			throw new IllegalPizza("You have entered an invalid green pepper"); 
		}
	}
	
	private void ham(String ham) throws IllegalPizza {
		if (ham == null) {
			throw new IllegalPizza("Ham is not provided"); 
		}
		ham = ham.toLowerCase(); 
		if (ham.equals("single") || ham.equals("none")) {
			this.ham = ham; 
		}
		else {
			throw new IllegalPizza("You have entered an invalid ham"); 
		}
	}
	
	/**
	 * The method is calculating the price of the user designed pizza
	 * 
	 * @return the price of the pizza
	 */
	public double getCost() {
		double costs = sizeCost(size); 
		costs = costs + cheeseCost(cheese) + topping(pineapple) + topping(greenPepper) + topping(ham); 
		return costs; 
	}
	
	private double sizeCost(String size) {
		if (size.equals("small")) {
			return 7; 
		}
		else if (this.size.equals("medium")) {
			return 9; 
		}
		return 11; 
	}
	
	private double cheeseCost(String cheese) {
		if (cheese.equals("single")) {
			return 0; 
		}
		else if (cheese.equals("double")) {
			return 1.5; 
		}
		return 3; 
	}
	
	private double topping(String topping) {
		if (topping.equals("none")) {
			return 0; 
		}
		return 1.5; 
	}
	
	/**
	 * The method is presenting the output of what kind of pizza did users design
	 * 
	 * @return the result of the style of the pizza
	 */
	public String toString() {
		String output;
		output = size + " pizza, " + cheese + " cheese"; 
		if (!pineapple.equals("none")) {
			output = output + ", pineapple"; 
		}
		if (!greenPepper.equals("none")) {
			output = output + ", green pepper"; 
		}
		if (!ham.equals("none")) {
			output = output + ", ham"; 
		}
		output = output + ". Cost: $" + String.format("%.2f", getCost()) + " each."; 
		return output; 
	}
	
	/**
	 * The method can modify the style of the pizza
	 */
	public Pizza clone() {
		Pizza pizzaCopy = null; 
		try {
			pizzaCopy = new Pizza(size, cheese, pineapple, greenPepper, ham); 
		}
		catch (IllegalPizza e) {
			return null; 
		}
		return pizzaCopy; 
	}
	
	/**
	 * The method is comparing the current pizza style with the pizza users provided. 
	 */
	public boolean equals(Object otherPizza) {
		if (otherPizza instanceof Pizza) {
			Pizza otherP = (Pizza)otherPizza; 
			if (size.equals(otherP.size) && cheese.equals(otherP.cheese) && pineapple.equals(otherP.pineapple) && greenPepper.equals(otherP.pineapple) && ham.equals(otherP.ham)) {
				return true; 
			}
		}
		return false; 
	}
}
