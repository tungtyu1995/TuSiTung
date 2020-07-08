package interface_abstract_class.baitap.resizeable;

public abstract class Shape implements Resizeable {
    public abstract double getSize();

    @Override
    public double resize (double size, double perecent) {
        return size*(1+perecent/100);
    }
}
