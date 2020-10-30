package ke_thua.thuchanh;

import org.w3c.dom.ls.LSOutput;

public class Shape {
    private String color = "green";
    private boolean filled = true;

    public Shape() {

    }

    public String getColor() {
        return color;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    @Override
    public String toString() {
        return " A Shape with color of " +
                getColor() + " and " +
                (isFilled() ? " filled " : " not filled ");

    }

}



