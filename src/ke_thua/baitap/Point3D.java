package ke_thua.baitap;

public class Point3D extends Point2D {
    float Z = 0.0f;
    public Point3D(){
    }
    public Point3D(float x, float y, float z){
        super(x, y);
        this.Z = z;
    }

    public void setZ(float z) {
        Z = z;
    }

    public float getZ() {
        return Z;
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
                "Z=" + Z +
                ", X=" + X +
                ", Y=" + Y +
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
