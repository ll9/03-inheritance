package de.fhro.inf.prg3.a03;

public class HungryState extends State {
    public HungryState(Animal animal) {
        super(animal, animal.getAwake(), "hungry");
    }

    @Override
    State successor() {
        logger.info("I've starved for a too long time...good bye...");
        return new DeathState(animal);
    }

    State feed() {
        logger.info("You feed the cat...");
        return new DigestingState(animal);
    }
}
