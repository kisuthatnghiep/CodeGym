package Abstract;

public abstract class Animal {
    public abstract String makeSound();
}

interface Edible{
    String howToEat();
}

class Tiger extends Animal{

    @Override
    public String makeSound() {
        return "Tiger: roar";
    }
}

class Chicken extends Animal implements Edible{

    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}

abstract class Fruit implements Edible{
}

class Orange extends Fruit{

    @Override
    public String howToEat() {
        return "Orange could be juiced";
    }
}

class Apple extends Fruit{

    @Override
    public String howToEat() {
        return "Apple could be sliced";
    }
}

class Main{
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal:animals){
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken){
                System.out.println(((Chicken) animal).howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Fruit fruit:fruits){
            System.out.println(fruit.howToEat());
        }
    }
}