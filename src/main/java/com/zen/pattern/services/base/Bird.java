package com.zen.pattern.services.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public abstract class Bird {
    public String layEggs(String bird) {
        log.info("this bird '{}' can lay eggs", bird);
        return String.format("%s can lay eggs", bird);
    }
}
