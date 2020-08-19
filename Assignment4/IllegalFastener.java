/*
 * An exception class for all illegal values from Bolt, CarriageBolt, CommonNail, InnerThreaded, Nail, OuterThreaded, Screw, 
 * Threaded, WingNut, WoodScrew, and Fastener class. 
 */

public class IllegalFastener extends Exception {

	private static final long serialVersionUID = 1L;
	
	public IllegalFastener(String message) {
		super(message); 
	}

}
