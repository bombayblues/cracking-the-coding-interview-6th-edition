package com.github.bombayblues.ctci.ch3.animalshelter;

import java.util.LinkedList;

/**
 * Problem:
 * <p>
 * Assume a shelter who accepts only Dogs and Cats in first in first out basis.
 * If the customer has no preference they are handed a dog or a cat which is the oldest
 * If customer has preference, corresponding oldest animal is handed.
 * <p>
 * Solution:
 * Use two LinkedList to hold Dogs and Cats.
 * Enqueue Animal adds animal to appropriate stack
 * Dequeue Animal removes from appropriate stack
 * DequeueAny removes oldest of the two animals
 */
public class AnimalQueue {

    private final LinkedList<Dog> dogs = new LinkedList<Dog>();
    private final LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order;

    public void enqueue(final Animal animal) {
        animal.setOrder(this.order);
        this.order++;

        if (animal instanceof Dog) {
            this.dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            this.cats.addLast((Cat) animal);
        }
    }

    public Dog dequeueDog() {
        return this.dogs.poll();
    }

    public Cat dequeueCat() {
        return this.cats.poll();
    }

    public Animal dequeueAny() {
        if (this.dogs.isEmpty()) {
            return this.cats.poll();
        } else if (this.cats.isEmpty()) {
            return this.cats.poll();

        }
        final Dog dog = this.dogs.peek();
        final Cat cat = this.cats.peek();

        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }

    }

}


