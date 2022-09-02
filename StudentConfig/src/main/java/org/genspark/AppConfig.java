package org.genspark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.genspark")
public class AppConfig {
    @Bean
    @Primary
    public Phone getPhone(){
        return new Phone("555-123-4567");
    }
    @Bean Phone getPhone2(){
        return new Phone("555-234-5678");
    }
    @Bean
    public List<Phone> getPhoneList(Phone phone, Phone phone2){
        return List.of(phone, phone2);
    }
    @Bean
    public Address getAddress(){
        return new Address("Atlanta", "Georgia", "US", "30303");
    }
    @Bean
    public Student getStudent(List<Phone> phoneList, Address address){
        return new Student(1, "John Doe", phoneList, address);
    }
}
