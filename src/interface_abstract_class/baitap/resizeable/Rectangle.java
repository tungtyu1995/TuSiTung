package interface_abstract_class.baitap.resizeable;

public class Rectangle extends Shape {
    private double width;
    private double height;
    private double size;

    public void setSize(double size) {
        this.size = size;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getSize() {
        this.size = this.width*this.height;
        return this.size;
    }
    @Override
    public String toString() {
        return " RectangleSize = " +this.size;
    }
}
