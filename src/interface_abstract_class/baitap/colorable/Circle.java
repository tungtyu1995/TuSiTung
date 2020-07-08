package interface_abstract_class.baitap.colorable;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getAcreage() {
        return this.radius*this.radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle Acreage = : "+this.getAcreage();
    }
}
