package Loading;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Area.Area;
import Area.Square;
import Area.Rectangle;
import Area.LetterL;
import Area.LetterT;
import Condition.*;
import Matrix.*;

public class DataLoading {
	private Scanner read;
	private Function function;
	private Area area;
	private String[] tmpArray;
	private List<Condition> conditions;
	
	public DataLoading(){
		read = new Scanner(System.in);
	}
	
	public void FunctionLoading() {	
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
			default:
				System.out.println("Wybrałeś nieprawidłową wartość. Musisz zacząć od nowa.");
				System.exit(1);
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
		default:
			System.out.println("Wybrałeś nieprawidłową wartość. Musisz zacząć od nowa.\n");
			System.exit(1);
		}
	}

	public void AreaLoading(){
		System.out.print("Wybierz kształt rozpatrywanego obszaru:\n"
				+ "0 - kwadrat\n"
				+ "1 - prostokąt\n"
				+ "2 - litera L\n"
				+ "3 - litera T\n");
		switch(Integer.parseInt(read.nextLine())){
		case 0:
			System.out.println("Podaj długość boku kwadratu(wymiar a) oraz odległość między punktami:");
			printSquare();
			tmpArray = read.nextLine().split(" ");
			area = new Square(Integer.parseInt(tmpArray[0]), Integer.parseInt(tmpArray[1]));
			CreateMatrix.setSize(Integer.parseInt(tmpArray[0]));
			break;
		case 1:
			System.out.println("Podaj długości boków prostokąta(wymiary a i b) oraz odległośc między punktami:");
			printRectangle();
			tmpArray = read.nextLine().split(" ");
			area = new Rectangle(Integer.parseInt(tmpArray[0]), Integer.parseInt(tmpArray[1]),Integer.parseInt(tmpArray[2]));
			CreateMatrix.setSize(Integer.parseInt(tmpArray[0]));
			break;
		case 2:
			System.out.print("Podaj wymiary zaznaczone na rysunku literami a, c, d, f oraz odległośc między punktami:\n");
			printLetterL();
			tmpArray = read.nextLine().split(" ");
			if( (Integer.parseInt(tmpArray[1]) - Integer.parseInt(tmpArray[3]) < 1) || 
					((Integer.parseInt(tmpArray[0]) - Integer.parseInt(tmpArray[2]) < 1)) ) {
				System.out.println("Błędne wymiary!\n");
				System.exit(1);
			}
			area = new LetterL(Integer.parseInt(tmpArray[0]), Integer.parseInt(tmpArray[1]),
					Integer.parseInt(tmpArray[2]), Integer.parseInt(tmpArray[3]), Integer.parseInt(tmpArray[4]));
			CreateMatrix.setSize(Integer.parseInt(tmpArray[0]));
			break;
		case 3:
			System.out.print("Podaj wymiary zaznaczone na rysunku literami b,c,e, f oraz odległość między punktami:\n");
			printLetterT();
			tmpArray = read.nextLine().split(" ");
			if( (Integer.parseInt(tmpArray[0]) - Integer.parseInt(tmpArray[3]) < 2) || 
				((Integer.parseInt(tmpArray[1]) + Integer.parseInt(tmpArray[2]) - Integer.parseInt(tmpArray[2]) < 1)) ) {
					System.out.println("Błędne wymiary!\n");
					System.exit(1);
			}
			area = new LetterT(Integer.parseInt(tmpArray[0]), Integer.parseInt(tmpArray[1]) + Integer.parseInt(tmpArray[2]),
							Integer.parseInt(tmpArray[2]), Integer.parseInt(tmpArray[3]), Integer.parseInt(tmpArray[4]));
			CreateMatrix.setSize(Integer.parseInt(tmpArray[0]));
			break;
		default:
			System.out.println("Wybrałeś nieprawidłową wartość. Musisz zacząć od nowa.");
			System.exit(1);
		}
	}

	public void ConditionLoading(){
		if(area instanceof Square) {
			System.out.println("Podaj warunki brzegowe dla boków a, b, c, d\n" +
					"przykład: warunek Dirichleta dla x o wartości 4, wpisz dx4\n" + 
					"przykład: warunek Von neu Manna dla y o wartości 2, wpisz vy2\n");
			printSquare();
			readConditions();
        } else if(area instanceof Rectangle){
        	System.out.println("Podaj warunki brzegowe dla boków a, b, c, d\n" +
					"przykład: warunek Dirichleta dla x o wartości 4, wpisz dx4\n" + 
					"przykład: warunek Von neu Manna dla y o wartości 2, wpisz vy2\n");
			printRectangle();
			readConditions();	
        } else if(area instanceof LetterL) {
        	System.out.println("Podaj warunki brzegowe dla boków a, b, c, d, e, f\n" +
					"przykład: warunek Dirichleta dla x o wartości 4, wpisz dx4\n" + 
					"przykład: warunek Von neu Manna dla y o wartości 2, wpisz vy2\n");
			printLetterL();
			readConditions();
        } else {
        	System.out.println("Podaj warunki brzegowe dla boków a, b, c, d, e, f, g, h\n" +
					"przykład: warunek Dirichleta dla x o wartości 4, wpisz dx4\n" + 
					"przykład: warunek Von neu Manna dla y o wartości 2, wpisz vy2\n");
			printLetterT();
			readConditions();
        }
	}
	
	public Function getFunction(){
		return function;
	}

	public Area getArea(){
		return area;
	}

	public List<Condition> getConditionsList(){
		return conditions; 
	}
	
	private void readConditions(){
		tmpArray = read.nextLine().split(" ");
		conditions = new ArrayList<Condition>();
		for(String condition: tmpArray){
			if(condition.charAt(0) == 'd' || condition.charAt(0) == 'D'){
				conditions.add(new Dirichlet(condition));
			} else {
				conditions.add(new Von_Neumann());
			}
		}
	}
	
	private void printSquare(){
		System.out.print(
				"      b\n" +
				"  \u2665 \u2665 \u2665 \u2665 \u2665\n" +
				"a \u2665 \u2665 \u2665 \u2665 \u2665  c\n" +
				"  \u2665 \u2665 \u2665 \u2665 \u2665\n" +
				"  \u2665 \u2665 \u2665 \u2665 \u2665\n" +
				"      d\n");
	}
	
	private void printRectangle(){
		System.out.print(
			"        b\n" +
			"  \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
			"a \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 c\n" +
			"  \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
			"  \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" + 
			"        d\n");	
	}
	
	private void printLetterL(){
		System.out.print(
				"     b\n" +
				"  \u2665 \u2665 \u2665\n" +
				"  \u2665 \u2665 \u2665 c\n" +
				"a \u2665 \u2665 \u2665   d\n" +
				"  \u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
				"  \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 e\n" +
				"  \u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
				"       f \n");
	}
	
	private void printLetterT(){
		System.out.println(
			"          b\n" +
			"  \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
			"a \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 c\n" +
			"  \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
			"  \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
			"    h   \u2665 \u2665   d\n" +
			"        \u2665 \u2665\n" +
			"      g \u2665 \u2665 e\n" +
			"        \u2665 \u2665\n" +
			"        \u2665 \u2665\n" +
			"         f\n"); 
		
	}
}