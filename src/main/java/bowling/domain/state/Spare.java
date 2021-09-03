package bowling.domain.state;

import bowling.domain.pins.Pins;
import bowling.exception.InvalidSpareException;

public class Spare extends Finished {

    private final Pins firstRoll;
    private final Pins secondRoll;

    private Spare(Pins firstRoll, Pins secondRoll) {
        validate(firstRoll, secondRoll);
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public static Spare of(Pins firstRoll, Pins secondRoll) {
        return new Spare(firstRoll, secondRoll);
    }

    public static Spare of(int firstRoll, int secondRoll) {
        return new Spare(Pins.of(firstRoll), Pins.of(secondRoll));
    }

    @Override
    public String description() {
        return firstRoll.description(secondRoll);
    }

    private void validate(Pins firstRoll, Pins secondRoll) {
        if (!firstRoll.isSpare(secondRoll)) {
            throw new InvalidSpareException();
        }
    }
}
