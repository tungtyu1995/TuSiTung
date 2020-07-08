package interface_abstract_class.baitap.resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] arr = new Shape[3];
        arr[0] = new Circle(10);
        arr[1] = new Rectangle(10,20);
        arr[2] = new Square (20);
        System.out.println("-Before-");
        for (Shape shape:arr) {
            shape.getSize();
            System.out.println(shape.toString());
        }
        System.out.println("-After-");
        for (Shape shape:arr) {
            double size = shape.resize(shape.getSize(),30);
            if (shape instanceof Circle) {
                ((Circle)shape).setSize(size);
            } else if (shape instanceof Rectangle) {
                ((Rectangle)shape).setSize(size);
            } else if (shape instanceof Square) {
                ((Square)shape).setSize(size);
            }
            System.out.println(shape.toString());
        }
    }
}
