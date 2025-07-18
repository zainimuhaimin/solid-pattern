package com.zen.pattern.services;

import com.zen.pattern.services.base.Bird;
import org.springframework.stereotype.Service;

@Service
public class PenguinService extends Bird implements SwimableService {
    @Override
    public String swim(String bird) {
        this.layEggs(bird);
        return String.format("penguin can swim");
    }
}
