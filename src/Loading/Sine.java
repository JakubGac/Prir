package Loading;

import java.lang.Math;

public class Sine implements Function {

	@Override
	public double get(Double value1, Double value2) {
		return Math.sin(value1 + value2);
	}
	
}
