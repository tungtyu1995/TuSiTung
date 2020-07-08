package interface_abstract_class.thuchanh;

import interface_abstract_class.thuchanh.animal.Animal;
import interface_abstract_class.thuchanh.animal.Chicken;
import interface_abstract_class.thuchanh.animal.Tiger;
import interface_abstract_class.thuchanh.edible.Edible;
import interface_abstract_class.thuchanh.fruit.Apple;
import interface_abstract_class.thuchanh.fruit.Fruit;
import interface_abstract_class.thuchanh.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits){
            System.out.println(fruit.howToEat());
        }
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
        }
    }
}
