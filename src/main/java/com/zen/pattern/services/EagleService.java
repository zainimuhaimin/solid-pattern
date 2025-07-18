package com.zen.pattern.services;

import com.zen.pattern.services.base.Bird;
import org.springframework.stereotype.Service;

@Service
public class EagleService extends Bird implements FlyableService {
    @Override
    public String fly(String bird) {
        this.layEggs(bird);
        return String.format("Eagle can fly");
    }
}
