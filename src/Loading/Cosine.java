package Loading;

import java.lang.Math;

public class Cosine implements Function {

	@Override
	public double get(Double value1, Double value2) {
		return Math.cos(value1 + value2);
	}

	@Override
	public String toString(){
		return "I'm sine baby\n";
	}
}
