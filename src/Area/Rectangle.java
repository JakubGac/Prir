package Area;

/**
 * Created by Dante on 24.05.2016.
 */
public class Rectangle extends Area {

    private int a;
    private int b;

    public Rectangle(int a, int b, int h) {
        this.a = a;
        this.b = b;
        this.h = h;
        super.fill_this_shit_up(this);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void fill_edges(Point[][] points) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || j == 0 || i == a - 1 || j == b - 1) {
                    points[i][j].setIf_edge(true);
                }
            }
        }
    }

}
