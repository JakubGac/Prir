package Loading;

import java.util.ArrayList;
import java.util.List;

public class LinearFunction implements Function {
	private List<Double> coefficients = new ArrayList<Double>();
	
	public LinearFunction(double a, double b, double c, double d) {
		coefficients.add(0, a);
		coefficients.add(1, b);
		coefficients.add(2, c);
		coefficients.add(3, d);
	}
	
	@Override
	public double get(Double value1, Double value2) {
		return (coefficients.get(0) * value1) +
				(coefficients.get(1) * value1 * value2) +
				(coefficients.get(2) * value2) + coefficients.get(3);
	}
}
