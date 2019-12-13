package com.example.demo.model;

public class Trip {
    private MyDate start;
    private MyDate end;
    private String destination;
    private double price;
    private double finalPrice;

    public Trip(MyDate start, MyDate end, String destination, double price) {
        this.start = start;
        this.end = end;
        this.destination = destination;
        this.price = price;

    }

    public Trip() {
    }

    public MyDate getStart() {
        return start;
    }

    public void setStart(MyDate start) {
        this.start = start;
    }

    public MyDate getEnd() {
        return end;
    }

    public void setEnd(MyDate end) {
        this.end = end;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "start=" + start +
                ", end=" + end +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", finalPrice=" + finalPrice +
                '}';
    }
}


