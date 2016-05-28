package Area;
import Condition.*;
/**
 * Created by Dante on 23.05.2016.
 */
public class Point {

    private int value;
    private Condition condition;
    private boolean if_edge;
    private int x;
    private int y;

    public Point() {
        this.if_edge = false;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public Condition getCondition() {
        return condition;
    }

    public boolean getIf_edge() {
        return if_edge;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setIf_edge(boolean if_edge) {
        this.if_edge = if_edge;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
