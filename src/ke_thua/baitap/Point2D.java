package ke_thua.baitap;

public class Point2D {
    float X = 0.0f;
    float Y = 0.0f;

    public Point2D() {

    }

    public Point2D(float x, float y) {
        this.X = x;
        this.Y = y;
    }

    public float getX() {
        return X;
    }

    public void setX(float x) {
        this.X = x;
    }

    public void setY(float y) {
        this.Y = y;
    }

    public float getY() {
        return Y;
    }

    public float[] getXY() {
        float[] arr = {X, Y};
        return arr;
    }

    public void setXY(float x, float y) {
        this.X = x;
        this.Y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }

    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        Point2D point2D1 = new Point2D();
        point2D = new Point2D(9 ,10);
        System.out.println(point2D);
    }
}

