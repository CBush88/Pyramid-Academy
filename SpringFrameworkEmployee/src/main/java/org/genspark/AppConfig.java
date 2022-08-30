package org.genspark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    @Primary
    public Phone getPhone(){
        return new Phone("555-123-4567");
    }
    @Bean
    public Phone getSecondPhone(){
        return new Phone("555-234-5678");
    }
    @Bean
    public List<Phone> getPhoneList(Phone phone1, Phone phone2){
        return Arrays.asList(phone1, phone2);
    }
}
