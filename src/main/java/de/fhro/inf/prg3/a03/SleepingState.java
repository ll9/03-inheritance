package de.fhro.inf.prg3.a03;

public class SleepingState extends State {
    public SleepingState(Animal animal) {
        super(animal, animal.getSleep());
    }

    @Override
    State successor() {
        logger.info("Yawn getting hungry");
        return new HungryState(animal);
    }
}
