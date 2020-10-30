package interface_abstract_class.baitap.resizeable;

public class Square extends Shape {
    private double side;
    private double size;

    public void setSize(double size) {
        this.size = size;
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getSize() {
        this.size = this.side*this.side;
        return this.size;
    }
    @Override
    public String toString() {
        return " SquareSize = " + this.size;
    }
}
