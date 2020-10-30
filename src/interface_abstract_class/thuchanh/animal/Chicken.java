package interface_abstract_class.thuchanh.animal;

import interface_abstract_class.thuchanh.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
