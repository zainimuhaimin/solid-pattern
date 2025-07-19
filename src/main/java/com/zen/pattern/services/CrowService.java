package com.zen.pattern.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrowService implements FlyableService, WalkableService{
    @Override
    public String fly(String bird) {
        return String.format("%s can fly", bird);
    }

    @Override
    public String walk(String bird) {
        return String.format("%s can walk", bird);
    }
}
