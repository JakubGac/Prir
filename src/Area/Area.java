package Area;

import java.util.ArrayList;

/**
 * Created by Dante on 23.05.2016.
 */
public abstract class Area {

    protected double h;
    protected Point[][] points;

    protected abstract void fill_edges(Point[][] points);
    
    public abstract ArrayList<Integer> get_sizes_array();

    public double getH() {
        return this.h;
    }

    protected Point[][] fill_this_shit_up(Area area) {

        if(area instanceof Square) {
            System.out.println("kwadrat widze w tym teczu\n");
            Square sq = (Square) area;
            points = new Point[sq.getA()][sq.getA()];
            this.empty_fill(sq.getA(), sq.getA());
            sq.fill_edges(points);

        } else if(area instanceof Rectangle){
            Rectangle re = (Rectangle) area;
            points = new Point[re.getA()][re.getB()];
            this.empty_fill(re.getA(), re.getB());
            re.fill_edges(points);

        } else if(area instanceof LetterL) {
            LetterL ll = (LetterL) area;
            points = new Point[ll.getA()][ll.getF()];
            this.empty_fill(ll.getA(), ll.getF());
            ll.fill_edges(points);

        } else {
            LetterT lt = (LetterT) area;
            points = new Point[lt.getA()][lt.getB()];
            this.empty_fill(lt.getA(), lt.getB());
            lt.fill_edges(points);
        }

        return points;

    }

    private void empty_fill(int a, int b) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                points[i][j] = new Point(i, j);
            }
        }
    }

    public Point getPoint(int i, int j) {
        return points[i][j];
    }
}
