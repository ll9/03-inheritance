package de.fhro.inf.prg3.a03;

/**
 * @author Peter Kurfer
 * Created on 10/7/17.
 */
public enum GenusSpecies {

	LION("Panthera leo", "Lion"),
	GAZELLE("Gazella leptoceros", "Gazelle"),
	FLAMINGO("Phoenicopterus jamesi", "Flamingo");

	private String readableType;
	private String type;

	GenusSpecies(String readableType, String type) {
		this.readableType = readableType;
		this.type = type;
	}

	public String getReadableType() {
		return readableType;
	}

	public String getType() {
		return type;
	}

}
