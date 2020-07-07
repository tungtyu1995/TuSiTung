package ke_thua.baitap;

public class Circle {
    public String color;
    public double radius;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.color = color;
        this.radius = radius;
    }
    public double getAre(){
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                +  " A Shape with color of " +
                getColor()
                + "The Area " + getAre();
    }
}