package Prir;

import Loading.DataLoading;
import Loading.Function;
import Area.Area;

public class Main {

	public static void main(String []args) throws Exception {
		// żeby tylko potestować jak działa wczytywanie funkcji 
		Function function;
		Area area;
		
		DataLoading data = new DataLoading();
		
		function = data.FunctionLoading();
		System.out.println(function.get(1.0, 2.0));
		area = data.AreaLoading();
		
	}
}