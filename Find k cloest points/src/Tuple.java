/**
 * @param <X>
 * @param <Y>
 */
public class Tuple<Double> {
    public final double x;
    public final double y;
    public Tuple(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}