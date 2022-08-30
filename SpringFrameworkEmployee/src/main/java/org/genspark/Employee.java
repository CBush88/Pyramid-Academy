package org.genspark;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Employee {
    private int id;
    private String name;
    private List<Phone> ph;
    private Address add;

    @Autowired
    public Employee(@Value("1") int id, @Value("John Doe") String name, List<Phone> ph, Address add) {
        this.id = id;
        this.name = name;
        this.ph = ph;
        this.add = add;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \nph=" + ph +
                ", \nadd=" + add + "\n" +
                '}';
    }
}
