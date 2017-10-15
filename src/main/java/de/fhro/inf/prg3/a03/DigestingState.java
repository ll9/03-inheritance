package de.fhro.inf.prg3.a03;

public class DigestingState extends State {
    public DigestingState(Animal animal) {
        super(animal, animal.getDigest(), "digesting");
    }

    @Override
    State successor() {
        logger.info("Getting in a playful mood!");
        return new PlayfulState(animal);
    }
}
