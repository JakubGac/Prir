package Loading;

import java.util.ArrayList;
import java.util.List;

public class LinearFunction implements Function {
	private List<Double> coefficients = new ArrayList<Double>();
	
	public LinearFunction(String[] arguments) {
		coefficients.add(0, Double.parseDouble(arguments[0]));
		coefficients.add(1, Double.parseDouble(arguments[1]));
		coefficients.add(2, Double.parseDouble(arguments[2]));
		coefficients.add(3, Double.parseDouble(arguments[3]));
	}
	
	@Override
	public double get(Double value1, Double value2) {
		return (coefficients.get(0) * value1) +
				(coefficients.get(1) * value1 * value2) +
				(coefficients.get(2) * value2) + coefficients.get(3);
	}
	
	@Override
	public String toString(){
		return "I'm linear function baby\n";
	}
}
