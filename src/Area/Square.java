package Area;

/**
 * Created by Dante on 24.05.2016.
 */
public class Square extends Area {

    private int a;

    public Square( int a, int h) {
        this.a = a;
        this.h = h;
        super.fill_this_shit_up(this);
    }

    public int getA() {
        return a;
    }

    public void fill_edges(Point[][] points) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == 0 || j == 0 || i == a - 1 || j == a - 1) {
                    points[i][j].setIf_edge(true);
                }
            }
        }
    }
}
