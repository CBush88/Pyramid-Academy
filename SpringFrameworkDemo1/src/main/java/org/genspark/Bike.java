package org.genspark;

public class Bike implements Vehicle{
    public Tire ty;

    public Bike() {
    }

    public Bike(Tire ty) {
        this.ty = ty;
    }

    public Tire getTy() {
        return ty;
    }

    public void setTy(Tire ty) {
        this.ty = ty;
    }

    public void drive(){
        System.out.println("I'm riding a bike. " + ty);
    }
}
