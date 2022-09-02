package org.genspark;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {
    private int id;
    private String name;
    private List<Phone> phones;
    private Address address;

    @Autowired
    public Student(@Value("#{1}") int id, @Value("#{'John Doe'}") String name,
                   @Value("#{T(java.util.List).of(phone)}") List<Phone> ph,
                   Address add) {
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
