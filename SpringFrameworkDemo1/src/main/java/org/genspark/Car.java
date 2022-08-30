package org.genspark;

public class Car implements Vehicle{
    public Tire ty;

    public Car() {
    }

    public Car(Tire ty) {
        //demonstrate runs before init
        System.out.println("Constructing car");
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
    public void init(){
        //runs after construction and before other main methods
        System.out.println("Initializing");
    }
    public void destroy(){
        //runs on context close
        System.out.println("Destroying");
    }
}
