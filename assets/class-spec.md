@startuml
enum GenusSpecies {

    LION,
    GAZELLE,
    FLAMINGO

	-readableType: String
    -type: String

    +String getReadableType()
    +String getType()
}

class ZooElement {
    -id: int

    #ZooElement(boolean isGround)

    +int getId()
    +boolean isGround()
    +abstract void tick()
}

class Animal {
	-sleep: int
    -awake: int
    -digest: int

    -currentState: State

    -name: String
    -genusSpecies: GenusSpecies
    -devours: GenusSpecies[]
    -collectionAmount: int
    
    +void feed()
    +boolean devours(Animal other)

    +boolean isAsleep()
    +boolean isPlayful()
    +boolean isHungry()
    +boolean isDigesting()

    +int getSleep()
    +int getDigest()
    +int getAwake()
    +String getName()
}

class Decoration {
    -type: String

    +String getType()
}

class Ground {
    -type: String

    +String getType()
}

abstract class State {
	#{static}logger: Logger
    #animal: Animal
    -t: int
    -duration: int
    State tick()
    abstract State successor()
}

class DigestingState {
}

class HungryState {
    State feed()
}

class PlayfulState {
}

class SleepingState {
}

class DeathState {
}

State *-- Animal : current state
GenusSpecies *-- Animal: genus species
GenusSpecies "n" *-- Animal: devours

ZooElement <|-- Animal
ZooElement <|-- Decoration
ZooElement <|-- Ground

State <|-- DigestingState
State <|-- HungryState
State <|-- PlayfulState
State <|-- SleepingState
State <|-- DeathState
@enduml