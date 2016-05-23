package Loading;

import java.util.Scanner;

public class DataLoading {
	private Scanner read;
	private Function function;
	
	public DataLoading(){
		read = new Scanner(System.in);
	}
	
	public Function FunctionLoading() {	
		System.out.print(
			"0 - funkcja trygonometryczna\n" +
			"1 - funkcja liniowa\n" +
			"2 - funkcja kwadratowa\n"
		);
		
		switch(read.nextInt()){
		case 0:
			System.out.print(
				"0 - sinus\n" +
				"1 - cosinus\n"
			);
			switch(read.nextInt()){
			case 0:
				function = new Sine();
				break;
			case 1:
				function = new Cosine();	
				break;
			}
			break;
		case 1:
			
			break;
		case 2:
			
			break;
		}
		
		return function;
	}
}
