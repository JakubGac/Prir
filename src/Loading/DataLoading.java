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
			function = new LinearFunction(read.nextLine().split(" ")); 
			break;
		case 2:
			System.out.println("Podaj współczynniki a,b,c,d,e,f,g funkcji kwadratowej: ax^2 + bx^2y + cxy + dxy^2 + ey^2 + fx^2y^2 + g:");
			function = new QuadraticFunction(read.nextLine().split(" "));
			break;
		}
		
		return function;
	}
}
