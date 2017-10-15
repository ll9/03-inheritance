package de.fhro.inf.prg3.a03;

public class DeathState extends State {
    public DeathState(Animal animal) {
        super(animal, 0);
    }

    @Override
    State successor() {
        return null;
    }
}
