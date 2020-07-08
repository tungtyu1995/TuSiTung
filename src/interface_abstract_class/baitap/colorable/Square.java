package interface_abstract_class.baitap.colorable;

public class Square extends Shape implements Colorable {
    private double side;

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
    public void howToColor() {
        System.out.println("Square: Color all four sides");
    }

    @Override
    public double getAcreage() {
        return this.side*this.side;
    }

    @Override
    public String toString() {
        return "Square Acreage:"+this.getAcreage();
    }
}
