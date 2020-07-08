package interface_abstract_class.thuchanh;


import ke_thua.thuchanh.Circle;


import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
       Circle[] circles = new Circle[3];
       circles[0] = new Circle(3.6);
       circles[1] = new Circle();
        circles[1].setColor("White");
       circles[2] = new Circle(3.5,"indigo",false);

        System.out.println("Pre-sorted: ");
        for (Circle c : circles){
            System.out.println(c);
        }

        Comparator circleComparator = new CircleComparator();
       Arrays.sort(circles, circleComparator);

        System.out.println("After-sorter");
        for (Circle c : circles){
            System.out.println(c);
        }

    }
}
