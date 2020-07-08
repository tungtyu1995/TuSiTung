package interface_abstract_class.baitap.resizeable;

public class Circle extends Shape  {
    private double radius;
    private double size;
    public void setSize(double size){
        this.size = size;
    }
    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSize() {
        this.size = this.radius*this.radius*Math.PI;
        return this.size;
    }
    @Override
    public String toString() {
        return "Circle Size = " + this.size;
    }
}
