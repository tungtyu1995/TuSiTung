package ke_thua.baitap;

public class Point2D {
    float x = 0.0f;
    float y = 0.0f;

    public Point2D() {

    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public float[] getXY() {
        float[] arr = {x, y};
        return arr;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "X=" + x +
                ", Y=" + y +
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

