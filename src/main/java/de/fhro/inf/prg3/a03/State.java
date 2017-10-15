package de.fhro.inf.prg3.a03;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected static final Logger logger = LogManager.getLogger();
    protected Animal animal;
    private int t = 0;
    private int duration;

    public State(Animal animal, int duration) {
        this.animal = animal;
        this.duration = duration;
    }

    State tick() {
        logger.info("tick()");
        t++;
        if (t < duration) {
            return this;
        }
        else {
            return successor();
        }
    }

    abstract State successor();
}
