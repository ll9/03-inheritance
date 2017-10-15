package de.fhro.inf.prg3.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


/**
 * @author Peter Kurfer
 * Created on 10/7/17.
 */
public class Animal {

	private static final Logger logger = LogManager.getLogger();

	private State state;

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	// money you make, when people watch your animal
	private final int collectionAmount;
	private final GenusSpecies genusSpecies;

	// those species this animal likes to eat
	private final GenusSpecies[] devours;

	private int time = 0;
	private int timeSinceFeed;

	public Animal(GenusSpecies genusSpecies, String name, GenusSpecies[] devours, int sleep, int awake, int digest, int collectionAmount) {
		this.name = name;
		this.genusSpecies = genusSpecies;
		this.devours = devours;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		this.collectionAmount = collectionAmount;
		this.state = new SleepingState(this);

		Arrays.sort(this.devours);
	}

	public void tick(){
		state = state.tick();
		logger.info(state.getName());

	}

	public void feed(){
		if (!state.getClass().equals(HungryState.class))
			throw new IllegalStateException("Can't stuff a cat...");

		state = ((HungryState) state).feed();

	}

	public boolean devours(Animal other){
		return Arrays.binarySearch(this.devours, other.genusSpecies) >= 0;
	}

	public String getName() {
		return name;
	}

	public int collect() {
		if(!isPlayful()){
			throw new IllegalStateException("One does not simply collect if the animal is not playful!");
		}
		return collectionAmount;
	}

	public boolean isAsleep() {
		return state.getClass().equals(SleepingState.class);
	}

	public boolean isPlayful() {
		return state.getClass().equals(PlayfulState.class);
	}

	public boolean isHungry() {
		return state.getClass().equals(HungryState.class);
	}

	public boolean isDigesting() {
		return state.getClass().equals(DigestingState.class);
	}

	public boolean isDead() {
		return state.getClass() == DeathState.class;
	}

	public int getSleep() {
		return sleep;
	}

	public int getAwake() {
		return awake;
	}

	public int getDigest() {
		return digest;
	}
}
