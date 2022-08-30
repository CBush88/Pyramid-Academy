package org.genspark;

import org.springframework.stereotype.Component;

@Component
public class Exynos implements MobileProcessor{

    public void processor(){
        System.out.println("Exynos");
    }
}
