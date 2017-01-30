package com.github.bombayblues.ctci.ch3.animalshelter;

/**
 * Created by @author bombayblues on 1/30/17.
 */
public abstract class Animal {

    private int order;
    private String name;

    public Animal(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(final int order) {
        this.order = order;
    }

    public boolean isOlderThan(final Animal o) {
        return this.getOrder() < o.getOrder();
    }
}
