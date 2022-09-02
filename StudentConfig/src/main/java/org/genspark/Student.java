package org.genspark;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Phone> phones;
    private Address address;

    public Student(int id, String name, List<Phone> ph, Address add) {
        this.id = id;
        this.name = name;
        this.phones = ph;
        this.address = add;
    }

    @Override
    public String toString() {
        return "Student{" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \nphones=" + phones +
                ", \naddress=" + address + "\n" +
                '}';
    }
}
