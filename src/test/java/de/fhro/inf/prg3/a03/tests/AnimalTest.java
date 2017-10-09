package de.fhro.inf.prg3.a03.tests;

import de.fhro.inf.prg3.a03.Animal;
import de.fhro.inf.prg3.a03.GenusSpecies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 10/7/17.
 */
public class AnimalTest {

	private static final int Sleep = 10;
	private static final int Awake = 5;
	private static final int Digest = 10;

	private Animal animal;

	@BeforeEach
	void setUp() {
		animal = new Animal(GenusSpecies.FLAMINGO, "Horst", new GenusSpecies[0], Sleep, Awake, Digest, 10);
	}

	@Test
	void testFeedHungryAnimal() {
		IntStream.range(0, Sleep).forEach(i -> animal.tick());
		assertTrue(animal.isHungry());
		animal.feed();
		assertTrue(animal.isDigesting());
	}

	@Test
	void testFeedNotHungryAnimal(){
		assertFalse(animal.isHungry());
		assertThrows(IllegalStateException.class, () -> animal.feed());
	}

	@Test
	void testAnimalGettingPlayful() {
		//Waiting while animal is sleeping
		IntStream.range(0, Sleep).forEach(i -> animal.tick());
		animal.feed();
		//Waiting while animal is digesting
		IntStream.range(0, Digest).forEach(i -> animal.tick());
		assertTrue(animal.isPlayful());
	}

	@Test
	void testAnimalDying(){
		//Waiting while animal is sleeping and awake before it's going to die
		IntStream.range(0, Sleep + Awake).forEach(i -> animal.tick());
		assertTrue(animal.isDead());
	}

	@Test
	void testAnimalIsGoingToSleepAgain(){
		//Waiting while animal is sleeping
		IntStream.range(0, Sleep).forEach(i -> animal.tick());
		animal.feed();
		//Waiting while animal is digesting and in playful mood
		IntStream.range(0, Digest + Awake).forEach(i -> animal.tick());
		assertTrue(animal.isAsleep());
	}
}
