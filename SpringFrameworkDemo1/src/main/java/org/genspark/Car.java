package org.genspark;

public class Car implements Vehicle{
    public Tire ty;

    public Car() {
    }

    public Car(Tire ty) {
        this.ty = ty;
    }

    public Tire getTy() {
        return ty;
    }

    public void setTy(Tire ty) {
        this.ty = ty;
    }

    public void drive(){
        System.out.println("I am Driving a car. " + ty);
    }
}
