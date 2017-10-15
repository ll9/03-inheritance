package de.fhro.inf.prg3.a03;

public class PlayfulState extends State {
    public PlayfulState(Animal animal) {
        super(animal, animal.getAwake()-animal.getDigest(), "playful");
    }

    @Override
    State successor() {
        logger.info("Yoan... getting tired!");
        return new SleepingState(animal);
    }
}
