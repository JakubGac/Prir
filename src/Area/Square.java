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
}
