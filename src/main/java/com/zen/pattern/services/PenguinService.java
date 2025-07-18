package com.zen.pattern.services;

import com.zen.pattern.services.base.Bird;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PenguinService extends Bird implements SwimableService {

    /**
     * di subclass ini lo bisa bikin method yang sama dari superclassnya dan bisa lo ubah result bahkan logicnya
     * @param bird
     * @return
     */
    @Override
    public String layEggs(String bird) {
        log.info("penguin has blue eggs");
        return String.format("penguin has blue eggs");
    }


    @Override
    public String swim(String bird) {
        this.layEggs(bird);
        return String.format("penguin can swim");
    }
}
