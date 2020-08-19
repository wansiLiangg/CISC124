
import java.io.Serializable;

/**
 *The LineItem class is used to line up all the pizza orders from higher price to lower price
 */
public class LineItem implements Comparable<LineItem>, Serializable {
	
	private static final long serialVersionUID = 1L;

	private Pizza pizza; 
	private int pizzaNum; 
	
	/**
	 * This method is a constructor defaults a single pizza for the order
	 * 
	 * @param pizza -- the user designed pizza
	 * @throws IllegalPizza
	 */
	public LineItem(Pizza pizza) throws IllegalPizza {
		this(1, pizza); 
	}
	
	/**
	 * This method is getting the number of pizza if the user is not using the default 
	 * 
	 * @param number -- a user input -- the number of pizza 
	 * @param pizza -- a user input -- the user designed pizza
	 * @throws IllegalPizza
	 */
	public LineItem(int number, Pizza pizza) throws IllegalPizza {
		setNumber(number);
		if (pizza == null) {
			throw new IllegalPizza("Illegal pizza!"); 
		}
		this.pizza = pizza; 
	}

	@Override
	public int compareTo(LineItem item) {
		// TODO Auto-generated method stub
		int position; 
		position = (int)(item.getCost() - getCost()); 
		return position; 
	}
	
	/**
	 * This method is getting the style of the pizza from pizza class
	 * 
	 * @return pizza -- the user designed pizza
	 */
	public Pizza getPizza() {
		return pizza; 
	}
	
	/**
	 * The method is getting the number of pizza
	 * 
	 * @return the amount of pizza
	 */
	public int getNumber() {
		 return pizzaNum; 
	}
	
	/**
	 * The method is calculating the price of the total amount of pizza
	 * 
	 * @return the total price of an order
	 */
	public double getCost() {
		double costs; 
		if (pizzaNum >= 10 && pizzaNum <= 20) {
			costs = pizzaNum * (0.9 * pizza.getCost()); 
		}
		else if (pizzaNum > 20) {
			costs = pizzaNum * 0.85 * pizza.getCost(); 
		}
		else {
			costs = pizzaNum * pizza.getCost(); 
		}
		return costs; 
	}
	
	/**
	 * The method is checking if the input of the amount of pizza is out of range
	 * 
	 * @param num -- user input -- the number of pizza the user wants
	 * @throws IllegalPizza
	 */
	public void setNumber(int num) throws IllegalPizza {
		if (num < 1 || num > 100) {
			throw new IllegalPizza("The number is out of range"); 
		}
		pizzaNum = num; 
	}
	
	/**
	 * The method is returning a string output to print out the number of pizza and the style of the pizza
	 * 
	 * @return output -- a string to print out the number of pizza, pizza style, and the price of a pizza
	 */
	public String toString() {
		String output; 
		if (pizzaNum < 10) {
			output = " " + pizzaNum + " " + pizza; 
		}
		else {
			output = pizzaNum + " " + pizza; 
		}
		return output; 
	}
}
