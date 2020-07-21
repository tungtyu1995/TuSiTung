package ke_thua.baitap;

public class Point3D extends Point2D {
    float z;
    public Point3D(){
    }
    public Point3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getZ() {
        return z;
    }
    public void setXYZ(float x, float y, float z){
        super.setX(x);
        super.setY(y);
        setZ(z);
    }
    public float[] getXYZ(){
        float[] arr = {super.getX(),super.getY(),getZ()};
        return arr;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "Z=" + z +
                ", X=" + x +
                ", Y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);
        Point3D point3D1 = new Point3D();
        point3D = new Point3D(1,2,3);
        System.out.println(point3D);
    }
}
