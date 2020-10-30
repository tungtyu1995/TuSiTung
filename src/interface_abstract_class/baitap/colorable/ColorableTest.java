package interface_abstract_class.baitap.colorable;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] arr = new Shape[3];
        arr[0] = new Circle(5);
        arr[1] = new Rectangle(5,10);
        arr[2] = new Square(10);
        for (Shape shape : arr) {
            if (shape instanceof Square) {
                ((Square) shape).howToColor();
            }
            System.out.println(shape.toString());
        }
    }
}
