package ke_thua.baitap;

public class Cylinder extends Circle {
    public double height;

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public Cylinder(double height) {
        this.height = height;
    }
    public double getVolume(){
        return this.height * getAre();
    }

    @Override
    public String toString() {
        return "The Radius"
                + getRadius()+
                 " The Color" +
                getColor()+
                "The Height" +
                getHeight()+
                 " The Volume "
                + getVolume();
    }
}
