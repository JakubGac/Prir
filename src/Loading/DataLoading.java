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
		
		switch(Integer.parseInt(read.nextLine())){
		case 0:
			System.out.print(
				"0 - sinus\n" +
				"1 - cosinus\n"
			);
			switch(Integer.parseInt(read.nextLine())){
			case 0:
				function = new Sine();
				break;
			case 1:
				function = new Cosine();	
				break;
			}
			break;
		case 1:
			System.out.println("Podaj współczynniki a,b,c,d funkcji liniowej: ax + bxy + cy + d:");
			String[] line = read.nextLine().split(" ");
			function = new LinearFunction(Double.parseDouble(line[0]),Double.parseDouble(line[1]),Double.parseDouble(line[2]),Double.parseDouble(line[3])); 
			break;
		case 2:
			
			break;
		}
		
		return function;
	}
}
