package Loading;

import java.util.Scanner;
import Area.Area;
import Area.Square;
import Area.Rectangle;
import Area.LetterL;
import Area.LetterT;

public class DataLoading {
	private Scanner read;
	private Function function;
	private Area area;
	private String[] dimensions;
	
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
			default:
				System.out.println("Wybrałeś nieprawidłową wartość. Musisz zacząć od nowa.");
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
			System.out.println("Wybrałeś nieprawidłową wartość. Musisz zacząć od nowa.");	
		}
		
		return function;
	}

	public Area AreaLoading(){
		System.out.print("Wybierz kształt rozpatrywanego obszaru:\n"
				+ "0 - kwadrat\n"
				+ "1 - prostokąt\n"
				+ "2 - litera L\n"
				+ "3 - litera T\n");
		switch(Integer.parseInt(read.nextLine())){
		case 0:
			System.out.println("Podaj długość boku kwadratu oraz odległość między punktami:");
			dimensions = read.nextLine().split(" ");
			area = new Square(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
			break;
		case 1:
			System.out.println("Podaj długości boków prostokąta oraz odległośc między punktami:");
			dimensions = read.nextLine().split(" ");
			area = new Rectangle(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]),Integer.parseInt(dimensions[2]));
			break;
		case 2:
			System.out.print("Podaj wymiary zaznaczone na rysunku literami a, b, c, d oraz odległośc między punktami:\n" +
			"	\u2665 \u2665 \u2665\n" +
			"	\u2665 \u2665 \u2665 c\n" +
			"      a \u2665 \u2665 \u2665   d\n" +
			"	\u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
			"	\u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
			"	\u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
			"	     b \n"); 
			dimensions = read.nextLine().split(" ");
			if( (Integer.parseInt(dimensions[1]) - Integer.parseInt(dimensions[3]) < 1) || 
					((Integer.parseInt(dimensions[0]) - Integer.parseInt(dimensions[2]) < 1)) ) {
				System.out.println("Błędne wymiary!\n");
				System.exit(1);
			}
			area = new LetterL(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]),
					Integer.parseInt(dimensions[2]), Integer.parseInt(dimensions[3]), Integer.parseInt(dimensions[4]));
			break;
		case 3:
			System.out.print("Podaj wymiary zaznaczone na rysunku literami a, b, c,d oraz odległość między punktami:\n" +
					"	     a\n" +
					"	\u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
					"	\u2665 \u2665 \u2665 \u2665 \u2665 \u2665\n" +
					"	\u2665 \u2665 \u2665 \u2665 \u2665 \u2665 b\n" +
					"	    \u2665 \u2665\n" +
					"	    \u2665 \u2665 c\n" +
					"	    \u2665 \u2665\n" +
					"	     d\n"); 
			dimensions = read.nextLine().split(" ");
			if( (Integer.parseInt(dimensions[0]) - Integer.parseInt(dimensions[3]) < 2) || 
				((Integer.parseInt(dimensions[1]) - Integer.parseInt(dimensions[2]) < 1)) ) {
					System.out.println("Błędne wymiary!\n");
					System.exit(1);
			}
			area = new LetterT(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]),
							Integer.parseInt(dimensions[2]), Integer.parseInt(dimensions[3]), Integer.parseInt(dimensions[4]));
			break;
		default:
			System.out.println("Wybrałeś nieprawidłową wartość. Musisz zacząć od nowa.");
		}
		return area;
	}
	
}
