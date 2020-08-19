/*
 * The program is used for calculating pi with different approaches. 
 * 
 * Author: Wansi Liang
 * Student number: 20067725
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assn2_17wl {

    // Used to count iterations
    public static int count;
    // For screen input
    private static Scanner screenInput = new Scanner(System.in);

    // Setting the range for methods
    public static int range = 100000; 
    
    //Using the Leibniz formula with floats
    public static double piCalculatorLeibniz() {
    	double pi = 0.0f;
    	double denominator = 1.0f;
    	int sign = 1; 
    	
    	while (denominator <= range) {
    		if (sign == 1) {
    			pi = (float)(pi + 1/denominator); 
    			sign = -1; 
    		}
    		else {
    			pi = (float)(pi - 1/denominator); 
    			sign = 1; 
    		}
    		denominator = (float)(denominator + 2); 
    		count = count + 1; 
    	}
    	pi = (pi * 4); 
    	return pi; 
    }
    
    //Using the arctan formula with floats
    public static double arcTanPiCalculatorFloat() {
    	double pi = 0.0f;
    	double denominator = 1.0f;
    	int sign = 1; 
    	
    	while (denominator <= range) {
    		if (sign == 1) {
    			pi = (float)(pi + (Math.pow(1,denominator))/denominator); 
    			sign = -1; 
    		}
    		else {
    			pi = (float)(pi - (Math.pow(1,denominator))/denominator); 
    			sign = 1; 
    		}
    		denominator = (float)(denominator + 2); 
    		count = count + 1; 
    	}
    	pi = pi * 4; 
    	return pi; 
    	
    }
    
    //Using the arctan formula with double
    public static double arcTanPiCalculatorDouble() {
    	double pi = 0;
    	double denominator = 1;
    	int sign = 1; 
    	
    	while (denominator <= range) {
    		if (sign == 1) {
    			pi = (double)(pi + (Math.pow(1,denominator))/denominator); 
    			sign = -1; 
    		}
    		else {
    			pi = (double)(pi - (Math.pow(1,denominator))/denominator); 
    			sign = 1; 
    		}
    		denominator = (double)(denominator + 2); 
    		count = count + 1; 
    	}
    	pi = pi * 4; 
    	return pi; 
    }
    
    //Using summation improvement technique for arctan formula
    public static double arcTanPiCalculatorDoubleModified() {
		double pi = 4 * (8 * countArcTanPiCalculatorDoubleModified((double) 1 / 10) - 4 * countArcTanPiCalculatorDoubleModified((double)1 / 515)
				- countArcTanPiCalculatorDoubleModified((double) 1 / 239));
    	return pi; 
    }
    //Calculating the arctan formula values for the summation improvement technique 
    public static double countArcTanPiCalculatorDoubleModified(double x) {
    	double countArcTan = 0; 
		double denominator = 1;
		int sign = 1;
		double zeroNeg = 1;
		double zeroPos = 1;
		double countNeg = 0;
		double countPos = 0;
		double sumArcTan = 0;
		
		while (!(countNeg == zeroNeg && countPos == zeroPos)) {
			zeroNeg = countNeg;
			zeroPos = countPos;
			
			if (sign == 1) {
				countArcTan = (double) (Math.pow(x, denominator) / denominator);
				countPos = countPos + countArcTan;
				sign = -1; 
			} else {
				countArcTan = (double) (Math.pow(x, denominator) / denominator);
				countNeg = countNeg + countArcTan;
				sign = 1; 
			}
			denominator = (double)(denominator + 2); 
			count = count + 1; 
		} 
		sumArcTan = countPos - countNeg;
		return sumArcTan;
    }
    
    //Using the BBP formula with a double
    public static double piCalculatorBBP() {
    	double pi = 0; 
    	double k = 0;
    	
    	while (k < range) {
    		pi = pi + (1/(Math.pow(16, k)))*(4/(8*k+1)-2/(8*k+4)-1/(8*k+5)-1/(8*k+6)); 
    		k=k+1; 
    		count = count + 1; 
    	}
    	return pi; 
    }
    
    //Using the BBP formula with a BigDecimal
    public static BigDecimal piCalculatorBBPBig(int scale) {
    	BigDecimal pi = new BigDecimal(0); 
    	int k = 0; 
    	RoundingMode digits = RoundingMode.HALF_EVEN; 
    	    	
    	while (k < range) {
    		int eightK = 8*k; 
    		BigDecimal formula = calculate(scale, digits, eightK, k); 
    		pi = pi.add(formula); 
    		k = k + 1; 
    		count = count + 1; 
    	}
    	return pi; 
    }
    
    public static BigDecimal calculate(int scale, RoundingMode digits, int eightK, int k) {
    	BigDecimal secondOne = new BigDecimal(4).divide(new BigDecimal(eightK+1), scale, digits);
		BigDecimal secondTwo = new BigDecimal(2).divide(new BigDecimal(eightK+4), scale, digits);
		BigDecimal secondThree = new BigDecimal(1).divide(new BigDecimal(eightK+5), scale, digits);
		BigDecimal secondFour = new BigDecimal(1).divide(new BigDecimal(eightK+6), scale, digits);
		BigDecimal secondPart = secondOne.subtract(secondTwo).subtract(secondThree).subtract(secondFour);
		BigDecimal formula = secondPart.divide(new BigDecimal(16).pow(k), scale, digits); 
		return formula; 
    }

    // Aids in displaying BigDecimal numbers to the screen using 100
    // digits per line.
    public static void displayResult(BigDecimal aNum) {
    	var asString = aNum.toString();
    	for(int i = 0; i < asString.length(); i++) {
    		System.out.print(asString.charAt(i));
    		if (i > 0 && (i + 1) % 100 == 0)
    			System.out.println();
    	}
    	System.out.println();
    } // end displayResult
    
    // Simplifies reporting the execution time and the number of iterations
    public static void timeIterationsReport(long start) {
        long finishTime = System.nanoTime();
        long diff = finishTime - start;
        if (diff <= 1e3)
            System.out.print("Took " + diff + " nanosec., ");
        else if (diff <= 1e6)
            System.out.print("Took " + Math.round(diff / 10.0) / 100.0 + " microsec. ");
        else if (diff <= 1e9)
        	System.out.print("Took " + Math.round(diff / 1e4) / 100.0 + " millisec. ");
        else
        	System.out.print("Took " + Math.round(diff / 1e7) / 100.0 + " sec. ");
        System.out.println("and required " + count + " iterations.");
        count = 0;
    } // end timeReport
    
    // Used to calculate and display the accuracy of a 16 digit result using the value of
    // pi stored in the Math class.
    public static void accuracyReport(double estimate) {
    	var error = 100 * (estimate - Math.PI) / Math.PI;
    	System.out.printf("Error is %.2e percent.\n\n", error);
    } // end accuracyReport

    // Copied from IOHelper (only method needed)
    public static int getInt(int low, String prompt, int high) {
        int numFromUser = 0;
        String dummy;
        boolean numericEntryOK;
        do {
            System.out.print(prompt);
            numericEntryOK = false;
            try {
                numFromUser = screenInput.nextInt();
                numericEntryOK = true;
            } catch (InputMismatchException e) {
                dummy = screenInput.nextLine();
                System.out.println(dummy + " is not an integer!");
                numFromUser = low;
            } // end try-catch
            // Indicate to the user why he is being prompted again.
            if (numFromUser < low || numFromUser > high) {
                System.out.println("The number is outside the legal limits.");
            }
        } while (!numericEntryOK || numFromUser < low || numFromUser > high);
        return numFromUser;
    } // end full parameter getInt method

    // This supplied main method uses assumed method names that you may certainly change.
    public static void main(String[] args) {

        long startTime;
        double estimate;
        int numDigitsDesired;

        System.out.printf("Math.PI is:\n%.16f\n\n", Math.PI);
        
        startTime = System.nanoTime();
        estimate = piCalculatorLeibniz();
        System.out.printf("%.16f - using Leibniz formula with float.\n", estimate);
        timeIterationsReport(startTime);
        accuracyReport(estimate);
        
        startTime = System.nanoTime();
        estimate = arcTanPiCalculatorFloat();
        System.out.printf("%.16f - using arcTan formula with float.\n", estimate);
        timeIterationsReport(startTime);
        accuracyReport(estimate);

        startTime = System.nanoTime();
        estimate = arcTanPiCalculatorDouble();
        System.out.printf("%.16f - using arcTan formula with double.\n", estimate);
        timeIterationsReport(startTime);
        accuracyReport(estimate);

        startTime = System.nanoTime();
        estimate = arcTanPiCalculatorDoubleModified();
        System.out.printf("%.16f - using Modified arcTan formula with double.\n", estimate);
        timeIterationsReport(startTime);
        accuracyReport(estimate);

        startTime = System.nanoTime();
        estimate = piCalculatorBBP();
        System.out.printf("%.16f - using BBP formula with double.\n", estimate);
        timeIterationsReport(startTime);
        accuracyReport(estimate);

        startTime = System.nanoTime();
        System.out.println("Using BBP formula with BigDecimals for 16 digits:");
        var estimateBigD = piCalculatorBBPBig(16);
        System.out.println(estimateBigD);
        timeIterationsReport(startTime);
        accuracyReport(estimateBigD.doubleValue());

        startTime = System.nanoTime();
        System.out.println("Using BBP formula with BigDecimals for 100 digits:");
        System.out.println(piCalculatorBBPBig(100));
        timeIterationsReport(startTime);
        System.out.println();

        numDigitsDesired = getInt(1000, "How many digits do you want to try for? ", 10000);
        
        startTime = System.nanoTime();
        System.out.println("Using BBP formula with BigDecimals for " + numDigitsDesired + " digits:");
        displayResult(piCalculatorBBPBig(numDigitsDesired));
        timeIterationsReport(startTime);
        
        screenInput.close();

    } // end main
    
} // end assignment2


/* Questions
 * Q1: 
 * Math.PI is:
	3.1415926535897930
	
	3.1415753364562990 - using Leibniz formula with float.
	Took 3.15 millisec. and required 50000 iterations.
	Error is -5.51e-04 percent.
	
	3.1415753364562990 - using arcTan formula with float.
	Took 4.61 millisec. and required 50000 iterations.
	Error is -5.51e-04 percent.
	
	3.1415726535897814 - using arcTan formula with double.
	Took 4.74 millisec. and required 50000 iterations.
	Error is -6.37e-04 percent.
	
	3.1415926535897930 - using Modified arcTan formula with double.
	Took 155.36 microsec. and required 19 iterations.
	Error is 0.00e+00 percent.
	
	3.1415926535897930 - using BBP formula with double.
	Took 9.47 millisec. and required 100000 iterations.
	Error is 0.00e+00 percent.
	
	Using BBP formula with BigDecimals for 16 digits:
	3.1415926535897933
	Took 720.99 millisec. and required 100000 iterations.
	Error is 0.00e+00 percent.
	
	Using BBP formula with BigDecimals for 100 digits:
	3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170678
	Took 663.65 millisec. and required 100000 iterations.
	
	How many digits do you want to try for? 1500
	Using BBP formula with BigDecimals for 1500 digits:
	3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706
	7982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381
	9644288109756659334461284756482337867831652712019091456485669234603486104543266482133936072602491412
	7372458700660631558817488152092096282925409171536436789259036001133053054882046652138414695194151160
	9433057270365759591953092186117381932611793105118548074462379962749567351885752724891227938183011949
	1298336733624406566430860213949463952247371907021798609437027705392171762931767523846748184676694051
	3200056812714526356082778577134275778960917363717872146844090122495343014654958537105079227968925892
	3542019956112129021960864034418159813629774771309960518707211349999998372978049951059731732816096318
	5950244594553469083026425223082533446850352619311881710100031378387528865875332083814206171776691473
	0359825349042875546873115956286388235378759375195778185778053217122680661300192787661119590921642019
	8938095257201065485863278865936153381827968230301952035301852968995773622599413891249721775283479131
	5155748572424541506959508295331168617278558890750983817546374649393192550604009277016711390098488240
	1285836160356370766010471018194295559619894676783744944825537977472684710404753464620804668425906949
	1293313677028989152104752162056966024058038150193511253382430035587640247496473263914199272604269922
	7967823547816360093417216412199245863150302861829745557067498385054945885869269956909272107975093029
	67
	Took 3.49 sec. and required 100000 iterations.


 * Q2: Technique 1 would be better because based one the same output of pi, technique 1 took less time than technique 2. 
 * Q3: Because the differences between float's outputs and double's outputs do not have huge different. 
 * Q4: Technique 3 would be better because the error percentage of technique 3 is smaller than technique 2, and technique 3 took less time than technique 2.
 * Q5: Yes. Use the RamanujanSum algorithm can improve the accuracy of the outputs. 
 * Q6: Technique 5 would be better because the error percentage of technique 5 is 0 that is much smaller than technique 3's. 
 * Q7: The accuracy of bigdecimal's pi is much higher than double's. 
 */

