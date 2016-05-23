package Loading;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class QuadraticFunction implements Function {
	private List<Double> coefficients = new ArrayList<Double>();
	
	public QuadraticFunction(String[] arguments) {
		coefficients.add(0, Double.parseDouble(arguments[0]));
		coefficients.add(1, Double.parseDouble(arguments[1]));
		coefficients.add(2, Double.parseDouble(arguments[2]));
		coefficients.add(3, Double.parseDouble(arguments[3]));
		coefficients.add(4, Double.parseDouble(arguments[4]));
		coefficients.add(5, Double.parseDouble(arguments[5]));
		coefficients.add(6, Double.parseDouble(arguments[6]));
	}
	
	@Override
	public double get(Double value1, Double value2) {
		return (coefficients.get(0) * value1) + (coefficients.get(1) * Math.pow(value1, 2) * value2) + 
				(coefficients.get(2) * value1 * value2) + (coefficients.get(3) * value1 * Math.pow(value2, 2)) + 
				(coefficients.get(4) * Math.pow(value2, 2)) + (coefficients.get(5) * Math.pow(value1, 2) * Math.pow(value2, 2)) + coefficients.get(6); 
	}

}
