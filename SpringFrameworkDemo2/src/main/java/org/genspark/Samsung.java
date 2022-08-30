package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Samsung {
    @Autowired
    @Qualifier("exynos")
    MobileProcessor cpu;

    public void config(){
        System.out.println("Processor: Quad Core | RAM: 16 GB | Cam: 32 Mpx");
        cpu.processor();
    }
}
