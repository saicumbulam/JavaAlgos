package Legacy.Algorithms.Stack.AnimalShelter;

import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;

        if (a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if ( a instanceof Cat) {
            cats.addLast((Cat) a);
        }
    }

    public Animal dequeueAny(){
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0){
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOrlderThan(cat)){
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }
}


class Dog extends Animal {
    public Dog(String n) {super(n);}
}

class Cat extends Animal {
    public Cat(String n) {super(n);}
}