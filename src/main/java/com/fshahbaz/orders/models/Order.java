package com.fshahbaz.orders.models;

import java.util.Objects;

public class Order {
    private int orderID;
    private int numberOfApples;
    private double pricePerApple;
    private int numberOfOranges;
    private double pricePerOrange;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getNumberOfApples() {
        return numberOfApples;
    }

    public void setNumberOfApples(int numberOfApples) {
        this.numberOfApples = numberOfApples;
    }

    public double getPricePerApple() {
        return pricePerApple;
    }

    public void setPricePerApple(double pricePerApple) {
        this.pricePerApple = .60; //60 cents per apple
    }

    public int getNumberOfOranges() {
        return numberOfOranges;
    }

    public void setNumberOfOranges(int numberOfOranges) {
        this.numberOfOranges = numberOfOranges;
    }

    public double getPricePerOrange() {
        return pricePerOrange;
    }

    public void setPricePerOrange(double pricePerOrange) {
        this.pricePerOrange = .40; //40 cent per orange
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && numberOfApples == order.numberOfApples && Double.compare(order.pricePerApple, pricePerApple) == 0 && numberOfOranges == order.numberOfOranges && Double.compare(order.pricePerOrange, pricePerOrange) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, numberOfApples, pricePerApple, numberOfOranges, pricePerOrange);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", numberOfApples=" + numberOfApples +
                ", pricePerApple=" + pricePerApple +
                ", numberOfOranges=" + numberOfOranges +
                ", pricePerOrange=" + pricePerOrange +
                '}';
    }
}
