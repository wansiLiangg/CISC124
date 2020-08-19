
/**
 * A exception class for all illegal pizza from Pizza class and LineItem class
 */

public class IllegalPizza extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * The method is used to receive error messages from Pizza class and LineItem class
	 * 
	 * @param message
	 */
	public IllegalPizza(String message) {
		super(message); 	
	}
}
