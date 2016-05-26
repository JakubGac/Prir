package Area;

/**
 * Created by Dante on 23.05.2016.
 */
public abstract class Area {

    protected int h;
    protected Point[][] points;

    protected abstract void fill_edges(Point[][] points);


    protected Point[][] fill_this_shit_up(Area area) {

        if(area instanceof Square) {
            Square sq = (Square) area;
            points = new Point[sq.getA()][sq.getA()];
            this.empty_fill(sq.getA(), sq.getA());
            sq.fill_edges(points);

        } else if(area instanceof Rectangle){
            Rectangle re = (Rectangle) area;
            points = new Point[re.getA()][re.getB()];
            this.empty_fill(re.getA(), re.getB());

        } else if(area instanceof LetterL) {
            LetterL ll = (LetterL) area;
            points = new Point[ll.getA()][ll.getB()];
            this.empty_fill(ll.getA(), ll.getB());

        } else {
            LetterT lt = (LetterT) area;
            points = new Point[lt.getA()][lt.getB()];
            this.empty_fill(lt.getA(), lt.getB());
        }

        return points;

    }

    private void empty_fill(int a, int b) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                points[i][j] = new Point();
            }
        }
    }

}
